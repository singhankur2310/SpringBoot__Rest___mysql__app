package in.ankurit.service;

import java.util.List;

import in.ankurit.binding.Course;

public interface CourseService {
	public String upsert(Course course);
	
	public Course getid(Integer cid);
	
	public List<Course> getAllCourses();
	
	public String deleteById(Integer cid);
	
	
}
