package com.library.libraryapi.Entity;

import com.library.libraryapi.Request.AuthorRequest;
import com.library.libraryapi.Request.CountryRequest;
import com.library.libraryapi.Service.AuthorService;
import com.library.libraryapi.Service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataHolder {
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataHolder(AuthorService authorService, CountryService countryService) {
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void init()
    {
        countryService.addCountry(new CountryRequest("Makedonija","Evropa"));
        authorService.addAuthor(new AuthorRequest("Prv","Avtor", 1L));
        authorService.addAuthor(new AuthorRequest("Vtor","Avtor", 1L));
        authorService.addAuthor(new AuthorRequest("Tret","Avtor", 1L));
    }
}
