package com.cosmetic_app.service;

import com.cosmetic_app.data.models.Ingredient;
import com.cosmetic_app.data.models.IngredientInfo;
import com.cosmetic_app.data.payloads.request.IngredientRequest;
import com.cosmetic_app.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IngredientService {
    MessageResponse createIngredient(IngredientRequest ingredientRequest);
//    Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);
//    void deleteEmployee(Integer employeeId);
//    Employee getASingleEmployee(Integer employeeId);
    List<Ingredient> getAllIngredient();

    Ingredient findByName(String name);

    List<IngredientInfo> findAvailability(String name);
}
