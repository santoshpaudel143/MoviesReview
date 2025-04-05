package com.imdb.developer.moviereview.config.dto;

import lombok.*;

/**
 * @Author: Santosh Paudel
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDto {
    private boolean status;
    private int httpCode;
    private String message;
}
