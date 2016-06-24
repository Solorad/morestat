package com.morenkov.morestat.web;

import com.morenkov.morestat.dto.users.basicinfo.UserInfoData;
import com.morenkov.morestat.service.SnapshotService;
import com.morenkov.morestat.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

import javax.servlet.http.HttpSession;

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

    @Autowired
    public MainPageController(UserInfoService userInfoService, SnapshotService snapshotService,
                              OAuth2ClientContext oauth2ClientContext) {
        this.userInfoService = userInfoService;
        this.snapshotService = snapshotService;
        this.oauth2ClientContext = oauth2ClientContext;
    }


    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        log.debug("index() is executed!");
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            return "redirect:profile";
        }
        model.addAttribute("unauthorized", true);
        model.addAttribute("activeTab", "index");
        return "index";
    }

    @RequestMapping(value = {"/profile"})
    public String profile(Model model, HttpSession httpSession) {
        log.debug("In profile!");
        model.addAttribute(ACTIVE_TAB, "profile");
        UserInfoData userInfoData = (UserInfoData) httpSession.getAttribute(USER);
        model.addAttribute("userInfoData", userInfoData);
        return "profile";
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
