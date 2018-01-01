package com.hisen.service;

import com.hisen.entity.Book;
import com.hisen.entity.Video;

import java.util.List;

/**
 * Created by hisen on 17-4-24.
 */
public interface BookService {
    Book getById(long bookId);

    List<Book> getList(int start, int pageNum);

    int addBook(Book book);


    int addVideo(Video book);

    int updateBook(Book book);

    int deleteBookById(long id);

    List<Video> queryAllVideo(int a, int b);

}