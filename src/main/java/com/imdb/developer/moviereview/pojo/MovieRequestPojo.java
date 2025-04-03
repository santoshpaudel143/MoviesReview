package com.imdb.developer.moviereview.pojo;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

/**
 * @Author: Santosh Paudel
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieRequestPojo {
    @NotBlank
    private String imdbId;
    @NotBlank
    private String name;
    private String posterUrl;
    @NotBlank
    private String year = "0001";
    private String runtime;
    private List<String> genre;
    private String ratingValue;
}
