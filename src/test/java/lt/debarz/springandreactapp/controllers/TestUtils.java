package lt.debarz.springandreactapp.controllers;

import lt.debarz.springandreactapp.model.User;

public class TestUtils {

    public static User createValidUser() {
        User user = new User();
        user.setUsername("test-user");
        user.setDisplayName("test-display");
        user.setPassword("P4ssword");
        user.setImage("profile-image.png");
        return user;
    }
}
