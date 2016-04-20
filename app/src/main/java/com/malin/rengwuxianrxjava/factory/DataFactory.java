
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 malin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.malin.rengwuxianrxjava.factory;

import com.malin.rengwuxianrxjava.model.Course;
import com.malin.rengwuxianrxjava.model.Student;

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
     *          course:[学生1的课程1,学生1的课程2,学生1的课程3]
     *        }
     *
     *      2:{
     *          id:2
     *          name:学生2
     *          course:[学生2的课程1,学生2的课程2,学生2的课程3]
     *        }
     *
     *      3:{
     *          id:3
     *          name:学生3
     *          course:[学生3的课程1,学生3的课程2,学生3的课程3]
     *        }
     * ]
     * @return
     */
    public static ArrayList<Student> getData() {

        ArrayList<Student> students = new ArrayList<Student>();

        ArrayList<Course> courses;
        Student student;
        Course course;
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
