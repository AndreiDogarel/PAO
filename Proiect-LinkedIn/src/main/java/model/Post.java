package model;

import interfaces.GenericClass;

import java.util.Comparator;
import java.util.Scanner;

public class Post implements GenericClass<Post>, Comparable<Post> {
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
    public void read() {
        Scanner s = new Scanner(System.in);

        System.out.println("Post title: ");
        setTitle(s.nextLine());

        System.out.println("Subject: ");
        setSubject(s.nextLine());
    }

    @Override
    public void update() {
        Scanner s = new Scanner(System.in);

        while(true) {
            System.out.println("""
                    What do you want to change?
                    1. Post title
                    2. Post subject
                    3. Back
                    """);
            int response = s.nextInt();
            s.nextLine();
            if(response == 3) {
                break;
            }
            switch (response) {
                case 1: {
                    System.out.println("Please enter the new title: ");
                    setTitle(s.nextLine());
                    break;
                }
                case 2: {
                    System.out.println("Please enter the new subject: ");
                    setSubject(s.nextLine());
                    break;
                }
                default: {
                    System.out.println("Unknown command");
                    break;
                }
            }
        }
    }

    @Override
    public int compareTo(Post other) {
        return Integer.compare(this.id, other.id);
    }
}
