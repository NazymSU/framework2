package kz.bitlab.springboot.springdatademo.techboot.services;

import kz.bitlab.springboot.springdatademo.techboot.models.ApplicationRequest;
import kz.bitlab.springboot.springdatademo.techboot.models.Course;

import java.util.List;

public interface CourseService {
List<Course> getAll();

}
