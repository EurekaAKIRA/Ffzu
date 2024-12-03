package com.ffzu.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 捕获数据库异常
    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleSQLException(SQLException ex) {
        ex.printStackTrace(); // 打印异常堆栈
        return new ErrorResponse(400, "Database error: " + ex.getMessage(), System.currentTimeMillis());
    }

    // 捕获 MyBatis 异常
    @ExceptionHandler(org.apache.ibatis.exceptions.PersistenceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePersistenceException(org.apache.ibatis.exceptions.PersistenceException ex) {
        ex.printStackTrace();
        return new ErrorResponse(400, "Persistence error: " + ex.getMessage(), System.currentTimeMillis());
    }

    // 捕获所有 Exception 异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception ex) {
        ex.printStackTrace();
        return new ErrorResponse(500, "Uncaught exception: " + ex.getMessage(), System.currentTimeMillis());
    }
}

@Data
@AllArgsConstructor
class ErrorResponse {
    private int code;
    private String message;
    private long timestamp;
}