package ru.job4j.shortcut.repositpries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.job4j.shortcut.domains.Link;

import javax.transaction.Transactional;
import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Integer> {
    List<Link> findByCode(String code);
}
