package com.studentDetails.Service;

import com.studentDetails.Model.Student;
import com.studentDetails.Repositroy.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    //for post method logic
    public Student saveStudent(Student student){
        return repository.save(student);
    }

    public List<Student> saveAllStudent(List<Student> students){
        return repository.saveAll(students);
    }

    //for get method logic
    public List<Student> getStudents(){
        return repository.findAll();
    }

    public Student getStudentById(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Student> getStudentByName(String name){
        return repository.findByName(name);
    }

    //for delete method logic
    public String deleteStudent(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Student removed "+id;
        }else{
            throw new RuntimeException("Id not found"+id);
        }
    }

    //for update method logic
    public Student updateStudent(Student student){
        Student exisitingStudent = repository.findById(student.getId()).orElse(null);
        if (exisitingStudent != null) {
            exisitingStudent.setName(student.getName());
        }
        if (exisitingStudent != null) {
            exisitingStudent.setCity(student.getCity());
        }
        if (exisitingStudent != null) {
            exisitingStudent.setPhoneNumber(student.getPhoneNumber());
        }
        Objects.requireNonNull(exisitingStudent).setStudentRank(student.getStudentRank());
        return repository.save(exisitingStudent);
    }
}
