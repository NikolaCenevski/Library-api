package com.library.libraryapi.Service;

import com.library.libraryapi.Entity.Author;
import com.library.libraryapi.Repository.AuthorRepository;
import com.library.libraryapi.Repository.CountryRepository;
import com.library.libraryapi.Request.AuthorRequest;
import com.library.libraryapi.Response.AddAuthorResponse;
import com.library.libraryapi.Response.AuthorResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    public AuthorService(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }
    public List<AuthorResponse> getAll()
    {
        return authorRepository.findAll().stream().map(this::mapToAuthorResponse).collect(Collectors.toList());
    }

    public void addAuthor(AuthorRequest authorRequest) {
        Author author=new Author();
        author.setCountry(countryRepository.getById(authorRequest.getCountryId()));
        author.setName(authorRequest.getName());
        author.setSurname(authorRequest.getSurname());
        authorRepository.save(author);
    }
    public AuthorResponse mapToAuthorResponse(Author author)
    {
        AuthorResponse authorResponse=new AuthorResponse();
        authorResponse.setId(author.getId());
        authorResponse.setAuthorName(author.getName()+" "+author.getSurname());
        return authorResponse;
    }
    public AddAuthorResponse addAuthorResponse() {
        AddAuthorResponse addAuthorResponse=new AddAuthorResponse();
        addAuthorResponse.setCountryList(countryRepository.findAll());
        return addAuthorResponse;
    }
}
