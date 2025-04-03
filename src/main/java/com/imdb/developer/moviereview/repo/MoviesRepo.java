package com.imdb.developer.moviereview.repo;

import com.imdb.developer.moviereview.enitty.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Santosh Paudel
 */
public interface MoviesRepo extends JpaRepository<Movies, Integer> {
}
