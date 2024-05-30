package com.example.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
