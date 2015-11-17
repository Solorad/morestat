package com.morenkov.ee.morestat.web;

import com.morenkov.ee.morestat.components.User;
import com.morenkov.ee.morestat.utils.constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author emorenkov
 */
@Controller
@SessionAttributes({"instagram", "instagramService"})
public class MainPageController {
    private static final Logger logger = LogManager.getLogger(MainPageController.class);

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
    public String index() {
        logger.debug("index() is executed!");
        return "index";
    }

    @RequestMapping(value={"/profile"})
    public String profile(@RequestParam(value = "code", required = false) String code) {
        if (!isEmpty(code)) {
            Verifier verifier = new Verifier(code);

            Token accessToken = instagramService.getAccessToken(null, verifier);
            instagram.setAccessToken(accessToken);
        }
        return "profile";
    }

    @RequestMapping(value={"/gallery"})
    public String gallery() {
        logger.debug("gallery() is executed!");
        return "gallery";
    }

    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        logger.debug("logout() is executed!");

        session.removeAttribute(Constants.INSTAGRAM);
        session.removeAttribute(Constants.INSTAGRAM_SERVICE);
        return "logout";
    }

    @RequestMapping(value="/popular")
    public String popular() {
        logger.debug("popular() is executed!");
        return "popular";
    }

    @RequestMapping(value="/search")
    public String search() {
        logger.debug("search() is executed!");
        return "search";
    }
}
