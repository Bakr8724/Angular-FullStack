package com.example.cooksys_website_backend.controllers.advice;


import com.example.cooksys_website_backend.dtos.ErrorDto;
import com.example.cooksys_website_backend.exceptions.BadRequestException;
import com.example.cooksys_website_backend.exceptions.NotAuthorizedException;
import com.example.cooksys_website_backend.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(basePackages = "com.example.group_3_project_1")
@ResponseBody
public class Advice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorDto handleBadRequestException(HttpServletRequest request, BadRequestException badRequestException) {
        return new ErrorDto(badRequestException.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorDto handleNotFoundException(HttpServletRequest request, NotFoundException notFoundException) {
        return new ErrorDto(notFoundException.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NotAuthorizedException.class)
    public ErrorDto handleNotAuthorizedException(HttpServletRequest request, NotAuthorizedException notAuthorizedException) {
        return new ErrorDto(notAuthorizedException.getMessage());
    }
}
