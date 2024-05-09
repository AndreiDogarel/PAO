package view;

import database.DatabaseConnection;
import model.*;
import persistence.*;
import service.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;


public class ConsoleApp {
    private User user;
    private static ConsoleApp instance;
    private DatabaseConnection db;
    private UserRepository _userRepository;
    private EducationRepository _educationRepository;
    private ExperienceRepository _experienceRepository;
    private CertificationRepository _certificationRepository;
    private PostRepository _postRepository;
    private UserService _userService;
    private EducationService _educationService;
    private ExperienceService _experienceService;
    private CertificationService _certificationService;
    private PostService _postService;
    private TreeSet<Post> feed;

    private ConsoleApp() {
        db = DatabaseConnection.getInstance();
        _userRepository = new UserRepository(db);
        _certificationRepository = new CertificationRepository(db);
        _educationRepository = new EducationRepository(db);
        _experienceRepository = new ExperienceRepository(db);
        _postRepository = new PostRepository(db);
        _educationService = new EducationService();
        _experienceService = new ExperienceService();
        _certificationService = new CertificationService();
        _userService = new UserService(_experienceService, _educationService, _certificationService);
        _postService = new PostService();
        this.feed = new TreeSet<>();
    }

    public static ConsoleApp getInstance() {
        if(instance == null) {
            instance = new ConsoleApp();
        }
        return instance;
    }

    public void start() {
        Scanner s = new Scanner(System.in);

        System.out.println("""
                Welcome!
                1. Register
                2. Login
                """);
        int response = s.nextInt();
        s.nextLine();
        if(response == 1) {
            System.out.println("""
                    You work as a:
                    1. Student
                    2. Frontend Developer
                    3. Backend Developer
                    4. Fullstack Developer
                    5. Other
                    """);
            response = s.nextInt();
            s.nextLine();
            switch (response) {
                case 1: {
                    user = new Student();
                    break;
                }
                case 2: {
                    user = new FrontendDeveloper();
                    break;
                }
                case 3: {
                    user = new BackendDeveloper();
                    break;
                }
                case 4: {
                    user = new FullstackDeveloper();
                    break;
                }
                default: {
                    user = new User();
                    break;
                }
            }
            user = _userService.read();
            _userRepository.add(user);
            System.out.println("User registered successfully!");
            postAuthMenu();
        }
        else {
            System.out.println("Enter email:");
            String email = s.nextLine();

            System.out.println("Enter password:");
            String password = s.nextLine();

            User loginUser = _userRepository.getByEmail(email);
            if (loginUser != null && password.equals(loginUser.getPassword())) {
                System.out.println("Logged in successfully!");
                user = loginUser;
                postAuthMenu();
            } else {
                System.out.println("Invalid email or password!");
            }
        }
    }

    private void postAuthMenu() {
        Scanner s = new Scanner(System.in);

        while(true) {
            System.out.println("""
                    Choose an option:
                    1. View profile
                    2. Update profile
                    3. Add a post
                    4. Update a post
                    5. Delete a post
                    6. Watch feed
                    7. Log out
                    """);
            int response = s.nextInt();
            if(response == 7) {
                break;
            }
            switch (response) {
                case 1: {
                    System.out.println(user.toString());
                    break;
                }
                case 2: {
                    _userService.update(user);
                    _userRepository.update(user);
                    System.out.println("User updated successfully!");
                    break;
                }
                case 3: {
                    Post post = _postService.read();
                    post.setNameOfUser(user.getUsername());
                    feed.add(post);
                    _postRepository.add(post);
                    System.out.println("Successfully posted!");
                    break;
                }
                case 4: {
                    String username = user.getUsername();
                    ArrayList<Post> userPosts = _postRepository.getAllForUser(username);
                    if(userPosts.isEmpty()) {
                        System.out.println("This user hasn't posted anything!");
                    } else {
                        for(Post userPost : userPosts) {
                            System.out.println(userPost.toString());
                        }
                        System.out.println("Enter the id of the post you want to update: ");
                        response = s.nextInt();
                        Post updatePost = _postRepository.get(response);
                        if(updatePost != null) {
                            _postService.update(updatePost);
                            _postRepository.update(updatePost);
                            System.out.println("Post updated successfully!");
                        }
                    }
                    break;
                }
                case 5: {
                    String username = user.getUsername();
                    ArrayList<Post> userPosts = _postRepository.getAllForUser(username);
                    if(userPosts.isEmpty()) {
                        System.out.println("This user hasn't posted anything!");
                    } else {
                        for(Post userPost : userPosts) {
                            System.out.println(userPost.toString());
                        }
                        System.out.println("Enter the id of the post you want to delete: ");
                        response = s.nextInt();
                        Post deletePost = _postRepository.get(response);
                        if(deletePost != null) {
                            feed.remove(deletePost);
                            _postRepository.delete(deletePost);
                            System.out.println("Post deleted successfully!");
                        }
                    }
                    break;
                }
                case 6: {
                    feed.forEach(System.out::println);
                    break;
                }
                default: {
                    System.out.println("Unknown command");
                }
            }
        }
    }
}
