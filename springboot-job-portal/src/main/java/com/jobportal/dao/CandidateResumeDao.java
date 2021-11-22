package com.jobportal.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class CandidateResumeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void uploadResume(Long id, MultipartFile multipartFile) {

		String updateSQL = "INSERT into resume_attachment "
                + "VALUE(?,?,?,?) ";

        try (Connection conn = jdbcTemplate.getDataSource().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            // set parameters
            try {
				pstmt.setLong(1, id);
				pstmt.setString(2, multipartFile.getOriginalFilename());
				pstmt.setString(3, multipartFile.getContentType());
				pstmt.setLong(4, multipartFile.getSize()/1024);
				pstmt.setBinaryStream(5, multipartFile.getInputStream());
	    		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Store file in the database.");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	

	public File downloadResume(Long id) throws IOException {

		String updateSQL = "select * from resume_attachment where id=?";

        try (Connection conn = jdbcTemplate.getDataSource().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            // set parameters
//            try {
				pstmt.setLong(1, id);
//				pstmt.setBinaryStream(2, multipartFile.getInputStream());
//				pstmt.setString(3, multipartFile.getName().toString());
//				pstmt.setString(4, multipartFile.getContentType().toString());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
            System.out.println("Store file in the database.");

            ResultSet rs = pstmt.executeQuery(updateSQL);
            File file = new File(rs.getString(3));

            
            FileOutputStream output = new FileOutputStream(file);
            
            System.out.println("Writing to file " + file.getAbsolutePath());
            
            while (rs.next()) {
                InputStream input = rs.getBinaryStream("data");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
            }
            
            return file;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
        
    }
	
}
