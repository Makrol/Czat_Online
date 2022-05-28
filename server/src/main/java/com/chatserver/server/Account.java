package com.chatserver.server;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

    private @Id @GeneratedValue Long id;
    private String name;
    private String surname;
    private String login;
    private String password;


    Account(String name, String surname,String login,String password) {

        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public Account() {

    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String role) {
        this.surname = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Account))
            return false;
        Account account = (Account) o;
        return Objects.equals(this.id, account.id) && Objects.equals(this.name, account.name)
                && Objects.equals(this.surname, account.surname)&& Objects.equals(this.login, account.login)
                && Objects.equals(this.password, account.password);
    }
/*
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.surname);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.surname + '\'' + '}';
    }*/
}