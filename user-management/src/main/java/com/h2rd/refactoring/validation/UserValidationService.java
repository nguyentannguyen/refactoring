package com.h2rd.refactoring.validation;

import com.h2rd.refactoring.model.User;

/**
 * User: nguyen
 * Date: 2014-08-06
 * Time: 3:09 AM
 */
public interface UserValidationService {

    public void validateForUserCreation(User user);

    public void validateForUserUpdate(User user);

    public void validateForUserDeletion(User user);

    public void validateForUserFinding(String name);
}
