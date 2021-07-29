package ru.job4j.shortcut.services.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.job4j.shortcut.domains.Site;
import ru.job4j.shortcut.repositpries.SiteRepository;
import java.util.List;
import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SiteRepository siteRepository;

    public UserDetailsServiceImpl(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        List<Site> sites = siteRepository.findByLogin(login);
        if (sites.isEmpty()) {
            throw new UsernameNotFoundException(login);
        }
        Site site = sites.get(0);
        return new User(site.getLogin(), site.getPassword(), emptyList());
    }
}
