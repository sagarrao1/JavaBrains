package com.javabrains.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {	

	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses(String topciId){		
	
		List<Course> courses = new ArrayList<>();		
		courseRepository.findByTopicId(topciId)
		.forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id){		
//		jpa
		return courseRepository.findById(id).get();
		
	}
	
	
	public Course addCourse(Course course){				
//		Courses.add(Course);		
		courseRepository.save(course); //jpa
		return course;		
	}

	public Course updateCourse(Course course , String id) {		
//		jpa
		courseRepository.save(course);
		return course;
	}
	
	
	public void deleteCourse(String id){				
		//jpa
//		CourseRepository.delete(getCourse(id));
		courseRepository.deleteById(id);
		
	}
}

