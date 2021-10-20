package com.cosmetic_app.web;

import com.cosmetic_app.data.models.DataArchive;
import com.cosmetic_app.data.payloads.request.DataArchiveRequest;
import com.cosmetic_app.data.payloads.response.MessageResponse;
import com.cosmetic_app.service.DataArchiveService;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dataArchive")
//Line 19 to 24 is the newly added code for swagger documentation
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
}
)
public class DataArchiveController {

    @Autowired
    DataArchiveService dataArchiveService;

    @GetMapping("/all")
    public ResponseEntity<List<DataArchive>> getAllDataArchive () {
        List<DataArchive> dataArchive = dataArchiveService.getAllDataArchive();
        return new ResponseEntity<>(dataArchive, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addDataArchive(@RequestBody DataArchiveRequest dataArchiveRequest) {
        MessageResponse newDataArchive = dataArchiveService.createDataArchive(dataArchiveRequest);
        return new ResponseEntity<>(newDataArchive, HttpStatus.CREATED);
    }

//    @GetMapping("/find/{name}")
//    public ResponseEntity<DataArchive> getDataArchiveById (@PathVariable("name") String name) {
//        DataArchive ingredient = dataArchiveService.findByName(name);
//        return new ResponseEntity<>(ingredient, HttpStatus.OK);
//    }
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
