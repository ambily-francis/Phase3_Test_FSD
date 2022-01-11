package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	private BookService service;
	
	//post
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book)
	{
		return service.saveBook(book);
	}
	
	@PostMapping("/addBooks")
	public List<Book> addBooks(@RequestBody List<Book> books)
	{
		return service.saveBooks(books);
	}
	
	@GetMapping("/books")
	public List<Book> findAllBooks()
	{
		return service.getBooks();
	}
	
	@PutMapping("/update")
	public Book updateBook(@RequestBody Book book)
	{
		return service.updateBook(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id)
	{
		return service.deleteBook(id);
	}
	
	@DeleteMapping("/delete")
	public String deleteBooks()
	{
		return service.deleteBooks();
	}
	@GetMapping("/bookId/{id}")
	public Book findBookbyId(@PathVariable int id)
	{
		return service.getBookById(id);
	}
	
	@GetMapping("/bookName/{title}")
	public Book findBookbyName(@PathVariable String title)
	{
		return service.getBookTitle(title);
	}
	
	@GetMapping("/bookYear/{publishedYear}")
	public Book findBookbyPublishedYear(@PathVariable int publishedYear)
	{
		return service.getPublishedYear(publishedYear);
	}
}
