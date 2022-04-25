package com.library.libraryapi.Controller;

import com.library.libraryapi.Entity.Category;
import com.library.libraryapi.Request.AddBookRequest;
import com.library.libraryapi.Request.AuthorRequest;
import com.library.libraryapi.Request.CountryRequest;
import com.library.libraryapi.Request.EditBookRequest;
import com.library.libraryapi.Response.*;
import com.library.libraryapi.Service.AuthorService;
import com.library.libraryapi.Service.BookService;
import com.library.libraryapi.Service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api")
public class HomeController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;
    public HomeController(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @GetMapping("/books")
    public List<BookResponse> getAllBooks()
    {
        return bookService.getAllBooks();
    }
    @GetMapping("/books/add")
    public AddBookResponse getAddBook()
    {
        return bookService.getAddBook();
    }
    @PostMapping("/books/add")
    public void addBook(@RequestBody AddBookRequest addBookRequest)
    {
        bookService.addBook(addBookRequest);
    }
    @GetMapping("books/delete/{id}")
    public void deleteBook(@PathVariable long id)
    {
        bookService.deleteBook(id);
    }
    @GetMapping("books/edit/{id}")
    public EditBookResponse editBook(@PathVariable long id)
    {
       return bookService.editBookResponse(id);
    }
    @PostMapping("books/edit")
    public void setEditedBook(@RequestBody EditBookRequest editedBookRequest)
    {
        bookService.setEditedBook(editedBookRequest);
    }
    @GetMapping("books/markAsTaken/{id}")
    public void markAsTaken(@PathVariable long id)
    {
        bookService.markAsTaken(id);
    }
    @GetMapping("/categories")
    public List<Category> getAllCategories()
    {
        return Arrays.asList(Category.values());
    }
    @GetMapping("/addAuthor")
    public AddAuthorResponse addAuthorResp()
    {
        return authorService.addAuthorResponse();
    }
    @PostMapping("/addAuthor")
    public void addAuthor(@RequestBody AuthorRequest authorRequest)
    {
        authorService.addAuthor(authorRequest);
    }
    @GetMapping("/authors")
    public List<AuthorResponse> getAuthors()
    {
       return authorService.getAll();
    }
    @PostMapping("/addCountry")
    public void addAuthor(@RequestBody CountryRequest countryRequest)
    {
        countryService.addCountry(countryRequest);
    }


}
