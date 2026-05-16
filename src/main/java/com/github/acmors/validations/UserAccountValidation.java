package com.github.acmors.validations;

import com.github.acmors.dto.user.UpdateUserPassword;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class UserAccountValidation {

    public void validatePassword(UpdateUserPassword update, String passwordDB) throws BadRequestException {
        if (!passwordDB.equals(update.getCurrentPassword())) throw new BadRequestException("Current password is incorrect.");
        if (nullOrBlank(update.getCurrentPassword()) || nullOrBlank(update.getUpdatedPassword()) || nullOrBlank(update.getConfirmPassword())) throw new BadRequestException("Password fields cannot be null or blank.");
        if (!update.getUpdatedPassword().equals(update.getConfirmPassword())) throw new BadRequestException("Password do not match");
    }

    private boolean nullOrBlank(String s) {
        return s == null || s.isBlank();
    }
}
