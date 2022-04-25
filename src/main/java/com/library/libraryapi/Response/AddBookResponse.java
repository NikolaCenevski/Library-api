package com.library.libraryapi.Response;

import com.library.libraryapi.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookResponse {
    private List<AuthorResponse> authorResponses;
    private List<Category> allCategories;
}
