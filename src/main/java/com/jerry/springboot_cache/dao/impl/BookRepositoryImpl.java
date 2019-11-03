package com.jerry.springboot_cache.dao.impl;

import com.jerry.springboot_cache.dao.BookRepository;
import com.jerry.springboot_cache.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class BookRepositoryImpl implements BookRepository {
    @Override
    @Cacheable("book")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn,"book");
    }
    private  void simulateSlowService()
    {
        try{
            long time=3000;
            Thread.sleep(time);
        }catch (InterruptedException e)
        {
            throw new IllegalStateException(e);
        }
    }
}
