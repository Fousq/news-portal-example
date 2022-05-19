package org.zhumagulova.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.zhumagulova.models.News;

import java.util.Optional;

@Component
public class LanguageDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LanguageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Long> getIdByLanguageCode(String langCode) {
        News news = jdbcTemplate.queryForObject("SELECT id from languages where value = ?", new BeanPropertyRowMapper<>(News.class), langCode);
        if (news == null) {
            return Optional.empty();
        }
        return Optional.of(news.getId());
    }
}

