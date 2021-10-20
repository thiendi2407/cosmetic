package com.cosmetic_app.web;

import com.cosmetic_app.data.models.Ingredient;
import com.cosmetic_app.data.models.IngredientInfo;
import com.cosmetic_app.data.models.User;
import com.cosmetic_app.data.payloads.request.IngredientRequest;
import com.cosmetic_app.data.payloads.request.UserLoginRequest;
import com.cosmetic_app.data.payloads.response.LoginResponse;
import com.cosmetic_app.data.payloads.response.MessageResponse;
import com.cosmetic_app.service.IngredientService;
import com.cosmetic_app.service.UserService;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
//Line 19 to 24 is the newly added code for swagger documentation
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
}
)
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllIngredient () {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    @GetMapping("/find/{name}")
//    public ResponseEntity<Ingredient> getIngredientByName (@PathVariable("name") String name) {
//        Ingredient ingredient = ingredientService.findByName(name);
//        return new ResponseEntity<>(ingredient, HttpStatus.OK);
//    }

//    @GetMapping("/find-availability/{name}")
//    public ResponseEntity<List<IngredientInfo>> getAvailabilityByName (@PathVariable("name") String name) {
//        List<IngredientInfo> ingredients = ingredientService.findAvailability(name);
//        return new ResponseEntity<>(ingredients, HttpStatus.OK);
//    }
//

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> userLogin(@RequestBody UserLoginRequest request) {
        User userLogin = userService.findUser(request.getUserName(), request.getPassword());
        LoginResponse response = new LoginResponse();
        UUID uuid = UUID.randomUUID();
        if (userLogin != null)
        {
            response.setToken(uuid.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setToken("Login failed!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addUser(@RequestBody UserLoginRequest request) {
        MessageResponse newUser = userService.createUser(request);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Integer id) {
//        Employee employee = employeeService.getASingleEmployee(id);
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//    }
//
//    @PutMapping("/update/{id}")
//    public Optional<Employee> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeRequest employee) {
//        return employeeService.updateEmployee(id, employee);
//
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
//        employeeService.deleteEmployee(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
