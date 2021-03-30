package lt.debarz.springandreactapp.services;


import lt.debarz.springandreactapp.execeptions.DuplicatedUsernameException;
import lt.debarz.springandreactapp.model.User;
import lt.debarz.springandreactapp.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        super();
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(User user){
        User inDB = userRepository.findByUsername(user.getUsername());
        if (inDB != null){
            throw new DuplicatedUsernameException();
        }
        user.setUsername(user.getUsername());
        user.setDisplayName(user.getDisplayName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
