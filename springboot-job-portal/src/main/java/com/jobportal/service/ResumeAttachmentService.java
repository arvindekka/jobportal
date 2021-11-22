package com.jobportal.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jobportal.dao.CandidateResumeDao;
import com.jobportal.model.candidate.CandidateResume;
import com.jobportal.repository.ResumeAttachmentRepo;

@Service
public class ResumeAttachmentService {

	@Autowired
	ResumeAttachmentRepo repo;
	
	@Autowired
	CandidateResumeDao dao;
	
	public CandidateResume storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            CandidateResume dbFile = new CandidateResume(fileName, file.getContentType(), file.getSize(), file.getBytes());

            return repo.save(dbFile);
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public File downloadFile(Long id) {
        try {
			return dao.downloadResume(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    public void uploadResume(Long id, MultipartFile multipartFile) {
    	dao.uploadResume(id, multipartFile);
    }
}
