package com.lekwacious.employee_app.web;

import com.lekwacious.employee_app.data.models.Ingredient;
import com.lekwacious.employee_app.data.models.Manufacture;
import com.lekwacious.employee_app.service.IngredientService;
import com.lekwacious.employee_app.service.ManufactureService;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Ingredient> getIngredientById (@PathVariable("name") String name) {
        Ingredient ingredient = ingredientService.findByName(name);
        return new ResponseEntity<>(ingredient, HttpStatus.OK);
    }
//    @GetMapping("/find/{id}")
//    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Integer id) {
//        Employee employee = employeeService.getASingleEmployee(id);
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//    }
//    @PostMapping("/add")
//    public ResponseEntity<MessageResponse> addEmployee( @RequestBody EmployeeRequest employee) {
//        MessageResponse newEmployee = employeeService.createEmployee(employee);
//        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
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
