package com.file.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.file.model.FileDB;

public interface FileDBRepository extends JpaRepository<FileDB, Long>{

	List<FileDB> findAllByEmail(String Email);

}
