package com.library.libraryapi.Response;

import com.library.libraryapi.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private Category category;
    private String authorName;
    private Integer availableCopies;
}
