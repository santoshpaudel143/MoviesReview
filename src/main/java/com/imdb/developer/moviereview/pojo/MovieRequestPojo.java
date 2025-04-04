package com.imdb.developer.moviereview.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    @JsonProperty("ImdbId")
    private String imdbId;
    @NotBlank
    private String name;
    @JsonProperty("poster_url")
    private String posterUrl;
    @NotBlank
    private String year;
    private String runtime;
    private List<String> genre;
    private String ratingValue;

    public int getRuntime() {
        try {
            return Integer.parseInt(runtime.replaceAll("min", "").trim());
        } catch (Exception e) {
            return 0;
        }
    }

    public String getYear() {
        try {
            return year.substring(0, 4);
        } catch (Exception e) {
            return "0001";
        }
    }

    public BigDecimal getRatingValue() {
        try {
             return new BigDecimal(ratingValue).setScale(1, RoundingMode.HALF_UP);
        } catch (NumberFormatException e) {
            return new BigDecimal(0);
        }
    }
}
