package com.imdb.developer.moviereview.pojo;

import com.imdb.developer.moviereview.utils.dto.PageableRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @Author: Santosh Paudel
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieFilterRequestPojo extends PageableRequest {
    private String imdbId = "0";
    private String movieName = "0";
    private String releasedYear = "0";
    private BigDecimal rating = new BigDecimal(0);
}
