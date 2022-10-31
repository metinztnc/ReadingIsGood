package com.readingIsGood.controller;


import com.readingIsGood.entity.Book;
import com.readingIsGood.service.IBookService;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping(value = "/create")
    @Operation(summary = "Create a Book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Book Created"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Book> createCBook(@RequestBody Book book) {
        return new ResponseEntity(bookService.createBook(book), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    @Operation(summary = "Put a Specific Book Instance by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Put the Book By ID"),
            @ApiResponse(responseCode = "400", description = "Bad Request for Putting the Book"),
            @ApiResponse(responseCode = "404", description = "No Book Found With ID"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    ResponseEntity<Book> putBook(@Validated @NotNull @PathVariable final Long id, @RequestBody Book book) {
        return this.bookService.updateBook(id, book);
    }
}
