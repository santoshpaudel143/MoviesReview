package com.imdb.developer.moviereview.service;

import com.imdb.developer.moviereview.enitty.MovieGenre;
import com.imdb.developer.moviereview.enitty.Movies;
import com.imdb.developer.moviereview.pojo.MovieRequestPojo;
import com.imdb.developer.moviereview.repo.MovieGenreRepo;
import com.imdb.developer.moviereview.repo.MoviesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Santosh Paudel
 */

@Service
@RequiredArgsConstructor
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
                        .runtime(this.getRuntime(requestPojo.getRuntime()))
                        .rating(Float.parseFloat(requestPojo.getRatingValue()))
                        .posterUrl(requestPojo.getPosterUrl())
                        .movieGenres(this.getMovieGenres(requestPojo.getGenre()))
                        .build())
                .collect(Collectors.toList()));
    }

    private int getRuntime(String runtime) {
        try {
            return Integer.parseInt(runtime.replaceAll("min", "").trim());
        } catch (Exception e) {
            return 0;
        }
    }

    private List<MovieGenre> getMovieGenres(List<String> genres) {
        genres = genres.stream().filter(genre -> !genre.isEmpty()).map(String::trim).collect(Collectors.toList());
        return movieGenreRepo.getMovieGenresByGenreNames(genres);
    }
}
