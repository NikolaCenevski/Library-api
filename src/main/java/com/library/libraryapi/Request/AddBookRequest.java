package com.library.libraryapi.Request;

import com.library.libraryapi.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRequest {
    private String name;
    private Category category;
    private long authorId;
    private Integer availableCopies;
}
