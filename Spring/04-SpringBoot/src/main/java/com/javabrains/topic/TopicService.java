package com.javabrains.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","spring framework" ,"spring framework description"),
			new Topic("java","Core Java" ,"Core java description"),
			new Topic("BuildTools","Build Tools" ,"Build Tools description")				
			));

	public List<Topic> getAllTopics(){		
		return topics;
	}
	
	public Topic getTopic(String id){		
		for (Topic topic : topics) {
			if (topic.getId().equals(id)) {
				return topic;
			}
		}		
		return null;
		
//		using streams to find
//		return topics.stream().filter(f -> f.getId().equals(id)).findFirst().get();
	}
	
	
	public Topic addTopic(Topic topic){				
		topics.add(topic);		
		return topic;		
	}

	public Topic updateTopic(Topic topic , String id) {		
		for (Topic topic2 : topics) {
			if ( topic2.getId().equals(id)) {
				topic2.setName(topic.getName());
				topic2.setDescription(topic.getDescription());
			}
		}		
		return topic;
	}
	
	
	public void deleteTopic(String id){				
		topics.remove(getTopic(id));
		
//		using streams to delete
//		topics.removeIf(t -> t.getId().equals(id));
	}
}

