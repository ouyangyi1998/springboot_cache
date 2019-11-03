package com.jerry.springboot_cache.dao;

import com.jerry.springboot_cache.entity.Book;

public interface BookRepository {
    Book getByIsbn(String isbn);
}
