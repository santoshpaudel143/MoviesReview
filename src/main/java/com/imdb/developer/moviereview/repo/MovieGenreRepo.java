package com.imdb.developer.moviereview.repo;

import com.imdb.developer.moviereview.enitty.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: Santosh Paudel
 */
public interface MovieGenreRepo extends JpaRepository<MovieGenre, Integer> {

    @Query(value = "select * from movie_genre where lower(genre_name) in (?1)", nativeQuery = true)
    List<MovieGenre> getMovieGenresByGenreNames(List<String> genreName);
}
