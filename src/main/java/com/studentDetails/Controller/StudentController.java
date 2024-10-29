package com.studentDetails.Controller;

import com.studentDetails.Model.Student;
import com.studentDetails.Repositroy.StudentRepository;
import com.studentDetails.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("/get")
    public List<Student> getAllStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/get/{name}")
    public List<Student> getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @PostMapping("/save")
    public Student createStudent(@RequestBody Student student){
            return studentService.saveStudent(student);
    }

    @PostMapping("/saveAll")
    public List<Student> createAllStudent(@RequestBody List<Student> students){
        return studentService.saveAllStudent(students);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

}
