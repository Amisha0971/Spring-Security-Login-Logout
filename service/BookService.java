package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.repo.BookRepository;

@Service
public class BookService {
	
	 @Autowired
	 private BookRepository bookrepo;
	 
	
	 public Page<Book> findPaginated(int pageNo, int pageSize) {
			Pageable pageable=PageRequest.of(pageNo - 1,pageSize);
			return this.bookrepo.findAll(pageable);
		}

}
