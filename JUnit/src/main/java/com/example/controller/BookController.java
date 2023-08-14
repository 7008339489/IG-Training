package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Book;
import com.example.repository.BookRepository;

import javassist.NotFoundException;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	BookRepository bookRepo;

	@GetMapping
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@GetMapping(value = "{bookId}")
	public Book getBookById(@PathVariable(value = "bookId") @Validated Long book) {
		return bookRepo.findById(book).get();
	}
	
	@PostMapping
	public Book createBook(@RequestBody @Validated Book book) {
		return bookRepo.save(book);
	}
	
	@PutMapping
	public Book updateBook(@RequestBody @Validated Book book) throws NotFoundException{
		if(book == null || book.getId() == null)
		throw new NotFoundException("BookRecord or ID must not be null");
		
		Optional<Book> optionalBook = bookRepo.findById(book.getId());
		if(!optionalBook.isPresent()) {
			throw new NotFoundException("Book with Id : "+book.getId()+" Does not Exist");
		}
		Book existingRecord = optionalBook.get();
		existingRecord.setName(book.getName());
		existingRecord.setSummary(book.getSummary());
		existingRecord.setRating(book.getRating());
		
		return bookRepo.save(existingRecord);
	}

}
