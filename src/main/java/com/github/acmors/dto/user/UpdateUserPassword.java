package com.github.acmors.dto.user;

public class UpdateUserPassword {

    private String currentPassword;
    private String updatedPassword;
    private String confirmPassword;

    public UpdateUserPassword(String currentPassword, String updatedPassword, String confirmPassword) {
        this.currentPassword = currentPassword;
        this.updatedPassword = updatedPassword;
        this.confirmPassword = confirmPassword;
    }

    public UpdateUserPassword() {
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getUpdatedPassword() {
        return updatedPassword;
    }

    public void setUpdatedPassword(String updatedPassword) {
        this.updatedPassword = updatedPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
