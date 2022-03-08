package com.example.springboot.courses.contoller;

import java.util.List;
import java.util.Optional;

import com.example.springboot.courses.bean.Course;
import com.example.springboot.courses.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository repository;
    
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable long id) {
        Optional<Course> course = repository.findById(id);

        if (course.isEmpty()) {
            throw new RuntimeException("Course not found with id " + id);
        }

        return course.get();
    }

    @PostMapping("/courses")
    public void createCourse(@RequestBody Course course) {
        repository.save(course);
    }

    @PutMapping("/courses/{id}")
    public void updateCourse(@PathVariable long id, @RequestBody Course course) {
        repository.save(course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable long id) {
        repository.deleteById(id);
    }

}
