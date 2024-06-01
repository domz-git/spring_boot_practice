package com.example.domain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.domain.repositories.AuthorRepository;
import com.example.domain.repositories.BookRepository;
import com.example.domain.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        Author author = new Author("Eric", "Mann");
        Book book = new Book("The Story Of Mann", "12345");
        Publisher publisher = new Publisher("Iron Works", "English Lane", "Manchester", "England", "23566");
        
        
        author.getBooks().add(book);
        book.getAuthors().add(author);
        publisherRepository.save(publisher);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);
        
        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: "+ publisherRepository.count());
        System.out.println("Number of books the "+publisher.getName()+" has published is: "+ publisher.getBooks().size());

    }

}
