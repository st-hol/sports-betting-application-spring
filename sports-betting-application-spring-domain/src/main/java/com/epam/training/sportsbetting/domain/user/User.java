package com.epam.training.sportsbetting.domain.user;

import com.epam.training.sportsbetting.domain.user.role.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String email;
    protected String password;
    @Transient
    protected String passwordConfirm;
    @ManyToMany
    @JoinTable(name = "users_has_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    protected Set<Role> roles = new HashSet<>();
    protected boolean enabled;

}
