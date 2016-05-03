package com.morenkov.ee.morestat.web;

import com.morenkov.ee.morestat.utils.constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jinstagram.Instagram;
import org.jinstagram.auth.oauth.InstagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author emorenkov
 */
@Controller
@SessionAttributes({"jInstagram", "instagramService"})
public class MainPageController {
    private static final Logger logger = LogManager.getLogger(MainPageController.class);
//    private OAuth2RestTemplate oAuth2RestTemplate;

    public static final String ACTIVE_TAB = "activeTab";

    private InstagramService instagramService;
    private Instagram jInstagram;

    @Autowired
    public MainPageController(InstagramService instagramService, Instagram jInstagram) {
        this.instagramService = instagramService;
        this.jInstagram = jInstagram;
    }

    @ModelAttribute
    public void instagramAttribute(Model model) {
        if (jInstagram != null && jInstagram.getAccessToken() != null) {
            model.addAttribute(Constants.INSTAGRAM, jInstagram);
        }
    }

    @ModelAttribute("instagramService")
    public InstagramService instagramServiceAttribute() {
        return instagramService;
    }




    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("index() is executed!");

        model.addAttribute("authorizationUrl", instagramService.getAuthorizationUrl(null));
        return "index";
    }

    @RequestMapping(value={"/profile"})
    public String profile(Model model) {
        model.addAttribute(ACTIVE_TAB, "profile");

        /*try {
            UserInfoData userInfoData = jInstagram.getCurrentUserInfo().getData();
            model.addAttribute("userInfoData", userInfoData);
            MediaFeed recentMediaFeed = jInstagram.getRecentMediaFeed(userInfoData.getId());

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
        }*/
        return "profile";
    }




    @RequestMapping(value={"/gallery"})
    public String gallery(Model model) {
        logger.debug("gallery() is executed!");
        model.addAttribute(ACTIVE_TAB, "gallery");
        return "gallery";
    }
    
    @RequestMapping(value="/popular")
    public String popular(Model model) {
        logger.debug("popular() is executed!");
        model.addAttribute(ACTIVE_TAB, "popular");
        return "popular";
    }

    @RequestMapping(value="/search")
    public String search(Model model) {
        logger.debug("search() is executed!");
        model.addAttribute(ACTIVE_TAB, "search");
        return "search";
    }
}
