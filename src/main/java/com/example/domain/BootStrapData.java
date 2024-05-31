package com.example.domain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.domain.repositories.AuthorRepository;
import com.example.domain.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        Author eric = new Author("Eric", "Mann");
        Book theStoryOfMann = new Book("The Story Of Mann", "12345");
        eric.getBooks().add(theStoryOfMann);
        theStoryOfMann.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(theStoryOfMann);
        
        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

    }

}
