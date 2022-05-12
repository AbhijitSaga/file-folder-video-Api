package com.file.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Stream;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.model.FileDB;
import com.file.repository.FileDBRepository;
@Service
public class FileStorageService {
	@Autowired
	private FileDBRepository fileDBRepository;
     
	public FileDB store(MultipartFile file, String email) throws IOException {
		String email1=email;
		Random random=new Random();
		String st=String.format("%s%s", System.currentTimeMillis(), random.nextInt(100000));
		Path newFile = Paths.get("E:\\shivila\\downloadFile\\"+(email1+st+file.getOriginalFilename()).hashCode());
		Files.createDirectories(newFile.getParent());
		Files.write(newFile, file.getBytes());
		newFile.toAbsolutePath().toString();
		
		FileDB fileDB=new FileDB();
		fileDB.setUrl(newFile.toAbsolutePath().toString());
		fileDB.setEmail(email);
		fileDB.setTypeFile(file.getOriginalFilename().split("\\.")[1]);
		return fileDBRepository.save(fileDB);
	}
	//star
	
	
	//last
	

	public FileDB getFile(Long id) {
		//System.out.println("kkkk  :  "+fileDBRepository.findById(id).get().getUrl());
		return fileDBRepository.findById(id).get();
	}

	public Stream<FileDB> getAllFiles() {
		return fileDBRepository.findAll().stream();
	}

	public String deletFileById(Long id)  {
		if (fileDBRepository.existsById(id)) {
			fileDBRepository.deleteById(id);
			File file=new File(fileDBRepository.findById(id).get().getUrl());
			boolean b=file.delete();
			//Path path=Paths.get("./"+fileDBRepository.findById(id).get().getUrl());
			try {
				
			
			return "File has been successfully deleted";
		}catch (Exception e) {
			// TODO: handle exception
		}
		}
		return "File doesn't exist";
	
}

	public void saveEmail(FileDB fd) {
		// TODO Auto-generated method stub
		fileDBRepository.save(fd);
	}

	public List<FileDB> allFilesget() {
		// TODO Auto-generated method stub
		return fileDBRepository.findAll();
	}


	public List<FileDB> getDataByEmail(String email) {
		// TODO Auto-generated method stub
		return fileDBRepository.findAllByEmail(email);
	}


	



	

	
}