package org.zhumagulova.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.zhumagulova.dao.NewsDao;
import org.zhumagulova.models.News;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// if using Mockito annotation is desirable, then use @ExtendWith
public class NewsControllerTest {

    @InjectMocks
    private NewsController newsController;

    @Mock
    private NewsDao newsDao;

    private MockMvc mockMvc;

    private String languageCode = "en";

    @BeforeEach
    public void setup() {
        // redundant because there's a DI in testable class
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(newsController).build();
    }

    @Test
    public void index() throws Exception {
        News first = new News();
        first.setTitle("test title");
        News second = new News();
        List<News> list = Arrays.asList(first, second);
        when(newsDao.getAllNews(languageCode)).thenReturn(list);

        mockMvc.perform(get("/news"))
                .andExpect(status().isOk())
                .andExpect(view().name("news/getAllNews"))
                .andExpect(model().attribute("all_news", hasItems(first)));
    }

    @Test
    public void show() throws Exception {
        long id = 5;
        News testNews = new News();
        testNews.setId(id);
        when(newsDao.getById(id, languageCode)).thenReturn(testNews);

        mockMvc.perform(get("/news/5"))
                .andExpect(status().isOk())
                .andExpect(view().name("news/getById"))
                .andExpect(model().attribute("news", instanceOf(News.class)));
    }

    @Test
    public void newNews() {
    }

    @Test
    public void create() {
    }

    @Test
    public void edit() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}