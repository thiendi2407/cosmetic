package com.cosmetic_app.service;

import com.cosmetic_app.data.models.IngredientInfo;
import com.cosmetic_app.data.repository.IngredientRepository;
import com.cosmetic_app.data.models.Ingredient;
import com.cosmetic_app.data.payloads.request.IngredientRequest;
import com.cosmetic_app.data.payloads.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public MessageResponse createIngredient(IngredientRequest employeeRequest) {
        Ingredient newEmployee = new Ingredient();
        newEmployee.setName(employeeRequest.getName());
        ingredientRepository.save(newEmployee);
        return new MessageResponse("New Ingredient created successfully");
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
    public List<Ingredient> getAllIngredient() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient findByName(String name) {
        return ingredientRepository.findByName(name);
    }

    @Override
    public List<IngredientInfo> findAvailability(String name) {
        return ingredientRepository.findAvailability(name);
    }

//    @Override
//    public void deleteEmployee(Integer employeeId) throws ResourceNotFoundException {
//        if (employeeRepository.getById(employeeId).getId().equals(employeeId)){
//            employeeRepository.deleteById(employeeId);
//        }
//        else throw new ResourceNotFoundException("Employee", "id", employeeId);
//    }
}
