package com.imdb.developer.moviereview.utils.generic;

import com.imdb.developer.moviereview.utils.dto.GlobalApiResponse;

/**
 * @Author: Santosh Paudel
 */
public class BaseController {

    protected String moduleName;

    public GlobalApiResponse successResponse(String message, Object data) {
        return GlobalApiResponse.builder()
                .status(true)
                .message(message)
                .data(data)
                .build();
    }

    public GlobalApiResponse errorResponse(String message) {
        return GlobalApiResponse.builder()
                .status(false)
                .message(message)
                .data(null)
                .build();
    }
}
