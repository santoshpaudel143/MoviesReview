package com.imdb.developer.moviereview.utils.dto;

import lombok.*;

/**
 * @Author: Santosh Paudel
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GlobalApiResponse {
    private boolean status;
    private String message;
    private Object data;
}
