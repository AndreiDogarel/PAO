package model;

import database.DatabaseConnection;
import interfaces.GenericClass;
import persistence.CertificationRepository;
import persistence.EducationRepository;
import persistence.ExperienceRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    protected int id;
    protected String username;
    protected String email;
    protected String password;
    protected String fullName;
    protected ArrayList<Education> education;
    protected ArrayList<Experience> experience;
    protected ArrayList<Certification> certifications;

    public User() {
        this.education = new ArrayList<>();
        this.experience = new ArrayList<>();
        this.certifications = new ArrayList<>();
    }

    public User(int id, String username, String email, String password, String fullName) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.education = new ArrayList<>();
        this.experience = new ArrayList<>();
        this.certifications = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<Education> getEducation() {
        return education;
    }

    public void setEducation(ArrayList<Education> education) {
        this.education = education;
    }

    public ArrayList<Experience> getExperience() {
        return experience;
    }

    public void setExperience(ArrayList<Experience> experience) {
        this.experience = experience;
    }

    public ArrayList<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(ArrayList<Certification> certifications) {
        this.certifications = certifications;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", education=" + education +
                ", experience=" + experience +
                ", certifications=" + certifications +
                '}';
    }


}
