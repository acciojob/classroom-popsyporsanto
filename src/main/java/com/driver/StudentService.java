package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        studentRepository.addStudentTeacherPair(student,teacher);
    }

    public Student get_sinfo(String name) {
       return studentRepository.get_sinfo(name);
    }

    public Teacher get_tinfo(String name) {
        return studentRepository.get_tinfo(name);
    }

    public List<String> get_infoByTeacher(String teacher) {
        return studentRepository.get_infoTeacher(teacher);
    }

    public List<String> get_allSinfo() {
        return studentRepository.get_allSinfo();
    }

    public void deleteName(String teacher) {
         studentRepository.deleteName(teacher);
    }

    public void deleteTeacher() {
        studentRepository.deleteTeacher();
    }
}
