package com.readingIsGood.exception;

import com.readingIsGood.dto.CustomRestError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.el.MethodNotFoundException;
import javax.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class CustomRestExceptionHandler {

        @ExceptionHandler(value = {NoHandlerFoundException.class, MethodNotFoundException.class})
        public ResponseEntity<CustomRestError> processNoHandlerFoundException(final Exception exception, final HttpServletRequest request) {
            return responseEntity(CustomRestError.builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .message((HttpStatus.NOT_FOUND.getReasonPhrase()))
                    .build());
        }

        @ExceptionHandler(value = {Exception.class})
        public ResponseEntity<CustomRestError> processException(final Exception exception, final HttpServletRequest request) {

            return responseEntity(CustomRestError.builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message("customException.internalServerError.message")
                    .build());
        }

        @ExceptionHandler(value = {MethodArgumentNotValidException.class})
        public ResponseEntity<CustomRestError> processBadRequestException(final Exception exception, final HttpServletRequest request) {
            return responseEntity(CustomRestError.builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .build());
        }


        @ExceptionHandler(value = {MethodNotAllowedException.class, HttpClientErrorException.MethodNotAllowed.class})
        public ResponseEntity<CustomRestError> processMethodNotAllowedException(final Exception exception, final HttpServletRequest request) {

            return responseEntity(CustomRestError.builder()
                    .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                    .message("methodNotAllowedException.message")
                    .build());
        }

        private ResponseEntity<CustomRestError> responseEntity(CustomRestError error) {
            return new ResponseEntity(error, HttpStatus.valueOf(error.getStatus()));
        }
}
