package com.jobportal.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jobportal.payload.AppResponseStatus;
import com.jobportal.payload.UploadResumeResponse;
import com.jobportal.service.ResumeAttachmentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResumeAttachmentController {
	
	@Autowired
	ResumeAttachmentService service;
	

	
	@PostMapping("/candidate/uploadResume")
	public ResponseEntity<UploadResumeResponse> upload(@RequestParam Long id, @RequestParam MultipartFile file ) {
		
	
		
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new UploadResumeResponse("Resume not uploaded!", AppResponseStatus.FAILED));
		}
		service.uploadResume(id, file);
		return ResponseEntity.ok(new UploadResumeResponse("Uploaded Successfully", AppResponseStatus.SUCCESS));
	}
	
	@GetMapping("/candidate/downloadResume")
	public ResponseEntity<Resource> downloadResume(@RequestParam Long id) {
		
//		return service.downloadFile();
		
		Resource resource = null;
		try {
			resource = new UrlResource(service.downloadFile(id).toURI());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
}