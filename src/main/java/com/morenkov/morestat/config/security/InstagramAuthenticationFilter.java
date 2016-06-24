package com.morenkov.morestat.config.security;

import com.morenkov.morestat.dto.InstagramResult;
import com.morenkov.morestat.dto.users.basicinfo.UserInfo;
import com.morenkov.morestat.dto.users.basicinfo.UserInfoData;
import com.morenkov.morestat.utils.Queries;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetailsSource;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author emorenkov
 */
public class InstagramAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private static final Logger logger = LogManager.getLogger(InstagramAuthenticationFilter.class);
    public static final String USER = "instagramUser";

    private final RestTemplate restTemplate;
    private final OAuth2ProtectedResourceDetails client;
    private final OAuth2ClientContext context;

    private final String redirectUri;

    private AuthenticationDetailsSource<HttpServletRequest, ?>
            authenticationDetailsSource = new OAuth2AuthenticationDetailsSource();

    public InstagramAuthenticationFilter(String defaultFilterProcessesUrl,
                                         OAuth2ProtectedResourceDetails client,
                                         OAuth2ClientContext oauth2ClientContext,
                                         RestTemplate restTemplate,
                                         Environment environment) {
        super(defaultFilterProcessesUrl);
        setAuthenticationDetailsSource(authenticationDetailsSource);
        this.context = oauth2ClientContext;
        this.client = client;
        this.restTemplate = restTemplate;
        redirectUri = environment.getProperty("instagram.resource.redirectUri");
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
            }
            HttpSession session = request.getSession();
            UserInfoData instagramUser = getSelfResult(accessToken.getValue()).getData();
            oAuth2Authentication = extractAuthentication(instagramUser.getId());
            session.setAttribute(USER, instagramUser);

            request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_VALUE, accessToken.getValue());
            request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE, accessToken.getTokenType());
            oAuth2Authentication.setDetails(authenticationDetailsSource.buildDetails(request));
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
        body.add("redirect_uri", redirectUri);
        body.add("code", code);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, requestHeaders);
        ResponseEntity<InstagramResult> exchange = restTemplate
                .postForEntity(client.getAccessTokenUri(), entity, InstagramResult.class);
        return exchange.getBody();
    }

    private UserInfo getSelfResult(String accessToken) {
        ResponseEntity<UserInfo> exchange = restTemplate
                .exchange(Queries.SELF_INFO, HttpMethod.GET, null, UserInfo.class, accessToken);
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
