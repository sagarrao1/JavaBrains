package com.javabrains.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>	 {

	// getAllTopics()	
	//getTopic(String  id)
	//updateTopic(Topic t)
	//deleteTopic(String id)
	
//	defining custom interfce ethods so that spring data JPA will have implementations
	
	public List<Course> findByName(String name);
	public List<Course> findByDescription(String description);
	
	public List<Course> findByTopicId(String topicId);
	
	
}
