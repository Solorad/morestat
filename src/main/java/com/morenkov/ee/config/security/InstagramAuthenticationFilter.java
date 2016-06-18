package com.morenkov.ee.config.security;

import com.morenkov.ee.config.security.dto.InstagramResult;
import com.morenkov.ee.config.security.dto.InstagramUser;
import com.morenkov.ee.config.security.dto.SelfResult;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetailsSource;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author emorenkov
 */
public class InstagramAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private static final Logger logger = LogManager.getLogger(InstagramAuthenticationFilter.class);

    // no need in OAuth2RestTemplate here.
    private final RestTemplate restTemplate = new RestTemplate();
    private final OAuth2ProtectedResourceDetails client;
    private final OAuth2ClientContext context;
    private final String userInfoUri;

    private AuthenticationDetailsSource<HttpServletRequest, ?>
            authenticationDetailsSource = new OAuth2AuthenticationDetailsSource();

    public InstagramAuthenticationFilter(String defaultFilterProcessesUrl,
                                         OAuth2ClientContext oauth2ClientContext,
                                         OAuth2ProtectedResourceDetails client,
                                         String userInfoUri) {
        super(defaultFilterProcessesUrl);
        setAuthenticationDetailsSource(authenticationDetailsSource);
        this.context = oauth2ClientContext;

        this.client = client;
        this.userInfoUri = userInfoUri + "?access_token={access_token}";
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        OAuth2Authentication oAuth2Authentication = null;
        try {
            OAuth2AccessToken accessToken = context.getAccessToken();
            if (accessToken == null || accessToken.isExpired()) {
                InstagramResult instagramResult = getInstagramResponse(request);
                logger.debug(instagramResult);
                accessToken = new DefaultOAuth2AccessToken(instagramResult.getAccess_token());
                context.setAccessToken(accessToken);
                oAuth2Authentication = extractAuthentication(instagramResult.getUser().getId());
            } else {
                InstagramUser instagramUser = getSelfResult(accessToken.getValue()).getData();
                oAuth2Authentication = extractAuthentication(instagramUser.getId());
            }
            if (authenticationDetailsSource != null) {
                request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_VALUE, accessToken.getValue());
                request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE, accessToken.getTokenType());
                oAuth2Authentication.setDetails(authenticationDetailsSource.buildDetails(request));
            }
        } catch (InvalidTokenException e) {
            throw new BadCredentialsException("Could not obtain user details from token", e);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return oAuth2Authentication;

    }

    private InstagramResult getInstagramResponse(HttpServletRequest request) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        String code = request.getParameter("code");

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", client.getClientId());
        body.add("client_secret", client.getClientSecret());
        body.add("grant_type", "authorization_code");
        body.add("redirect_uri", "http://localhost:8080/profile");
        body.add("code", code);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, requestHeaders);
        ResponseEntity<InstagramResult> exchange = restTemplate
                .postForEntity(client.getAccessTokenUri(), entity, InstagramResult.class);
        return exchange.getBody();
    }

    private SelfResult getSelfResult(String accessToken) {
        ResponseEntity<SelfResult> exchange = restTemplate
                .exchange(userInfoUri, HttpMethod.GET, null, SelfResult.class, accessToken);
        return exchange.getBody();
    }



    private OAuth2Authentication extractAuthentication(String principal) {
        List<GrantedAuthority> authorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        OAuth2Request request = new OAuth2Request(null, client.getClientId(), null, true, null,
                                                  null, null, null, null);
        return new OAuth2Authentication(request,
                                        new UsernamePasswordAuthenticationToken(principal, "N/A", authorities));
    }
}
