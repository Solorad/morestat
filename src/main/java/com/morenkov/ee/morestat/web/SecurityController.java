package com.morenkov.ee.morestat.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author emorenkov
 */
@Controller

public class SecurityController {
    private static final Logger LOG = LogManager.getLogger(MainPageController.class);
    private final Instagram instagram;
    private final InstagramService instagramService;

    @Autowired
    public SecurityController(Instagram instagram, InstagramService instagramService) {
        this.instagram = instagram;
        this.instagramService = instagramService;
    }


    @RequestMapping(value = {"/login/oauth"})
    public String authorize(@RequestParam(value = "code", required = false) String code) {
        if (!isEmpty(code)) {
            Verifier verifier = new Verifier(code);

            Token accessToken = instagramService.getAccessToken(null, verifier);
            instagram.setAccessToken(accessToken);
            return "redirect:/profile";
        }
        return "redirect:/";
    }
}
