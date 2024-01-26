package ru.geekbrains.homework4.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.homework4.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryRepository {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getAllBooks(){
        return books;
    }
}
