package com.kweb.form;

import com.kweb.config.constant.Regexes;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@Data
public class UserJoinForm {
    @NotEmpty
    @Email
    private String email;
    @Pattern(regexp = Regexes.REGEX_USER_PASSWORD)
    private String passwordOrig;
    @Pattern(regexp = Regexes.REGEX_USER_PASSWORD)
    private String passwordConf;

    @AssertTrue(message = "passVerify field should be equal than pass field")
    private boolean isPasswordConfirm() {
        return passwordOrig.equals(passwordConf);
    }

    public String getPassword() {
        return passwordOrig;
    }
}
