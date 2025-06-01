package com.rst.coursehub.repository.impl;

import com.rst.coursehub.entity.Course;
import com.rst.coursehub.repository.CourseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private final EntityManager entityManager;

    @Autowired
    public CourseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("FROM Course", Course.class).getResultList();
    }

    @Override
    public Optional<Course> findById(long courseId) {
        Course course = entityManager.find(Course.class, courseId);
        return Optional.ofNullable(course);
    }
}
