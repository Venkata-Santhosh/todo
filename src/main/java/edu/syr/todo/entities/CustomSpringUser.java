package edu.syr.todo.entities;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

public class CustomSpringUser extends User implements UserDetails {

    public CustomSpringUser(){

    }
    public CustomSpringUser(User user){
        super(user);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public Set<Authorities> getAuthorities() {
        return super.getAuthorities();
    }
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public Set<ToDo> getToDos() {
        return super.getToDos();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
