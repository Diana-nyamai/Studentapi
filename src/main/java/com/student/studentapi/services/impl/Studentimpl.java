package com.student.studentapi.services.impl;

import com.student.studentapi.dto.StudentDto;
import com.student.studentapi.exceptions.StudentNotFoundException;
import com.student.studentapi.models.Student;
import com.student.studentapi.repositories.StudentRepository;
import com.student.studentapi.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Studentimpl implements StudentService {
    private StudentRepository studentRepository;

    public Studentimpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto createStudents(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstname(studentDto.getFirstname());
        student.setLastname(studentDto.getLastname());

        Student newstudent = studentRepository.save(student);
        return maptoDto(newstudent);
    }

    @Override
    public List<StudentDto> getAllStudents() {
      List<Student> student = studentRepository.findAll();
        return student.stream().map(student1 -> maptoDto(student1)).collect(Collectors.toList());
    }

    @Override
    public StudentDto getOneStudent(int id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("student not found"));
        return maptoDto(student);
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, int id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("could not update student"));
        student.setFirstname(studentDto.getFirstname());
        student.setLastname(studentDto.getLastname());

        Student updatedstudent = studentRepository.save(student);
        return maptoDto(updatedstudent);
    }

    @Override
    public void deleteStudent(int id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("could not delete student"));
        studentRepository.delete(student);
    }

    public StudentDto maptoDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(student.getStudentId());
        studentDto.setFirstname(student.getFirstname());
        studentDto.setLastname(student.getLastname());
        return studentDto;
    }
}

