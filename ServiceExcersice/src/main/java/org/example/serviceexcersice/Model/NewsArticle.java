package org.example.serviceexcersice.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsArticle {
    @NotNull(message = "id cannot be null")
    private int id;
    @NotEmpty(message = "title cannot be empty")
    @Size(max=100,message = "Maximum length of 100 characters")
    private String title;
    @NotEmpty(message = "author cannot be empty")
    @Size(min=5,max=20,message = "should be between 4 and 20")
    private String author;
    @NotEmpty(message = "content cannot be empty")
    @Size(min=201,message = "Must be more than 200 characters ")
    private String content;
    @NotEmpty(message = "category cannot be empty")
    @Pattern(regexp = "^(politics|sports|technology)$")
    private String category;
    @NotEmpty(message = "category cannot be empty")
    private String imageUrl;
    @AssertFalse
    private boolean isPublished;
    @DateTimeFormat
    private LocalDate publishDate;
}
