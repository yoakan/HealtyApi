package com.yoakan.healtyapi.excercise;

import com.yoakan.healtyapi.common.constants.Constants;
import com.yoakan.healtyapi.common.constants.Languages;
import com.yoakan.healtyapi.common.dto.Response;
import com.yoakan.healtyapi.common.exceptions.NotFoundException;
import com.yoakan.healtyapi.excercise.dto.ExcerciseDto;
import com.yoakan.healtyapi.common.dto.GenericResponse;
import com.yoakan.healtyapi.excercise.dto.ExcerciseMultiLanguageDto;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/excercises")
@AllArgsConstructor
public class ExcerciseController {



    private final ExcerciseService excerciseService;

    @GetMapping()
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content) })
    public ResponseEntity<?> getExcercises(){
        try {

            List<ExcerciseModel> ExcercisesDto= this.excerciseService.getAllItems();

            return ResponseEntity.ok().body(ExcercisesDto);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.internalError());
        }
    }
    @GetMapping(value = {"/find/{id}","/find/{language}/{id}"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),

            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content) })
    public ResponseEntity<? extends Response> findExcercise(@PathVariable(required = false) String language,@PathVariable Long id){
        try {
            language = checkLanguage(language);
            ExcerciseModel excercise= this.excerciseService.findExcercise(id);

            return ResponseEntity.ok().body(new ExcerciseDto(excercise,language));
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(GenericResponse.notFoundError());
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.internalError());
        }
    }

    @GetMapping(value = {"/findName/{language}/","/findName"})
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),

            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content) })
    public ResponseEntity<?> findExcerciseName(@PathVariable(required = false) String language,@RequestParam("name") String name){
        try {
            language = checkLanguage(language);
            List<ExcerciseModel> videosDto= this.excerciseService.findExcercise(language,name);

            return ResponseEntity.ok().body(videosDto);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.internalError());
        }
    }
    private String checkLanguage(String language){
        return StringUtils.isBlank(language)?Languages.ENGLISH:language;
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
    public ResponseEntity<? extends Response> addExcercise(@RequestBody ExcerciseMultiLanguageDto dto){
        try {
            this.excerciseService.create(dto);

            return ResponseEntity.ok().body(new GenericResponse(Constants.DEFAULT_MESSAGE_SUCCESS));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.internalError());
        }
    }
    @PutMapping(value ="/{id}/{language}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content) })
    public ResponseEntity<? extends Response> addLanguegeExcercise(@RequestBody ExcerciseDto dto,@PathVariable String language,@PathVariable Long id){
        try {
            this.excerciseService.modifyLanguage(id,language,dto);

            return ResponseEntity.ok().body(new GenericResponse(Constants.DEFAULT_MESSAGE_SUCCESS));
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(GenericResponse.notFoundError());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.internalError());
        }
    }
    @DeleteMapping(value ="/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content) })
    public ResponseEntity<? extends Response> deleteExcercise(@PathVariable Long id){
        try {
            this.excerciseService.deleteExcercise(id);

            return ResponseEntity.ok().body(new GenericResponse(Constants.DEFAULT_MESSAGE_SUCCESS));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(GenericResponse.internalError());
        }
    }
}
