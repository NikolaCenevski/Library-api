package com.library.libraryapi.Service;

import com.library.libraryapi.Entity.Author;
import com.library.libraryapi.Entity.Book;
import com.library.libraryapi.Entity.Category;
import com.library.libraryapi.Repository.AuthorRepository;
import com.library.libraryapi.Repository.BookRepository;
import com.library.libraryapi.Request.AddBookRequest;
import com.library.libraryapi.Request.EditBookRequest;
import com.library.libraryapi.Response.AddBookResponse;
import com.library.libraryapi.Response.AuthorResponse;
import com.library.libraryapi.Response.BookResponse;
import com.library.libraryapi.Response.EditBookResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public  List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream().map(this::mapToBookResponse).collect(Collectors.toList());
    }

    public void addBook(AddBookRequest addBookRequest) {
        Book book=new Book();
        book.setCategory(addBookRequest.getCategory());
        book.setName(addBookRequest.getName());
        book.setAuthor(authorRepository.getById(addBookRequest.getAuthorId()));
        book.setAvailableCopies(addBookRequest.getAvailableCopies());
        bookRepository.save(book);
    }

    public void deleteBook(long id) {
        bookRepository.delete(bookRepository.getById(id));
    }

    public EditBookResponse editBookResponse(long id) {
       return mapToEditBookResponse(bookRepository.getById(id));
    }

    public void setEditedBook(EditBookRequest editedBookRequest) {
        Book book=bookRepository.getById(editedBookRequest.getId());
        book.setName(editedBookRequest.getName());
        book.setAuthor(authorRepository.getById(editedBookRequest.getNewAuthorId()));
        book.setCategory(editedBookRequest.getCategory());
        book.setAvailableCopies(editedBookRequest.getAvailableCopies());
        bookRepository.save(book);
    }

    public void markAsTaken(long id) {
        Book book=bookRepository.getById(id);
        book.setAvailableCopies(book.getAvailableCopies()-1);
        bookRepository.save(book);
    }




    public BookResponse mapToBookResponse(Book book)
    {
        BookResponse bookResponse=new BookResponse();
        bookResponse.setCategory(book.getCategory());
        bookResponse.setAuthorName(book.getAuthor().getName()+" "+book.getAuthor().getSurname());
        bookResponse.setId(book.getId());
        bookResponse.setName(book.getName());
        bookResponse.setAvailableCopies(book.getAvailableCopies());
        return bookResponse;
    }
    public EditBookResponse mapToEditBookResponse(Book book)
    {
        EditBookResponse bookResponse=new EditBookResponse();
        bookResponse.setCategory(book.getCategory());
        bookResponse.setAllCategories(Arrays.asList(Category.values()));
        bookResponse.setCurrentAuthor(mapToAuthorResponse(book.getAuthor()));
        bookResponse.setAllAuthors(authorRepository.findAll().stream().map(this::mapToAuthorResponse).collect(Collectors.toList()));
        bookResponse.setId(book.getId());
        bookResponse.setName(book.getName());
        bookResponse.setAvailableCopies(book.getAvailableCopies());
        return bookResponse;
    }
    public AuthorResponse mapToAuthorResponse(Author author)
    {
        AuthorResponse authorResponse=new AuthorResponse();
        authorResponse.setId(author.getId());
        authorResponse.setAuthorName(author.getName()+" "+author.getSurname());
        return authorResponse;
    }

    public AddBookResponse getAddBook() {
        AddBookResponse addBookResponse=new AddBookResponse();
        addBookResponse.setAuthorResponses(authorRepository.findAll().stream().map(this::mapToAuthorResponse).collect(Collectors.toList()));
        addBookResponse.setAllCategories(Arrays.asList(Category.values()));
        return addBookResponse;
    }
}
