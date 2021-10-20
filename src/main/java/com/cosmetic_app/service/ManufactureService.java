package com.lekwacious.employee_app.service;

import com.lekwacious.employee_app.data.models.Ingredient;
import com.lekwacious.employee_app.data.models.Manufacture;
import com.lekwacious.employee_app.data.payloads.request.ManufactureRequest;
import com.lekwacious.employee_app.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ManufactureService {
    MessageResponse createManufacture(ManufactureRequest manufactureRequest);
//    Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);
//    void deleteEmployee(Integer employeeId);
//    Employee getASingleEmployee(Integer employeeId);
    List<Manufacture> getAllManufacture();

    Manufacture findByName(String name);
}
