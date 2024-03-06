package com.example.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.management.entity.Library;

public interface BookRepository extends JpaRepository<Library, Integer> {
  public List<Library> findByBookname(String name);
	  
}
