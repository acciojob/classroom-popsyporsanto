package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {
    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(HashMap<String, Student> studentMap, HashMap<String, Teacher> teacherMap, HashMap<String, List<String>> teacherStudentMapping) {
        this.studentMap = studentMap;
        this.teacherMap = teacherMap;
        this.teacherStudentMapping = teacherStudentMapping;
    }

    public void addStudent(Student student) {
        studentMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        List<String> students = teacherStudentMapping.get(teacher);

        if(students==null){
            students = new ArrayList<>();
        }

        students.add(student);
        teacherStudentMapping.put(teacher,students);

        return ;
    }

    public Student get_sinfo(String name) {
        return studentMap.get(name);
    }

    public Teacher get_tinfo(String name) {
        return teacherMap.get(name);
    }

    public List<String> get_infoTeacher(String teacher) {
        return teacherStudentMapping.get(teacher);
    }

    public List<String> get_allSinfo() {
        List<String> students = new ArrayList<>();

        for(String s : studentMap.keySet()){
            students.add(s);
        }
        return students;
    }

    public void deleteName(String teacher) {
        for(String str : teacherStudentMapping.get(teacher)){

            studentMap.remove(str);

        }
        teacherStudentMapping.remove(teacher);
        teacherMap.remove(teacher);
    }

    public void deleteTeacher() {
            for(String teacher : teacherMap.keySet())
            {
                for(String str : teacherStudentMapping.get(teacher)){

                    studentMap.remove(str);

                }
                teacherStudentMapping.remove(teacher);
                teacherMap.remove(teacher);

            }



    }
}
