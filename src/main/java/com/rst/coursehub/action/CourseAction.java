package com.rst.coursehub.action;

import com.rst.coursehub.entity.Course;
import com.rst.coursehub.service.CourseService;
import com.rst.coursehub.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseAction {
    private final CourseService courseService;

    @Autowired
    public CourseAction(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable("id") int courseId) {
        Optional<Course> course = courseService.getCourseById(courseId);
        return ResponseUtil.wrapOrNotFound(course);
    }
}
