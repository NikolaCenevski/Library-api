package com.library.libraryapi.Request;

import com.library.libraryapi.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditBookRequest {
    private Long id;
    private String name;
    private Category category;
    private Long newAuthorId;
    private Integer availableCopies;
}
