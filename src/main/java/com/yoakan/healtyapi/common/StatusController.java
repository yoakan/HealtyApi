package com.yoakan.healtyapi.common;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
@RequestMapping("/healt")
public class StatusController {
    @GetMapping()
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content) })
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("OK");
    }
}
