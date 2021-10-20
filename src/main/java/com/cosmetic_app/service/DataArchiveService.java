package com.cosmetic_app.service;

import com.cosmetic_app.data.models.DataArchive;
import com.cosmetic_app.data.payloads.request.DataArchiveRequest;
import com.cosmetic_app.data.payloads.response.MessageResponse;
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
