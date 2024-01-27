package com.export.Repository;

import com.export.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Serializable> {
    @Query(value = "select * from course", nativeQuery = true)
    List<Course> findAllCuurse();
}
