package com.imdb.developer.moviereview.controller;

import com.imdb.developer.moviereview.pojo.MovieRequestPojo;
import com.imdb.developer.moviereview.service.MoviesService;
import com.imdb.developer.moviereview.utils.dto.GlobalApiResponse;
import com.imdb.developer.moviereview.utils.generic.BaseController;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Santosh Paudel
 */

@RestController("movie/")
public class MoviesController extends BaseController {

    private final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
        this.moduleName = "Movies";
    }

    @PostMapping
    public ResponseEntity<GlobalApiResponse> addMovies(@RequestBody @Valid List<MovieRequestPojo> movieRequestPojo) {
        moviesService.addMovies(movieRequestPojo);
        return ResponseEntity.ok(successResponse(moduleName + "added successfully", null));
    }
}
