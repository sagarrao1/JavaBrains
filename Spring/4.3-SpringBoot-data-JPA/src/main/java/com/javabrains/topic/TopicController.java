package com.javabrains.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
//	@RequestMapping("/topics")
	@RequestMapping(method = RequestMethod.GET)
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
//	@RequestMapping("/topics/{id}")
	@RequestMapping("/{id}")
	public Topic getTopic(@PathVariable("id") String id ) {
		return topicService.getTopic(id);
	}
	
	
//	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	@RequestMapping(method = RequestMethod.POST)
	public Topic addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}

//	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public Topic updateTopic(@RequestBody Topic topic, @PathVariable("id") String id ) {
		return topicService.updateTopic(topic, id);
	}
	
//	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void deleteTopic(@PathVariable("id") String id ) {
		 topicService.deleteTopic(id);
	}
}
