package lt.debarz.springandreactapp.controllers;


import lombok.AllArgsConstructor;
import lt.debarz.springandreactapp.errors.ApiError;
import lt.debarz.springandreactapp.execeptions.UserNotValidException;
import lt.debarz.springandreactapp.model.User;
import lt.debarz.springandreactapp.services.UserService;
import lt.debarz.springandreactapp.shared.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
@RestController
@RequestMapping("/api/1.0")
public class UserController {

    UserService userService;

    //@RequestBody anno. -- we sad spring we want to request by of the incoming message
    @PostMapping("/users")
    public GenericResponse createUser(@Valid @RequestBody User user){
        userService.save(user);
        return new GenericResponse("User saved");
    }



    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException exception, HttpServletRequest request){
        ApiError apiError = new ApiError(400, "Validation error", request.getServletPath());
        BindingResult result = exception.getBindingResult();
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : result.getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        apiError.setValidationErrors(validationErrors);
        return apiError;
    }

}
