package com.example.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
