package com.h2rd.refactoring.validation;

import com.h2rd.refactoring.exception.ValidationRuntimeException;
import com.h2rd.refactoring.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * User: nguyen
 * Date: 2014-08-06
 * Time: 3:09 AM
 */
@Service
public class UserValidationServiceImpl implements UserValidationService{

    public void validateForUserCreation(User user){
        validateForUserUpdate(user);
    }

    public void validateForUserUpdate(User user){
        validateName(user.getName());
        validateEmail(user.getEmail());
        validateRoles(user.getRoles());
    }

    public void validateForUserDeletion(User user){
        validateName(user.getName());
    }

    public void validateForUserFinding(String name){
        validateName(name);
    }

    private void validateName(String name){
        if (StringUtils.isEmpty(name)){
            throw new ValidationRuntimeException("Name is not valid");
        }
    }

    private void validateEmail(String email){
        if (StringUtils.isEmpty(email)){
            throw new ValidationRuntimeException("Email is not valid");
        }
    }

    private void validateRoles(List<String> roles){
        if (CollectionUtils.isEmpty(roles)){
            throw new ValidationRuntimeException("Role is not valid");
        }
    }
}
