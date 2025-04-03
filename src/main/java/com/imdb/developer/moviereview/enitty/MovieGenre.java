package com.imdb.developer.moviereview.enitty;

import jakarta.persistence.*;
import lombok.*;

/**
 * @Author: Santosh Paudel
 */

@Table(name = "movie_genre", uniqueConstraints = @UniqueConstraint(name = "uk_movie_genre_name", columnNames = "genre_name"))
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieGenre {

    @Id
    @SequenceGenerator(sequenceName = "movie_genre_seq", name = "movie_genre_gen", allocationSize = 1)
    @GeneratedValue(generator = "movie_genre_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "genre_name", nullable = false)
    private String genreName;
}
