package com.lekwacious.employee_app.service;

import com.lekwacious.employee_app.data.models.Ingredient;
import com.lekwacious.employee_app.data.models.Manufacture;
import com.lekwacious.employee_app.data.payloads.request.ManufactureRequest;
import com.lekwacious.employee_app.data.payloads.response.MessageResponse;
import com.lekwacious.employee_app.data.repository.ManufactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactureServiceImpl implements ManufactureService {

    @Autowired
    ManufactureRepository manufactureRepository;

    @Override
    public MessageResponse createManufacture(ManufactureRequest employeeRequest) {
        Manufacture newManufacture = new Manufacture();
        newManufacture.setName(employeeRequest.getName());
        newManufacture.setAddress(employeeRequest.getAddress());
        newManufacture.setPhoneNumber(employeeRequest.getPhoneNumber());
        newManufacture.setEmail(employeeRequest.getEmail());
        newManufacture.setCountry(employeeRequest.getPhoneNumber());
        manufactureRepository.save(newManufacture);
        return new MessageResponse("New Employee created successfully");

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
    public List<Manufacture> getAllManufacture() {
        return manufactureRepository.findAll();
    }

    @Override
    public Manufacture findByName(String name) {
        return manufactureRepository.findByName(name);
    }
//    @Override
//    public void deleteEmployee(Integer employeeId) throws ResourceNotFoundException {
//        if (employeeRepository.getById(employeeId).getId().equals(employeeId)){
//            employeeRepository.deleteById(employeeId);
//        }
//        else throw new ResourceNotFoundException("Employee", "id", employeeId);
//    }
}
