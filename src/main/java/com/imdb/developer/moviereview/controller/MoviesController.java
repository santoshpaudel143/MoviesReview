package com.imdb.developer.moviereview.controller;

import com.imdb.developer.moviereview.pojo.MovieFilterRequestPojo;
import com.imdb.developer.moviereview.pojo.MovieRequestPojo;
import com.imdb.developer.moviereview.service.MoviesService;
import com.imdb.developer.moviereview.utils.dto.GlobalApiResponse;
import com.imdb.developer.moviereview.utils.generic.BaseController;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: Santosh Paudel
 */

@RestController
@RequestMapping("/movie")
public class MoviesController extends BaseController {

    private final MoviesService moviesService;
    private final static String FETCHED_SUCCESS = "fetched successfully";

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
        this.moduleName = "Movies ";
    }

    @PostMapping
    public ResponseEntity<GlobalApiResponse> addMovies(@RequestBody @Valid List<MovieRequestPojo> movieRequestPojo) {
        moviesService.addMovies(movieRequestPojo);
        return ResponseEntity.ok(successResponse(moduleName + "added successfully", null));
    }

    @GetMapping("{id}")
    public ResponseEntity<GlobalApiResponse> getMovieById(@PathVariable Integer id) {
        Map<String, Object> movieReview = moviesService.getMovieById(id);
        if (movieReview == null || movieReview.isEmpty())
                return ResponseEntity.ok(errorResponse(moduleName + "not found"));
        else
            return ResponseEntity.ok(successResponse(moduleName + FETCHED_SUCCESS, movieReview));

    }

    @GetMapping("/pageable")
    public ResponseEntity<GlobalApiResponse> getMoviePageable(MovieFilterRequestPojo movieFilterRequestPojo) {
        List<Map<String, Object>> movieList = moviesService.getMoviePageable(movieFilterRequestPojo);
        if (movieList == null || movieList.isEmpty())
            return ResponseEntity.ok(errorResponse(moduleName + "not found"));
        else
            return ResponseEntity.ok(successResponse(moduleName + FETCHED_SUCCESS, movieList));
    }
}
