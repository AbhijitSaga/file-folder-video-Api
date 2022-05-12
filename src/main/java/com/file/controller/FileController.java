package com.file.controller;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.message.ResponseMessage;
import com.file.model.FileDB;
import com.file.service.FileStorageService;

@RestController
public class FileController {
	@Autowired
	private FileStorageService storageService;
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) {
		String message = "";
		try {
			//System.out.println("message"+file);
			storageService.store(file,email);
			//Start_Edit
		
			
			
			//End_Edit
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
		
		
		
	}
	
	@GetMapping("/files/{id}")
	public FileDB getFile(@PathVariable Long id) {
		FileDB fileDB =null;
		try {
			fileDB = storageService.getFile(id);

			
			
		} catch (NoSuchElementException e) {
			//return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(e.getMessage()));
		}
		return fileDB;
	}
	
	@GetMapping("/allFilses")
	public List<FileDB> getAllFiles(){
		return storageService.allFilesget();
	}
	
	@GetMapping("/findByEmail/{email}")
	public List<FileDB> getByEmail(@PathVariable String email){
		return storageService.getDataByEmail(email);
	}
			
			
	/*
	 * @DeleteMapping("/files/{id}") public ResponseEntity<ResponseMessage>
	 * deletFileById(@PathVariable Long id) throws IOException { String message =
	 * ""; message = storageService.deletFileById(id); return
	 * ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	 * 
	 * }
	 */
}
