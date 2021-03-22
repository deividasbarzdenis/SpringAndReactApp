package lt.debarz.springandreactapp.repositories;

import lt.debarz.springandreactapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //Springas pavercia si metada JPA query , key yra "findBY", o username tai objektas kurio iesko
    User findByUsername(String username);
}
