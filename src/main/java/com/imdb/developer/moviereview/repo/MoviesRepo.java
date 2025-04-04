package com.imdb.developer.moviereview.repo;

import com.imdb.developer.moviereview.enitty.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: Santosh Paudel
 */
public interface MoviesRepo extends JpaRepository<Movies, Integer> {
    @Query(value = "select m.*, json_agg(genre_name) \n" +
            "from movies m \n" +
            "join movie_genre_mapping mgm on mgm.movie_id = m.id\n" +
            "join movie_genre mg on mg.id = mgm.genre_id\n" +
            "where m.id =?1\n" +
            "group by m.id order by m.id desc", nativeQuery = true)
    Optional<Map<String,Object>> getMovieById(Integer id);

    @Query(value = "select m.*, json_agg(genre_name)\n" +
            "from movies m \n" +
            "join movie_genre_mapping mgm on mgm.movie_id = m.id\n" +
            "join movie_genre mg on mg.id = mgm.genre_id\n" +
            "where case when ?1 = '0' then true else m.imdb_id =?1 end\n" +
            "and case when ?2 = '0' then true else m.movie_name ilike '%' || ?2 || '%' end\n" +
            "and case when ?3 = '0' then true else cast(m.released_year as varchar) >= ?3 end\n" +
            "and case when ?4 = 0 then true else m.rating >= ?4 end\n" +
            "group by m.id order by m.id desc\n" +
            "offset ?5 limit ?6", nativeQuery = true)
    List<Map<String,Object>> getMoviesPageable(String imdbId, String movieName, String releasedYear, BigDecimal rating, int page, int row);
}
