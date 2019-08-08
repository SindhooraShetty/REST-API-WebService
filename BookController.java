package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookRepo;
import com.example.demo.model.Book;

@RestController
public class BookController {
@Autowired
BookRepo repo;
//fetch all
@GetMapping("/books")
public List<Book> getBooks(){
	return repo.findAll();
}
//fetch one
@RequestMapping("/book/{bookId}")
public Optional<Book> getBook(@PathVariable ("bookId") int bookId) {
	return repo.findById(bookId);
}
//Create
@PostMapping("/book")
public Book addBook(@RequestBody Book book) {
	repo.save(book);
	return book;
}
//Update
@PutMapping(path="/book")
public Book saveOrUpdate(@RequestBody Book book) {
	repo.save(book);
	return book;
}
//Delete
@DeleteMapping(path="/book/{bookId}")
public String deleteBook(@PathVariable ("bookId") int bookId)
{
	Book b=repo.getOne(bookId);
	repo.delete(b);
	return "Deleted Successfully";
}
}
