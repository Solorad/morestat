package com.morenkov.morestat.web;

import com.morenkov.morestat.dto.users.basicinfo.UserInfoData;
import com.morenkov.morestat.service.SnapshotService;
import com.morenkov.morestat.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Locale;

import static com.morenkov.morestat.config.security.InstagramAuthenticationFilter.USER;

/**
 * @author emorenkov
 */
@Controller
@SessionAttributes({"jInstagram", "instagramService"})
public class MainPageController {
    private static final Logger log = LogManager.getLogger(MainPageController.class);
//    private OAuth2RestTemplate oAuth2RestTemplate;

    public static final String ACTIVE_TAB = "activeTab";

    private final UserInfoService userInfoService;
    private final SnapshotService snapshotService;
    private final OAuth2ClientContext oauth2ClientContext;
    private final LocaleResolver localeResolver;

    @Autowired
    public MainPageController(UserInfoService userInfoService, SnapshotService snapshotService,
                              OAuth2ClientContext oauth2ClientContext, LocaleResolver localeResolver) {
        this.userInfoService = userInfoService;
        this.snapshotService = snapshotService;
        this.oauth2ClientContext = oauth2ClientContext;
        this.localeResolver = localeResolver;
    }


    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        log.debug("index() is executed!");
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            return "redirect:profile";
        }
        model.addAttribute("activeTab", "index");
        return "index";
    }

    @RequestMapping(value = {"/profile"})
    public String profile(Model model, HttpSession httpSession) {
        log.debug("In profile!");
        model.addAttribute(ACTIVE_TAB, "profile");
        UserInfoData userInfoData = (UserInfoData) httpSession.getAttribute(USER);
        model.addAttribute("userInfoData", userInfoData);
        model.addAttribute("authorized", true);
        return "profile";
    }


    @RequestMapping(value = {"/privacypolicy"})
    public String privacypolicy(Model model, HttpServletRequest httpRequest) {
        model.addAttribute(ACTIVE_TAB, "privacypolicy");
        Locale locale = localeResolver.resolveLocale(httpRequest);
        log.debug("current locale = '{}'", locale);
        if ("ru".equals(locale.getLanguage())) {
            return "static/privacypolicy_ru";
        }
        return "static/privacypolicy_en";
    }

    @RequestMapping(value = {"/contacts"})
    public String contacts(Model model) {
        model.addAttribute(ACTIVE_TAB, "contacts");
        return "about";
    }

    @RequestMapping(value = {"/retrieveUserSnapshot"}, method = RequestMethod.POST)
    @ResponseBody
    public ListenableFuture<ResponseEntity<?>> buildSnapshot(HttpSession httpSession) {
        log.debug("In buildSnapshot!");
        UserInfoData userInfoData = (UserInfoData) httpSession.getAttribute(USER);
        return snapshotService.retrieveUserSnapshot(userInfoData, oauth2ClientContext.getAccessToken());
    }


    @RequestMapping(value = {"/gallery"})
    public String gallery(Model model) {
        log.debug("gallery() is executed!");
        model.addAttribute(ACTIVE_TAB, "gallery");
        return "gallery";
    }

    @RequestMapping(value = "/popular")
    public String popular(Model model) {
        log.debug("popular() is executed!");
        model.addAttribute(ACTIVE_TAB, "popular");
        return "popular";
    }

    @RequestMapping(value = "/search")
    public String search(Model model) {
        log.debug("search() is executed!");
        model.addAttribute(ACTIVE_TAB, "search");
        return "search";
    }
}
