package com.cosmetic_app.web;

import com.cosmetic_app.data.models.Ingredient;
import com.cosmetic_app.data.models.IngredientInfo;
import com.cosmetic_app.data.models.ManufactureInfo;
import com.cosmetic_app.data.payloads.request.ManufactureRequest;
import com.cosmetic_app.data.payloads.response.MessageResponse;
import com.cosmetic_app.service.ManufactureService;
import com.cosmetic_app.data.models.Manufacture;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacture")
//Line 19 to 24 is the newly added code for swagger documentation
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
}
)
public class ManufactureController {

    @Autowired
    ManufactureService manufactureService;

    @GetMapping("/all")
    public ResponseEntity<List<Manufacture>> getAllManufacture () {
        List<Manufacture> manufactures = manufactureService.getAllManufacture();
        return new ResponseEntity<>(manufactures, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<Manufacture> getIngredientById (@PathVariable("name") String name) {
        Manufacture manufacture = manufactureService.findByName(name);
        return new ResponseEntity<>(manufacture, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addManufacture(@RequestBody ManufactureRequest manufactureRequest) {
        MessageResponse manufacture = manufactureService.createManufacture(manufactureRequest);
        return new ResponseEntity<>(manufacture, HttpStatus.CREATED);
    }

    @GetMapping("/find-availability/{name}")
    public ResponseEntity<List<ManufactureInfo>> getAvailabilityByName (@PathVariable("name") String name) {
        List<ManufactureInfo> manufactures = manufactureService.findAvailability(name);
        return new ResponseEntity<>(manufactures, HttpStatus.OK);
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
