package upskill.mysql.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import upskill.mysql.springboot.dto.UserDto;
import upskill.mysql.springboot.exceptions.ErrorDetails;
import upskill.mysql.springboot.exceptions.ResourceNotFoundException;
import upskill.mysql.springboot.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "CRUD operations",
        description = "Create , Update, Get user, get all user, Delete"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    @Operation(
            summary = "Create User Api",
            description = "To add an new user"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 CREATED"
    )
    // build create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid  @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get User by Id Rest Api",
            description = "To get an user by ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All User Api",
            description = "To get all user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @Operation(
            summary = "Update User Api",
            description = "To Update an  user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                              @RequestBody @Valid UserDto user){
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    @Operation(
            summary = "Delete User Api",
            description = "To delete an  user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

//@ExceptionHandler(ResourceNotFoundException.class)
//    public  ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                         WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }
}
