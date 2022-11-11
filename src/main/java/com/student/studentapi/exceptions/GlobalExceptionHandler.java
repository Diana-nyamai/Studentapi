package com.student.studentapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorObject> handleStudentNotFoundException(StudentNotFoundException st, WebRequest wb){
    ErrorObject errorObject  = new ErrorObject();
    errorObject.setStatuscode(HttpStatus.NOT_FOUND.value());
    errorObject.setMessage(st.getMessage());
    errorObject.setTimestamp(new Date());
    return new ResponseEntity<>(errorObject, HttpStatus.NOT_FOUND);
}
}
