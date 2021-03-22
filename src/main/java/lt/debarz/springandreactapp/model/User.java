package lt.debarz.springandreactapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue //default AUTO
    private Long id;

    @NotNull( message = "stringValue has to be present")
    //@Column(nullable = false)
    @Size(min = 4, max = 255)
    private String username;

    @NotNull(message = "{debarz.constrains.displayName.NotNull.message}")
    //@Column(nullable = false)
    @Size(min = 4, max = 255)
    private String displayName;

    @NotNull(message = "{debarz.constrains.password.NotNull.message}")
    //@Column(nullable = false)
    @Size(min = 8, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{8,})")
    private String password;
}
