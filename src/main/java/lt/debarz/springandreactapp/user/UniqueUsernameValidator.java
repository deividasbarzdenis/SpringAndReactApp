package lt.debarz.springandreactapp.user;


import lombok.AllArgsConstructor;
import lt.debarz.springandreactapp.model.User;
import lt.debarz.springandreactapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {


    UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User inDb = userRepository.findByUsername(value);
        if(inDb == null){
            return true;
        }
        return false;
    }
}
