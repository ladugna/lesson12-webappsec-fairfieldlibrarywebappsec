package edu.miu.cs.cs425.fairfieldlibraryapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Book;
import edu.miu.cs.cs425.fairfieldlibraryapp.repository.BookRepository;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book addNewBook(Book newBook) {
        return bookRepository.save(newBook);
    }
}
