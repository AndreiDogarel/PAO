package model;

import interfaces.GenericClass;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class User implements GenericClass<User> {
    protected int id;
    protected String username;
    protected String email;
    protected String password;
    protected String fullName;
    protected ArrayList<Education> education;
    protected ArrayList<Experience> experience;
    protected ArrayList<Certification> certifications;

    public User(int id, String username, String email, String password, String fullName,
                ArrayList<Education> education,
                ArrayList<Experience> experience,
                ArrayList<Certification> certifications) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.education = education;
        this.experience = experience;
        this.certifications = certifications;
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

    @Override
    public void read() {
        Scanner s = new Scanner(System.in);
        String response;

        System.out.println("Please enter your username: ");
        setUsername(s.nextLine());

        System.out.println("Please enter your email: ");
        setEmail(s.nextLine());

        System.out.println("Please enter your password");
        response = s.nextLine();
        System.out.println("Please confirm your password: ");
        String passwordConfirmation = s.nextLine();
        if(response.equals(passwordConfirmation)) {
            setPassword(response);
        }

        System.out.println("Please enter your full name: ");
        setFullName(s.nextLine());

        System.out.println("Add education? (yes/no): ");
        response = s.nextLine();
        if(response.equalsIgnoreCase("yes")) {
            Education education = new Education();
            education.read();
            this.education.add(education);
        }

        System.out.println("Add experience? (yes/no): ");
        response = s.nextLine();
        if(response.equalsIgnoreCase("yes")) {
            Experience experience = new Experience();
            experience.read();
            this.experience.add(experience);
        }

        System.out.println("Add certification? (yes/no): ");
        response = s.nextLine();
        if(response.equalsIgnoreCase("yes")) {
            Certification certification = new Certification();
            certification.read();
            this.certifications.add(certification);
        }
    }

    @Override
    public void update() {

    }
}