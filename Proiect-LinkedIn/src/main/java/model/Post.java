package model;

import interfaces.GenericClass;

import java.util.Comparator;
import java.util.Scanner;

public class Post implements Comparable<Post> {
    private int id;
    private String title;
    private String subject;
    private String nameOfUser;

    public Post(int id, String title, String subject, String nameOfUser) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.nameOfUser = nameOfUser;
    }

    public Post() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", nameOfUser='" + nameOfUser + '\'' +
                '}';
    }
    @Override
    public int compareTo(Post other) {
        return Integer.compare(this.id, other.id);
    }
}
