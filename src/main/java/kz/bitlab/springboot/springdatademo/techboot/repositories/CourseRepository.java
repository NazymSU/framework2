package kz.bitlab.springboot.springdatademo.techboot.repositories;

import kz.bitlab.springboot.springdatademo.techboot.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
