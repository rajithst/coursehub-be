package com.rst.coursehub.repository;
import java.util.List;
import java.util.Optional;

import com.rst.coursehub.entity.Course;

public interface CourseRepository {

    List<Course> findAll();

    Optional<Course> findById(long courseId);
}
