package com.cosmetic_app.web;

import com.cosmetic_app.data.models.IngredientInfo;
import com.cosmetic_app.data.payloads.request.IngredientRequest;
import com.cosmetic_app.data.payloads.response.MessageResponse;
import com.cosmetic_app.service.IngredientService;
import com.cosmetic_app.data.models.Ingredient;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
//Line 19 to 24 is the newly added code for swagger documentation
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
}
)
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/all")
    public ResponseEntity<List<Ingredient>> getAllIngredient () {
        List<Ingredient> ingredients = ingredientService.getAllIngredient();
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<Ingredient> getIngredientByName (@PathVariable("name") String name) {
        Ingredient ingredient = ingredientService.findByName(name);
        return new ResponseEntity<>(ingredient, HttpStatus.OK);
    }

    @GetMapping("/find-availability/{name}")
    public ResponseEntity<List<IngredientInfo>> getAvailabilityByName (@PathVariable("name") String name) {
        List<IngredientInfo> ingredients = ingredientService.findAvailability(name);
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addIngredient(@RequestBody IngredientRequest ingredient) {
        MessageResponse newIngredient = ingredientService.createIngredient(ingredient);
        return new ResponseEntity<>(newIngredient, HttpStatus.CREATED);
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
