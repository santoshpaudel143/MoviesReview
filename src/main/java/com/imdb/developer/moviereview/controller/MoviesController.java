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
        return ResponseEntity.ok(successResponse(moduleName + FETCHED_SUCCESS,
                moviesService.getMovieById(id)));
    }

    @GetMapping("/pageable")
    public ResponseEntity<GlobalApiResponse> getMoviePageable(MovieFilterRequestPojo movieFilterRequestPojo) {
        return ResponseEntity.ok(successResponse(moduleName + FETCHED_SUCCESS,
                moviesService.getMoviePageable(movieFilterRequestPojo)));
    }
}
