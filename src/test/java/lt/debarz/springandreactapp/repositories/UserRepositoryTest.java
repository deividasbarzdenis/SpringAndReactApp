package lt.debarz.springandreactapp.repositories;

import lt.debarz.springandreactapp.controllers.TestUtils;
import lt.debarz.springandreactapp.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByUserName_whenUserExists_returnUser() {
        testEntityManager.persist(TestUtils.createValidUser());

        User inDB = userRepository.findByUsername("test");
        assertThat(inDB).isNotNull();
    }

    @Test
    public void findByUserName_whenUserDoesNotExists_returnUser() {
        User user = new User();
        user.setUsername("test");
        user.setDisplayName("test");
        user.setPassword("test1T123");

        testEntityManager.persist(user);
        User inDB = userRepository.findByUsername("badNameTest");
        assertThat(inDB).isNull();

    }
}