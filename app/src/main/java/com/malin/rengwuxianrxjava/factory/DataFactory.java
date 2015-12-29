package com.malin.rengwuxianrxjava.factory;

import com.malin.rengwuxianrxjava.data.Course;
import com.malin.rengwuxianrxjava.data.Student;

import java.util.ArrayList;

/**
 * 类描述:获取学生集合
 * 创建人:malin.myemail@gmail.com
 * 创建时间:15-11-10.
 * 备注:
 */
public class DataFactory {

    /**
     * 获取学生集合
     *
     * [
     *      1:{
     *          id:1
     *          name:学生1
     *          course:[课程1,课程2,课程3]
     *        }
     *
     *      2:{
     *          id:2
     *          name:学生2
     *          course:[课程1,课程2,课程3]
     *        }
     *
     *      3:{
     *          id:3
     *          name:学生3
     *          course:[课程1,课程2,课程3]
     *        }
     * ]
     * @return
     */
    public static ArrayList<Student> getData() {

        ArrayList<Student> students = new ArrayList<Student>();

        ArrayList<Course> courses = null;
        Student student = null;
        Course course = null;
        for (int i = 0; i < 3; i++) {

            courses = new ArrayList<Course>();

            student = new Student();
            student.id = i;
            student.name = new StringBuffer("学生").append((i+1)).toString();

            for (int j = 0; j < 2; j++) {
                course = new Course();
                course.id = j;
                course.name = new StringBuffer(student.name).append("的课程").append((j+1)).toString();
                courses.add(course);
            }

            student.courses = courses;
            students.add(student);


        }
        return students;
    }
}
