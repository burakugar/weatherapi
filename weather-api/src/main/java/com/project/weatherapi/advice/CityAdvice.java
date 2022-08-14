package com.project.weatherapi.advice;

import com.project.weatherapi.common.BaseAdvice;
import com.project.weatherapi.common.Error;
import com.project.weatherapi.constant.ErrorCodes;
import com.project.weatherapi.controller.CityController;
import com.project.weatherapi.exception.CityNotFoundWithIdException;
import com.project.weatherapi.exception.CityNotFoundWithNameException;
import com.project.weatherapi.exception.FeignClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.weatherapi.common.ErrorUtil.constructError;


@ControllerAdvice(assignableTypes = CityController.class)
@Slf4j
public class CityAdvice extends BaseAdvice {
    public CityAdvice() {
        super(ErrorCodes.UNKNOWN_ERROR);
    }

    @ExceptionHandler(FeignClientException.class)
    public ResponseEntity<Error> handleException(FeignClientException e) {
        log.error("Feign client error occurred: {}", e.toString());
        return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY)
                .body(constructError(e));
    }

    @ExceptionHandler(CityNotFoundWithNameException.class)
    public ResponseEntity<Error> handleException(CityNotFoundWithNameException e) {
        log.error("City Not Found With Given Name", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(constructError(e));
    }

    @ExceptionHandler(CityNotFoundWithIdException.class)
    public ResponseEntity<Error> handleException(CityNotFoundWithIdException e) {
        log.error("City Not Found With Given Id", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(constructError(e));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(constructError(ErrorCodes.VALIDATION_CONSTRAINT_ERROR,
                        generateFieldErrorMessage(e.getBindingResult().getFieldErrors())));
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(NullPointerException e) {
        return new ResponseEntity<>("First make a request for a city, there is no city inside of the storage!", HttpStatus.BAD_REQUEST);
    }

    private static String generateFieldErrorMessage(List<FieldError> fieldErrors) {
        return fieldErrors
                .stream()
                .map(m -> m.getField() + " " + m.getDefaultMessage())
                .collect(Collectors.joining(", "));
    }


}


