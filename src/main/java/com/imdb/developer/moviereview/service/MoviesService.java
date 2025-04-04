package com.imdb.developer.moviereview.service;

import com.imdb.developer.moviereview.pojo.MovieFilterRequestPojo;
import com.imdb.developer.moviereview.pojo.MovieRequestPojo;
import jakarta.validation.Valid;

import java.util.List;

/**
 * @Author: Santosh Paudel
 */
public interface MoviesService {
    void addMovies(@Valid List<MovieRequestPojo> movieRequestPojo);

    Object getMovieById(Integer id);

    Object getMoviePageable(MovieFilterRequestPojo movieFilterRequestPojo);
}
