package kz.bitlab.springboot.springdatademo.techboot.services.impl;

import kz.bitlab.springboot.springdatademo.techboot.models.Course;
import kz.bitlab.springboot.springdatademo.techboot.repositories.CourseRepository;
import kz.bitlab.springboot.springdatademo.techboot.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }
}
