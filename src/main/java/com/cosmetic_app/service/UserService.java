package com.cosmetic_app.service;

import com.cosmetic_app.data.models.Ingredient;
import com.cosmetic_app.data.models.IngredientInfo;
import com.cosmetic_app.data.models.User;
import com.cosmetic_app.data.payloads.request.IngredientRequest;
import com.cosmetic_app.data.payloads.request.ManufactureRequest;
import com.cosmetic_app.data.payloads.request.UserLoginRequest;
import com.cosmetic_app.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
//    MessageResponse createUser(IngredientRequest ingredientRequest);
////    Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);
////    void deleteEmployee(Integer employeeId);
////    Employee getASingleEmployee(Integer employeeId);
    MessageResponse createUser(UserLoginRequest request);

    List<User> getAllUser();

    User findUser(String name, String password);
}
