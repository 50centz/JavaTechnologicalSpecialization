package ru.geekbrains.homework4.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework4.model.Book;
import ru.geekbrains.homework4.repository.LibraryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService {

    private LibraryRepository libraryRepository;


    public void addBook(Book book){
        libraryRepository.addBook(book);
    }

    public List<Book> getAllBooks(){
        return libraryRepository.getAllBooks();
    }

}
