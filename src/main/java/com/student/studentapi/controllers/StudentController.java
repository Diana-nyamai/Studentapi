package com.student.studentapi.controllers;

import com.student.studentapi.dto.StudentDto;
import com.student.studentapi.models.Student;
import com.student.studentapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class StudentController {
  private StudentService studentService;
@Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }
  //  creates a new student
  @PostMapping("/students/create")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
    return new ResponseEntity<>(studentService.createStudents(studentDto), HttpStatus.CREATED);
  }
  //  returns all the students
  @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getstudents(){
      return ResponseEntity.ok(studentService.getAllStudents());
  }
//  returns a single student
  @GetMapping("/students/{id}")
  public ResponseEntity<StudentDto> getonestudent(@PathVariable int id){
    return ResponseEntity.ok(studentService.getOneStudent(id));
  }

//  updates a student
  @PutMapping("/students/{id}/update")
  public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable int id){
    System.out.println(studentDto.getLastname());
    System.out.println(studentDto.getFirstname());
    System.out.println(studentDto.getStudentId());
    return ResponseEntity.ok(studentService.updateStudent(studentDto, id));
  }
//  deleting student record
  @DeleteMapping("/students/{id}/delete")
  public ResponseEntity<String> deleteStudent(@PathVariable int id){
    System.out.println(id);
    studentService.deleteStudent(id);
    return ResponseEntity.ok("student has been deleted");
  }
}
