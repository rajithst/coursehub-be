package com.rst.coursehub.service;

import com.rst.coursehub.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getCourses();

    Optional<Course> getCourseById(int id);
}
