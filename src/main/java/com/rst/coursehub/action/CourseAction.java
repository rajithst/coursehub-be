package com.rst.coursehub.action;

import com.rst.coursehub.entity.Course;
import com.rst.coursehub.service.CourseService;
import com.rst.coursehub.util.ResponseUtil;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
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
    public ResponseEntity<Course> getCourse(@PathVariable long id) {
        Optional<Course> course = courseService.getCourseById(id);
        return ResponseUtil.wrapOrNotFound(course);
    }

    @PostMapping("courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) throws BadRequestException, URISyntaxException {
        if(course.getId() != null) {
            throw new BadRequestException("A new course cannot already have an ID");
        }
        course = courseService.saveCourse(course);
        return ResponseEntity.created(new URI("/v1/courses/" + course.getId()))
                .body(course);
    }

    @PutMapping("courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id", required = false) final long courseId,
                                               @RequestBody Course course) throws BadRequestException {
        if (course.getId() == null) {
            throw new BadRequestException("Invalid id");
        }
        if (!Objects.equals(courseId, course.getId())) {
            throw new BadRequestException("Invalid id");
        }
        Optional<Course> courseOptional = courseService.getCourseById(courseId);
        if (courseOptional.isEmpty()) {
            throw new BadRequestException("Course not found!");
        }
        Course updatedCourse = courseService.saveCourse(course);
        return ResponseEntity.ok().body(updatedCourse);

    }
}
