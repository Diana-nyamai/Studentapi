package com.student.studentapi.services;

import com.student.studentapi.dto.StudentDto;

import java.util.List;


public interface StudentService {
    StudentDto createStudents(StudentDto studentDto);
    List<StudentDto> getAllStudents();
    StudentDto getOneStudent(int id);
    StudentDto updateStudent(StudentDto studentDto, int id);
    void deleteStudent(int id);
}
