package in.ankurit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ankurit.binding.Course;
import in.ankurit.repo.CourseRepo;
@Service
public class CouserServiceImpl implements CourseService {
	@Autowired
	private CourseRepo courseRepo;
	
	
	
	@Override
	public String upsert(Course course) {
		courseRepo.save(course);// upsert(insert / update)
		return "Succes";
	}

	@Override
	public Course getid(Integer cid) {
			Optional<Course> findbyid=courseRepo.findById(cid);
					if(findbyid.isPresent()) {
						return findbyid.get();
					}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}

	@Override
	public String deleteById(Integer cid) {
		if(courseRepo.existsById(cid)) {
			courseRepo.deleteById(cid);
			return "Delete Success";
		}else {
			return "No Record Found ";
		}
	}

}
