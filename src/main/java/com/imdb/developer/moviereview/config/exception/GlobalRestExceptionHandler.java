package com.imdb.developer.moviereview.config.exception;

import com.imdb.developer.moviereview.config.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @Author: Santosh Paudel
 */

@ControllerAdvice
@Slf4j
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponseDto> handleNullPointerException(final NullPointerException ex) {
        log.error(ex.getMessage(), ex);
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(httpStatus).body(ErrorResponseDto
                .builder()
                .message(ex.getMessage())
                .status(false)
                .httpCode(httpStatus.value())
                .build());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleAll(final Exception ex) {
        log.error(ex.getMessage(), ex);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(httpStatus).body(ErrorResponseDto
                .builder()
                .message(ex.getMessage())
                .status(false)
                .httpCode(httpStatus.value())
                .build());
    }
}
