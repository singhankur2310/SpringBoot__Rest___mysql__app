package in.ankurit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ankurit.binding.Course;
@Repository
public interface CourseRepo extends JpaRepository<Course, Serializable>{

}
