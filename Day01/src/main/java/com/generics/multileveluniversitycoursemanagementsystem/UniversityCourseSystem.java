package com.generics.multileveluniversitycoursemanagementsystem;

import java.util.*;

// Abstract class representing different types of courses
abstract class CourseType {
    protected String courseName;
    protected String instructor;

    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public abstract void evaluate();

    @Override
    public String toString() {
        return "Course: " + courseName + ", Instructor: " + instructor;
    }
}

// Different course types
class ExamCourse extends CourseType {
    public ExamCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    public void evaluate() {
        System.out.println(courseName + " is evaluated through exams.");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    public void evaluate() {
        System.out.println(courseName + " is evaluated through assignments.");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName, String instructor) {
        super(courseName, instructor);
    }

    @Override
    public void evaluate() {
        System.out.println(courseName + " is evaluated through research projects.");
    }
}

// Generic Course class
class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public void showCourseDetails() {
        System.out.println(courseType);
        courseType.evaluate();
    }
}

// Course Manager handling multiple types of courses
class CourseManager {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
            course.evaluate();
        }
    }
}

// Main Class
public class UniversityCourseSystem {
    public static void main(String[] args) {
        List<CourseType> courses = new ArrayList<>();
        courses.add(new ExamCourse("Mathematics", "Dr. Harsh"));
        courses.add(new AssignmentCourse("Software Engineering", "Prof. Raj"));
        courses.add(new ResearchCourse("Machine Learning", "Dr. Survesh"));

        CourseManager.displayCourses(courses);

        // Managing individual course
        Course<ExamCourse> mathCourse = new Course<>(new ExamCourse("Mathematics", "Dr. Yogesh"));
        mathCourse.showCourseDetails();
    }
}
