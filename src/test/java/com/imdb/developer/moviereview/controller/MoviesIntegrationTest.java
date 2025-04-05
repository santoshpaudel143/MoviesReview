package com.imdb.developer.moviereview.controller;

import com.imdb.developer.moviereview.service.MoviesService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: Santosh Paudel
 */

public class MoviesIntegrationTest extends AbstractIntegrationTest {
    MockMvc mockMvc;

    @Autowired
    MoviesController moviesController;

    @Autowired
    MoviesService moviesService;

    public MoviesIntegrationTest() {
    }

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(moviesController, moviesService).build();
    }

    @Test
    public void saveMoviesSuccessTest() throws Exception {
        String imdbId = String.valueOf(System.currentTimeMillis());
        String request = "[{\n" +
                "    \"ImdbId\": \"" + imdbId + "\",\n" +
                "    \"name\": \"Poncho ni yoake no kaze haramasete\",\n" +
                "    \"poster_url\": \"https://m.media-amazon.com/images/M/MV5BNmZhYjU2NDEtZGMyYi00MzY4LTg1OGUtYTA4ZDVjNWU4YzM0XkEyXkFqcGdeQXVyMjM5NDM1MTE@.\",\n" +
                "    \"year\": \"2017\",\n" +
                "    \"runtime\": \"90 min\",\n" +
                "    \"genre\": [\n" +
                "      \"Comedy\"\n" +
                "    ],\n" +
                "    \"ratingValue\": \"2.1\"\n" +
                "  }]";
        String uri = "/movie";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(true)));
    }

    @Test
    public void saveMoviesFailureTest() throws Exception {
        String uri = "/movie";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content("[]"))
                .andExpect(jsonPath("$.status", is(false)));
    }

    @Test
    public void saveMoviesExceptionTest() throws Exception {
        String request = "[{\n" +
                "    \"ImdbId\": \"\",\n" +
                "    \"name\": \"Poncho ni yoake no kaze haramasete\",\n" +
                "    \"poster_url\": \"https://m.media-amazon.com/images/M/MV5BNmZhYjU2NDEtZGMyYi00MzY4LTg1OGUtYTA4ZDVjNWU4YzM0XkEyXkFqcGdeQXVyMjM5NDM1MTE@.\",\n" +
                "    \"year\": \"2017\",\n" +
                "    \"runtime\": \"90 min\",\n" +
                "    \"genre\": [\n" +
                "      \"Comedy\"\n" +
                "    ],\n" +
                "    \"ratingValue\": \"2.1\"\n" +
                "  }]";
        String uri = "/movie";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getMovieByIdSuccessTest() throws Exception {
        int id = 60;
        String uri = "/movie/" + id;
        mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.data.id", is(id)));
    }

    @Test
    public void getMovieByIdFailureTest() throws Exception {
        int id = 999;
        String uri = "/movie/" + id;
        mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(false)));
    }

    @Test
    public void getMoviesWithPaginationSuccessTest() throws Exception {
        String imdbId = "tt8974352";
        String uri = "/movie/pageable?rating=5.3&releasedYear=2019&movieName=ODD&imdbId=" + imdbId + "&page=1&row=10";
        mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.data[0].imdbId", is(imdbId)));
    }

    @Test
    public void getMoviesWithPaginationFailureTest() throws Exception {
        String uri = "/movie/pageable?rating=5.3&releasedYear=2019&movieName=ODD&imdbId=1tt8974352&page=1&row=10";
        mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(false)));
    }
}
