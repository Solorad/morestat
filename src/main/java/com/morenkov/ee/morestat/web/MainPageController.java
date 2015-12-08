package com.morenkov.ee.morestat.web;

import com.morenkov.ee.morestat.dto.UserStats;
import com.morenkov.ee.morestat.utils.constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;
import org.jinstagram.entity.common.Comments;
import org.jinstagram.entity.common.ImageData;
import org.jinstagram.entity.common.Likes;
import org.jinstagram.entity.users.basicinfo.UserInfoData;
import org.jinstagram.entity.users.feed.MediaFeed;
import org.jinstagram.entity.users.feed.MediaFeedData;
import org.jinstagram.exceptions.InstagramException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author emorenkov
 */
@Controller
@SessionAttributes({"instagram", "instagramService"})
public class MainPageController {
    private static final Logger logger = LogManager.getLogger(MainPageController.class);
    private OAuth2RestTemplate oAuth2RestTemplate;

    public static final String ACTIVE_TAB = "activeTab";

    private InstagramService instagramService;
    private Instagram instagram;

    @Autowired
    public MainPageController(InstagramService instagramService, Instagram instagram) {
        this.instagramService = instagramService;
        this.instagram = instagram;
    }

    @ModelAttribute
    public void instagramAttribute(Model model) {
        if (instagram != null && instagram.getAccessToken() != null) {
            model.addAttribute(Constants.INSTAGRAM, instagram);
        }
    }

    @ModelAttribute("instagramService")
    public InstagramService instagramServiceAttribute() {
        return instagramService;
    }




    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("index() is executed!");
        if (isAllowedResource()) {
            return "profile";
        }

        model.addAttribute("authorizationUrl", instagramService.getAuthorizationUrl(null));
        return "index";
    }

    @RequestMapping(value={"/profile"})
    public String profile(Model model) {
        if (!isAllowedResource()) {
            return "index";
        }
        model.addAttribute(ACTIVE_TAB, "profile");

        try {
            UserInfoData userInfoData = instagram.getCurrentUserInfo().getData();
            model.addAttribute("userInfoData", userInfoData);
            MediaFeed recentMediaFeed = instagram.getRecentMediaFeed(userInfoData.getId());

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
            logger.error("Instagram exception occurred.");
        }
        return "profile";
    }




    @RequestMapping(value={"/gallery"})
    public String gallery(Model model) {
        logger.debug("gallery() is executed!");
        if (!isAllowedResource()) {
            return "index";
        }

        model.addAttribute(ACTIVE_TAB, "gallery");
        return "gallery";
    }

    @RequestMapping(value="/logout")
    public String logout(HttpSession session, Model model) {
        logger.debug("logout() is executed!");
        instagram.setAccessToken(null);
        model.addAttribute(ACTIVE_TAB, "logout");
        return "logout";
    }

    @RequestMapping(value="/popular")
    public String popular(Model model) {
        logger.debug("popular() is executed!");
        if (!isAllowedResource()) {
            return "index";
        }
        model.addAttribute(ACTIVE_TAB, "popular");
        return "popular";
    }

    @RequestMapping(value="/search")
    public String search(Model model) {
        logger.debug("search() is executed!");
        if (!isAllowedResource()) {
            return "index";
        }
        model.addAttribute(ACTIVE_TAB, "search");
        return "search";
    }

    private boolean isAllowedResource() {
        return instagram.getAccessToken() != null;
    }
}
