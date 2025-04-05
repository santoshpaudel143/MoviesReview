package com.imdb.developer.moviereview.service;

import com.imdb.developer.moviereview.pojo.MovieFilterRequestPojo;
import com.imdb.developer.moviereview.pojo.MovieRequestPojo;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

/**
 * @Author: Santosh Paudel
 */
public interface MoviesService {
    boolean addMovies(@Valid List<MovieRequestPojo> movieRequestPojo);

    Map<String,Object> getMovieById(Integer id);

    List<Map<String,Object>> getMoviePageable(MovieFilterRequestPojo movieFilterRequestPojo);
}
