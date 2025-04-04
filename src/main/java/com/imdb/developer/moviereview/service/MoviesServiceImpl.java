package com.imdb.developer.moviereview.service;

import com.imdb.developer.moviereview.enitty.MovieGenre;
import com.imdb.developer.moviereview.enitty.Movies;
import com.imdb.developer.moviereview.pojo.MovieFilterRequestPojo;
import com.imdb.developer.moviereview.pojo.MovieRequestPojo;
import com.imdb.developer.moviereview.repo.MovieGenreRepo;
import com.imdb.developer.moviereview.repo.MoviesRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Santosh Paudel
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class MoviesServiceImpl implements MoviesService {

    private final MoviesRepo moviesRepo;
    private final MovieGenreRepo movieGenreRepo;

    @Override
    public void addMovies(List<MovieRequestPojo> requestPojoList) {
        moviesRepo.saveAll(requestPojoList.stream()
                .map(requestPojo -> Movies
                        .builder()
                        .imdbId(requestPojo.getImdbId())
                        .movieName(requestPojo.getName())
                        .releasedYear(Year.parse(requestPojo.getYear()))
                        .runtime(requestPojo.getRuntime())
                        .rating(requestPojo.getRatingValue())
                        .posterUrl(requestPojo.getPosterUrl())
                        .movieGenres(this.getMovieGenres(requestPojo.getGenre()))
                        .build())
                .collect(Collectors.toList()));
    }

    @Override
    public Object getMovieById(Integer id) {
        return moviesRepo.getMovieById(id).orElse(null);
    }

    @Override
    public Object getMoviePageable(MovieFilterRequestPojo requestPojo) {
        return moviesRepo.getMoviesPageable(requestPojo.getImdbId(), requestPojo.getMovieName(), requestPojo.getReleasedYear(),
                requestPojo.getRating(), requestPojo.getPage(), requestPojo.getRow());
    }

    private List<MovieGenre> getMovieGenres(List<String> genres) {
        genres = genres.stream().filter(genre -> !genre.isEmpty()).map(String::trim).map(String::toLowerCase).collect(Collectors.toList());
        return movieGenreRepo.getMovieGenresByGenreNames(genres);
    }
}
