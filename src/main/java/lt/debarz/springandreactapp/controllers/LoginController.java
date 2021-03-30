package lt.debarz.springandreactapp.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import lt.debarz.springandreactapp.model.User;
import lt.debarz.springandreactapp.shared.CurrentUser;
import lt.debarz.springandreactapp.user.Views;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/api/1.0/login")
    @JsonView(Views.Base.class)
    public User handleLogin(@CurrentUser User loggedInUser) {
        return loggedInUser;
    }


}
