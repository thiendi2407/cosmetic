package com.cosmetic_app.service;

import com.cosmetic_app.data.models.DataArchive;
import com.cosmetic_app.data.payloads.request.DataArchiveRequest;
import com.cosmetic_app.data.payloads.response.MessageResponse;
import com.cosmetic_app.data.repository.DataArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataArchiveServiceImpl implements DataArchiveService {

    @Autowired
    DataArchiveRepository dataArchiveRepository;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    ManufactureService manufactureService;

    @Override
    public MessageResponse createDataArchive(DataArchiveRequest dataArchiveRequest) {
        DataArchive newDataRecord = new DataArchive();
        newDataRecord.setQuantity(dataArchiveRequest.getQuantity());
        newDataRecord.setMetricType(dataArchiveRequest.getMetricType());
        newDataRecord.setManufactureId(manufactureService.findByName(dataArchiveRequest.getManufactureName()).getId());
        newDataRecord.setIngredientId(ingredientService.findByName(dataArchiveRequest.getIngredientName()).getId());
        dataArchiveRepository.save(newDataRecord);
        return new MessageResponse("New data record created successfully");
    }

//
//    @Override
//    public Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest)  throws ResourceNotFoundException{
//        Optional<Employee> employee = employeeRepository.findById(employeeId);
//        if (employee.isEmpty()){
//        throw new ResourceNotFoundException("Employee", "id", employeeId);
//        }
//        else
//        employee.get().setFirstName(employeeRequest.getFirstName());
//        employee.get().setLastname(employeeRequest.getLastname());
//        employee.get().setPhoneNumber(employeeRequest.getPhoneNumber());
//        employee.get().setEmail(employeeRequest.getEmail());
//        employee.get().setSalary(employeeRequest.getSalary());
//        employee.get().setDepartment(employeeRequest.getDepartment());
//        employeeRepository.save(employee.get());
//        return employee;
//    }
//
//    @Override
//    public Employee getASingleEmployee(Integer employeeId) throws ResourceNotFoundException{
//        return employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
//    }

    @Override
    public List<DataArchive> getAllDataArchive() {
        return dataArchiveRepository.findAll();
    }

//    @Override
//    public void deleteEmployee(Integer employeeId) throws ResourceNotFoundException {
//        if (employeeRepository.getById(employeeId).getId().equals(employeeId)){
//            employeeRepository.deleteById(employeeId);
//        }
//        else throw new ResourceNotFoundException("Employee", "id", employeeId);
//    }
}
