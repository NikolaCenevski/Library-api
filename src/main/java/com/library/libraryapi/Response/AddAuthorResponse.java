package com.library.libraryapi.Response;

import com.library.libraryapi.Entity.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAuthorResponse {
    private List<Country> countryList;
}
