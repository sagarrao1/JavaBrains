package com.javabrains.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.topic.Topic;

@RestController
//@RequestMapping("/topics/{topicId}/courses")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
//	@RequestMapping(method = RequestMethod.GET)
	public List<Course> getAllcourses(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
//	@RequestMapping("/{id}")
	public Course getcourse(@PathVariable("id") String id ) {
		return courseService.getCourse(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
//	@RequestMapping(method = RequestMethod.POST)
	public Course addcourse(@RequestBody Course course , @PathVariable String topicId ) {
		course.setTopic(new Topic(topicId,"",""));
		return courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
//	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public Course updatecourse(@RequestBody Course course,@PathVariable String topicId , @PathVariable("id") String id ) {
		course.setTopic(new Topic(topicId,"",""));
		return courseService.updateCourse(course, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
//	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void deletecourse(@PathVariable("id") String id ) {
		 courseService.deleteCourse(id);
	}
}
