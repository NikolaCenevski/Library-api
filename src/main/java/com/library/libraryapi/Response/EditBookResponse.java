package com.library.libraryapi.Response;

import com.library.libraryapi.Entity.Author;
import com.library.libraryapi.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditBookResponse {
    private Long id;
    private String name;
    private Category category;
    private List<Category> allCategories;
    private AuthorResponse currentAuthor;
    private List<AuthorResponse> allAuthors;
    private Integer availableCopies;
}
