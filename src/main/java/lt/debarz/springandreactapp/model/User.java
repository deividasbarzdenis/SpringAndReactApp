package lt.debarz.springandreactapp.model;



import lombok.Data;
import lombok.NoArgsConstructor;
import lt.debarz.springandreactapp.user.UniqueUsername;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//@Getter
//@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue //default AUTO
    private Long id;

    @NotNull(message = "{debarz.constraints.username.NotNull.message}")
    @Size(min = 4, max = 255)
    @UniqueUsername
    private String userName;

    @NotNull
    @Size(min = 4, max = 255)
    private String displayName;

    @NotNull
    @Size(min = 8, max = 255)
    //one big and one small letter, number and also special character required
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{8,})",
                    message="{debarz.Pattern.message}")
    private String password;
}
