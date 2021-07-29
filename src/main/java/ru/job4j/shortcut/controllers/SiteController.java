package ru.job4j.shortcut.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.shortcut.domains.Site;
import ru.job4j.shortcut.domains.Views;
import ru.job4j.shortcut.services.SiteService;

@RestController
public class SiteController {
    private final SiteService siteService;

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @JsonView(Views.User.class)
    @PostMapping("/registration")
    public Site registration(@RequestBody Site site) {
        return siteService.createSite(site);
    }
}
