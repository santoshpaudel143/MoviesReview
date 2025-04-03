package com.imdb.developer.moviereview.enitty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Year;
import java.util.Collection;

/**
 * @Author: Santosh Paudel
 */

@Table(name = "movies", uniqueConstraints = @UniqueConstraint(name = "uk_movies_imdb_id", columnNames = "imdbId"))
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movies {
    @Id
    @SequenceGenerator(sequenceName = "movies_seq", name = "movies_gen", allocationSize = 1)
    @GeneratedValue(generator = "movies_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "imdb_id", nullable = false)
    private String imdbId;
    private String movieName;
    private Year releasedYear;
    @Column(columnDefinition = "int default 0")
    private int runtime; // in minutes
    @Column(columnDefinition = "float default 0.0")
    private float rating;
    private String posterUrl;

    @ManyToMany
    @JoinTable(name = "movie_genre_mapping",
            foreignKey = @ForeignKey(name = "FK_movie_genre_mapping_movie_id"),
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseForeignKey = @ForeignKey(name = "FK_movie_genre_genre_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(name = "UK_movie_genre_id", columnNames = {"movie_id", "genre_id"})
    )
    @JsonIgnore
    private Collection<MovieGenre> movieGenres;
}
