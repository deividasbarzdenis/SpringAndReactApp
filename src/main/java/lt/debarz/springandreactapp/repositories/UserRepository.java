package lt.debarz.springandreactapp.repositories;

import lt.debarz.springandreactapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
