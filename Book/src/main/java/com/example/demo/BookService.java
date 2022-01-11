package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	//post methods
	public Book saveBook(Book book)
	{
		return repository.save(book);
	}
	
	public List<Book> saveBooks(List<Book> books)
	{
		return (List<Book>) repository.saveAll(books);
	}

	//delete
	public String deleteBook(int id)
	{
		repository.deleteById(id);
		return ("Book removed successfully !!" + id);
	}
	
	public String deleteBooks()
	{
		repository.deleteAll();
		return ("Books removed successfully !!");
	}
	//get methods
		public List<Book> getBooks()
		{
			return (List<Book>) repository.findAll();
		}
		
		public Book getBookById(int id)
		{
			return repository.findById(id).orElse(null);
		}
		
		public Book getBookTitle(String title)
		{
			return repository.findByTitle(title);
		}
		
		public Book getPublishedYear(int publishedYear)
		{
			return repository.findByPublishedYear(publishedYear);
		}
	
	public Book updateBook(Book book)
	{ 
		Book existingBook = repository.findById(book.getId()).orElse(null);
		existingBook.setId(book.getId());
		existingBook.setTitle(book.getTitle());
		existingBook.setPublishedYear(book.getPublishedYear());
		existingBook.setDescription(book.getDescription());
		return repository.save(existingBook);
	}
}
