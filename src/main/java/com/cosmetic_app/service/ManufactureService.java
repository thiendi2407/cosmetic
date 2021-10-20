package com.cosmetic_app.service;

import com.cosmetic_app.data.models.IngredientInfo;
import com.cosmetic_app.data.models.Manufacture;
import com.cosmetic_app.data.models.ManufactureInfo;
import com.cosmetic_app.data.payloads.request.ManufactureRequest;
import com.cosmetic_app.data.payloads.response.MessageResponse;
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

    List<ManufactureInfo> findAvailability(String name);
}
