package com.lekwacious.employee_app.service;

import com.lekwacious.employee_app.data.models.DataArchive;
import com.lekwacious.employee_app.data.models.Ingredient;
import com.lekwacious.employee_app.data.payloads.request.DataArchiveRequest;
import com.lekwacious.employee_app.data.payloads.request.IngredientRequest;
import com.lekwacious.employee_app.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DataArchiveService {
    MessageResponse createDataArchive(DataArchiveRequest dataArchiveRequest);
//    Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);
//    void deleteEmployee(Integer employeeId);
//    Employee getASingleEmployee(Integer employeeId);
    List<DataArchive> getAllDataArchive();
}
