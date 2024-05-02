package in.ankurit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ankurit.binding.Course;
import in.ankurit.service.CourseService;

@RestController
public class CourseRestController {
	@Autowired
	private CourseService courseSerice;
	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course){
		String status =courseSerice.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	@GetMapping("/course/{cid}")
	public ResponseEntity<Course> getCourse(@PathVariable Integer cid){
			Course course=courseSerice.getid(cid);
			return new ResponseEntity<Course>(course,HttpStatus.OK);
	}
	@GetMapping("/courses")
   public ResponseEntity<List<Course>> getAllourses(){
	   List<Course> allcourses = courseSerice.getAllCourses();
	   return new ResponseEntity<List<Course>>(allcourses,HttpStatus.OK);
	   
   }
	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course){
		String status =courseSerice.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@DeleteMapping("/course/{cid}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer cid){
			String status=courseSerice.deleteById(cid);
			return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	
	
}
