package com.jobportal.model.candidate;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class CandidateResume {

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String fileName;
    
    private String contentType;

    private Long size;

    @Lob
    private byte[] data;

	public CandidateResume(String fileName, String contentType, Long size, byte[] data) {
		super();
		this.fileName = fileName;
		this.contentType = contentType;
		this.size = size;
		this.data = data;
        Map <Integer,Integer> map = new HashMap<Integer, Integer>();
        
        Map <Object,Object> map2 = 
        		map.entrySet().stream().filter(e->e.getValue()==3).collect(Collectors.toMap(k->k, v->v));

	}
    
    
    
}


