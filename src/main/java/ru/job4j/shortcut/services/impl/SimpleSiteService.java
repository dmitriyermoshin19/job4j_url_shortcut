package ru.job4j.shortcut.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.shortcut.domains.Site;
import ru.job4j.shortcut.repositpries.SiteRepository;
import ru.job4j.shortcut.services.SiteService;

import java.util.List;

@Service
public class SimpleSiteService implements SiteService {
    private final SiteRepository siteRepository;
    private final PasswordEncoder passwordEncoder;

    public SimpleSiteService(SiteRepository siteRepository, PasswordEncoder passwordEncoder) {
        this.siteRepository = siteRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public Site createSite(Site site) {
        List<Site> sites = siteRepository.findBySite(site.getSite());
        if (!sites.isEmpty()) {
            return new Site(false);
        }
        site.setLogin(site.getSite());
        String password = passwordEncoder.encode(site.getSite()).substring(0, 6);
        site.setPassword(passwordEncoder.encode(password));
        siteRepository.save(site);
        site.setPassword(password);
        site.setRegistration(true);
        return site;
    }
}
