package com.rst.coursehub.repository;
import com.rst.coursehub.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
