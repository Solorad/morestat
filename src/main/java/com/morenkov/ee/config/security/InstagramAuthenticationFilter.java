package com.morenkov.ee.config.security;

import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
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

/**
 * @author emorenkov
 */
public class InstagramAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private RestTemplate restTemplate = new RestTemplate();
    private ResourceServerTokenServices tokenServices;
    private OAuth2ProtectedResourceDetails client;
    private OAuth2ClientContext context;

    private AuthenticationDetailsSource<HttpServletRequest, ?>
            authenticationDetailsSource = new OAuth2AuthenticationDetailsSource();

    public InstagramAuthenticationFilter(String defaultFilterProcessesUrl, OAuth2ClientContext oauth2ClientContext) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(new NoopAuthenticationManager());
        setAuthenticationDetailsSource(authenticationDetailsSource);
        this.context = oauth2ClientContext;
    }


    /**
     * Reference to a CheckTokenServices that can validate an OAuth2AccessToken
     *
     * @param tokenServices
     */
    public void setTokenServices(ResourceServerTokenServices tokenServices) {
        this.tokenServices = tokenServices;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        OAuth2AccessToken accessToken = context.getAccessToken();

        try {
            if (accessToken == null || accessToken.isExpired()) {
                InstagramResult instagramResult = getInstagramResponse(request);
                System.out.println(instagramResult);
                accessToken = tokenServices.readAccessToken(instagramResult.getAccess_token());
            }
            OAuth2Authentication result = tokenServices.loadAuthentication(accessToken.getValue());
            if (authenticationDetailsSource != null) {
                request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_VALUE, accessToken.getValue());
                request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE, accessToken.getTokenType());
                result.setDetails(authenticationDetailsSource.buildDetails(request));
            }
        } catch (InvalidTokenException e) {
            throw new BadCredentialsException("Could not obtain user details from token", e);
        } catch (Exception e) {
            logger.error(e);
        }
        return null;

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
        HttpEntity<MultiValueMap<String, String>> entity =
                new HttpEntity<>(body, requestHeaders);
        System.out.println("here");
        ResponseEntity<InstagramResult> exchange = restTemplate
                .exchange(client.getAccessTokenUri(), HttpMethod.POST, entity, InstagramResult.class);
        return exchange.getBody();
    }

    public void setClientResources(OAuth2ProtectedResourceDetails client) {
        this.client = client;
    }


    private static class NoopAuthenticationManager implements AuthenticationManager {

        @Override
        public Authentication authenticate(Authentication authentication)
                throws AuthenticationException {
            throw new UnsupportedOperationException("No authentication should be done with this AuthenticationManager");
        }

    }
}
