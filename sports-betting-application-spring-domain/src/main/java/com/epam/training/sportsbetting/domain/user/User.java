package com.epam.training.sportsbetting.domain.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.epam.training.sportsbetting.domain.user.role.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public abstract class User {

    @Transient
    protected String passwordConfirm;
    protected String email;
    protected String password;
    @ManyToMany
    @JoinTable(name = "users_has_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    protected Set<Role> roles = new HashSet<>();
    protected boolean enabled;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //todo refactor this
    @PrePersist
    void preInsert() {
        if (this.roles.isEmpty()) {
            Role role = new Role();
            role.setId(1L);
            role.setName("PLAYER");
            roles.add(role);
        }
    }
}
