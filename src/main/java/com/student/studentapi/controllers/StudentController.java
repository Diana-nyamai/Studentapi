package com.student.studentapi.controllers;

import com.student.studentapi.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class StudentController {
//  returns all the students
  @GetMapping("students")
    public ResponseEntity<List<Student>> getstudents(){
      List<Student> students = new ArrayList<>();
      students.add(new Student(1, "diana","nyamai"));
      students.add(new Student(2, "fiona", "nyamai"));
      students.add(new Student(3, "queen", "mary"));
      return ResponseEntity.ok(students);
  }
//  returns a single student
  @GetMapping("/students/{id}")
  public Student getonestudent(@PathVariable int id){
    return new Student(id, "ndinda", "deedee");
  }
//  creates a new student
  @PostMapping("/students/create")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Student> createStudent(@RequestBody Student student){
    System.out.println(student.getFirstname());
    System.out.println(student.getLastname());
    return new ResponseEntity<>(student, HttpStatus.CREATED);
  }
//  updates a student
  @PutMapping("/students/{id}/update")
  public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){
    System.out.println(student.getLastname());
    System.out.println(student.getFirstname());
    System.out.println(student.getStudentId());
    return ResponseEntity.ok(student);
  }
//  deleting student record
  @DeleteMapping("/students/{id}/delete")
  public ResponseEntity<String> deleteStudent(@PathVariable int id){
    System.out.println(id);
    return ResponseEntity.ok("student deleted successully");
  }
}
