package lt.debarz.springandreactapp.services;


import lt.debarz.springandreactapp.execeptions.DuplicatedUsernameException;
import lt.debarz.springandreactapp.model.User;
import lt.debarz.springandreactapp.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    UserRepository userRepository;

    BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
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
