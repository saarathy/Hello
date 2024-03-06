package com.example.management.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.management.entity.Library;
import com.example.management.repository.BookRepository;

@RestController
@RequestMapping("/LibraryManagement")
public class BookController {
	@Autowired
	BookRepository Repo;
	@PostMapping("/CreateBook")
	public ResponseEntity<Library>saveLibrary(@RequestBody @Valid Library book){
		return new ResponseEntity<>(Repo.save(book),HttpStatus.CREATED);
	}

	
	@GetMapping("/GetBook")
	public ResponseEntity<List<Library>>getAllBook(){
		List<Library> list= Repo.findAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@PostMapping("/AddBook")
	public ResponseEntity<Library>saveLibrary1(@RequestBody Library book){
		return new ResponseEntity<>(Repo.save(book),HttpStatus.CREATED);
	}
	@GetMapping("/GetBook/{id}")
	public ResponseEntity<Optional<Library>>getBookId(@PathVariable int id){
		Optional<Library> list= Repo.findById(id);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@DeleteMapping("/DeleteBook/{id}")
	public ResponseEntity<Library>deleteBook(@PathVariable Integer id){
		Optional<Library> book = Repo.findById(id);
		if(book.isPresent())
		{
			Repo.delete(book.get());
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Library>updateBook(@PathVariable Integer id,@RequestBody Library book){
	    Library updatebook = new Library();
	    updatebook.setId(id);
	    //System.out.println("book.getAuthorname()" + book.getAuthorname());
	    updatebook.setAuthorname(book.getAuthorname());
	    updatebook.setBookname(book.getBookname());
	    Repo.save(updatebook);
	    return new ResponseEntity("Message created successfully",HttpStatus.CREATED);
	}
	@GetMapping("/FetchBook/{bookname}")
	public List<Library> getBookId1(@PathVariable String bookname){
		List<Library> list= Repo.findByBookname(bookname);
		
		return list;
	}
	
	    
}
