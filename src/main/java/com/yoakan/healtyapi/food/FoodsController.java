package com.yoakan.healtyapi.food;

import com.yoakan.healtyapi.common.constants.Constants;
import com.yoakan.healtyapi.common.dto.Response;
import com.yoakan.healtyapi.common.exceptions.NotFoundException;

import com.yoakan.healtyapi.common.dto.GenericResponse;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/foods")
@AllArgsConstructor
public class FoodsController {


    private final FoodService foodService;

    @GetMapping()
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),

            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content) })
    public ResponseEntity<?> getFoods(){
        try {

            List<FoodModel> foodsDto= this.foodService.getAllFood();

            return ResponseEntity.ok().body(foodsDto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new GenericResponse(Constants.DEFAULT_MESSAGE_ERROR_INTERAL));
        }
    }
    @GetMapping(value = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),

            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content) })
    public ResponseEntity<?> findFood(@PathVariable Long id){
        try {
            FoodModel videosDto= this.foodService.findFood(id);

            return ResponseEntity.ok().body(videosDto);
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(GenericResponse.notFoundError());
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.internalError());
        }
    }
    @DeleteMapping(value = "/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),

            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content) })
    public ResponseEntity<? > deleteFood(@PathVariable Long id){
        try {
            this.foodService.deleteFood(id);

            return ResponseEntity.ok().body(GenericResponse.success());
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.internalError());
        }
    }

    @GetMapping("/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),

            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content) })
    public ResponseEntity<?> findFoodName(@RequestParam("name") String name){
        try {
            List<FoodModel> videosDto= this.foodService.findFood(name);

            return ResponseEntity.ok().body(videosDto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.internalError());
        }
    }

    @PostMapping()
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            /*@ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),*/
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content) })
    public ResponseEntity<? > addFood(@RequestBody FoodDto dto){
        try {
            this.foodService.create(dto);

            return ResponseEntity.ok().body(GenericResponse.success());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.internalError());
        }
    }
}
