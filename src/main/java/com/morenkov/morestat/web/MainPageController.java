package com.morenkov.morestat.web;

import com.morenkov.morestat.dto.users.basicinfo.UserInfoData;
import com.morenkov.morestat.dto.users.feed.MediaFeed;
import com.morenkov.morestat.dto.users.feed.MediaFeedData;
import com.morenkov.morestat.exceptions.InstagramException;
import com.morenkov.morestat.service.UserInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    public MainPageController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
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

        model.addAttribute("oauth2ClientContext", httpSession.getAttribute(USER));

        try {
            MediaFeed recentMediaFeed = userInfoService.getRecentMediaFeed(userInfoData.getId());

            List<MediaFeedData> mediaFeed = recentMediaFeed.getData();
            int totalLikes = mediaFeed.stream().collect(
                    Collectors.summingInt((MediaFeedData data) -> data.getLikes().getCount()));
            int totalComments = mediaFeed.stream().collect(
                    Collectors.summingInt((MediaFeedData data) -> data.getComments().getCount()));

            List<MediaFeedData> sortedByLikesMedia = new ArrayList<>(mediaFeed);
            sortedByLikesMedia.sort(
                    (MediaFeedData data1, MediaFeedData data2)
                            -> data2.getLikes().getCount() - data1.getLikes().getCount());
            List<MediaFeedData> sortedByCommentsMedia = new ArrayList<>(mediaFeed);
            sortedByCommentsMedia.sort(
                    (MediaFeedData data1, MediaFeedData data2)
                            -> data2.getComments().getCount() - data1.getComments().getCount());

            model.addAttribute("totalLikes", totalLikes);
            model.addAttribute("totalComments", totalComments);
            model.addAttribute("sortedByLikesMedia", sortedByLikesMedia);
            model.addAttribute("sortedByCommentsMedia", sortedByCommentsMedia);

        } catch (InstagramException e) {
            log.error("Instagram exception occurred.");
        }
        return "profile";
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
