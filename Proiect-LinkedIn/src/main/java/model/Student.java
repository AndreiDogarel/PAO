package model;

import java.util.ArrayList;

public class Student extends User {
    public Student() {

    }

    public Student(int id, String username, String email, String password, String fullName) {
        super(id, username, email, password, fullName);
    }
}
