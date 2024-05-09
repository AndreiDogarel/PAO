package service;

import interfaces.GenericService;
import model.Post;

import java.util.Scanner;

public class PostService implements GenericService<Post> {
    @Override
    public Post read() {
        Post post = new Post();
        Scanner s = new Scanner(System.in);

        System.out.println("Post title: ");
        post.setTitle(s.nextLine());

        System.out.println("Subject: ");
        post.setSubject(s.nextLine());

        return post;
    }

    @Override
    public void update(Post post) {
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
                    post.setTitle(s.nextLine());
                    break;
                }
                case 2: {
                    System.out.println("Please enter the new subject: ");
                    post.setSubject(s.nextLine());
                    break;
                }
                default: {
                    System.out.println("Unknown command");
                    break;
                }
            }
        }
    }
}
