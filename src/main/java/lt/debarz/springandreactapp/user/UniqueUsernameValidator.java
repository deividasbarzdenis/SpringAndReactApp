package lt.debarz.springandreactapp.user;


import lt.debarz.springandreactapp.model.User;
import lt.debarz.springandreactapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User inDb = userRepository.findByUserName(value);
        if(inDb == null){
            return true;
        }
        return false;
    }
}
