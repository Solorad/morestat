package com.morenkov.ee.morestat.web.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author emorenkov
 */
@RestController
@RequestMapping("/rest")
public class RestMorestatResource {
    private static final Logger LOG = LogManager.getLogger(RestMorestatResource.class);

    private final SessionLocaleResolver localeResolver;

    @Autowired
    public RestMorestatResource(SessionLocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
    }

    @RequestMapping(value = "/locale", method= RequestMethod.GET)
    void setLocale(String localeStr, HttpServletRequest request, HttpServletResponse response) {
        if (isEmpty(localeStr)) {
            LOG.error("Locale String must be not empty!");
            return;
        }
        Locale locale = Locale.forLanguageTag(localeStr);
        LOG.debug("Setting locale to {}", locale);
        localeResolver.setLocale(request, response, locale);
    }
}
