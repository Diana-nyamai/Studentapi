package com.student.studentapi.exceptions;

public class StudentNotFoundException extends RuntimeException{
   private static final long uid=1;

    public StudentNotFoundException(String message) {
        super(message);
    }
}
