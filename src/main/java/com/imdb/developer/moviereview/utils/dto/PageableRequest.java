package com.imdb.developer.moviereview.utils.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Santosh Paudel
 */

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageableRequest {
    private int page = 0;
    private int row = 20;

    public int getRow() {
        return row <= 0 ? 20 : row;
    }

    public int getPage() {
        return page <= 0 ? 0 : page == 1 ? 0 : getRow() * page;
    }
}
