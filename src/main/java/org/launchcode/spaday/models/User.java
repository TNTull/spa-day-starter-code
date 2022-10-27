//Teresa Tull worked on this on 10-24-2022 java ch 14 studio in class

package org.launchcode.spaday.models;
import javax.validation.constraints.Size;

public class User {

    private static int nextId = 1;
    private int id;

    @Size(min = 3)
    private static String username;
    private static String email;
    private static String password;


    public User() {
        super();
        this.id = nextId++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return this.id;
    }
}


