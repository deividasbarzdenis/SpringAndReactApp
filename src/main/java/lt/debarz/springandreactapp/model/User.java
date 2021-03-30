package lt.debarz.springandreactapp.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lt.debarz.springandreactapp.user.UniqueUsername;
import lt.debarz.springandreactapp.user.Views;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue //default AUTO
    @JsonView(Views.Base.class)
    private Integer id;

    @NotNull( message = "stringValue has to be present")
    @Size(min = 4, max = 255)
    @UniqueUsername
    @JsonView(Views.Base.class)
    private String username;

    @NotNull(message = "{debarz.constrains.displayName.NotNull.message}")
    @Size(min = 4, max = 255)
    @JsonView(Views.Base.class)
    private String displayName;

    @NotNull(message = "{debarz.constrains.password.NotNull.message}")
    @Size(min = 8, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{8,})")
    private String password;

    @JsonView(Views.Base.class)
    private String image;

    @Override
    @Transient//do not save in DB an do not check in DB
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("Role_USER");
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }
}
