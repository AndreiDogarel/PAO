package service;

import interfaces.GenericService;
import model.Certification;
import model.Education;
import model.Experience;
import model.User;
import persistence.CertificationRepository;
import persistence.EducationRepository;
import persistence.ExperienceRepository;

import java.util.Scanner;

public class UserService implements GenericService<User> {
    private ExperienceService _experienceService;
    private EducationService _educationService;
    private CertificationService _certificationService;
    private ExperienceRepository _experienceRepository;
    private EducationRepository _educationRepository;
    private CertificationRepository _certificationRepository;
    public UserService(ExperienceService experienceService, EducationService educationService,
                       CertificationService certificationService, ExperienceRepository experienceRepository,
                       EducationRepository educationRepository, CertificationRepository certificationRepository) {
        _experienceService = experienceService;
        _educationService = educationService;
        _certificationService = certificationService;
        _experienceRepository = experienceRepository;
        _educationRepository = educationRepository;
        _certificationRepository = certificationRepository;
    }

    @Override
    public User read() {
        User user = new User();
        Scanner s = new Scanner(System.in);
        String response;

        System.out.println("Please enter your username: ");
        user.setUsername(s.nextLine());

        System.out.println("Please enter your email: ");
        user.setEmail(s.nextLine());

        System.out.println("Please enter your password");
        response = s.nextLine();
        System.out.println("Please confirm your password: ");
        String passwordConfirmation = s.nextLine();
        if(response.equals(passwordConfirmation)) {
            user.setPassword(response);
        }

        System.out.println("Please enter your full name: ");
        user.setFullName(s.nextLine());

        System.out.println("Add education? (yes/no): ");
        response = s.nextLine();
        if(response.equalsIgnoreCase("yes")) {
            Education education = _educationService.read();
            education.setUserId(user.getId());
            user.getEducation().add(education);
            _educationRepository.add(education);
        }

        System.out.println("Add experience? (yes/no): ");
        response = s.nextLine();
        if(response.equalsIgnoreCase("yes")) {
            Experience experience = _experienceService.read();
            experience.setUserId(user.getId());
            user.getExperience().add(experience);
            _experienceRepository.add(experience);
        }

        System.out.println("Add certification? (yes/no): ");
        response = s.nextLine();
        if(response.equalsIgnoreCase("yes")) {
            Certification certification = _certificationService.read();
            certification.setUserId(user.getId());
            user.getCertifications().add(certification);
            _certificationRepository.add(certification);
        }

        return user;
    }

    @Override
    public void update(User user) {
        Scanner s = new Scanner(System.in);

        while(true) {
            System.out.println("""
                    What do you want to change?
                    1. Username
                    2. Email
                    3. Password
                    4. Full name
                    5. Education
                    6. Experience
                    7. Certifications
                    8. Back
                    """);

            int response = s.nextInt();
            s.nextLine();
            if(response == 8) {
                break;
            }
            switch (response) {
                case 1: {
                    System.out.println("Please enter the new username: ");
                    user.setUsername(s.nextLine());
                    break;
                }
                case 2: {
                    System.out.println("Please enter the new email: ");
                    user.setEmail(s.nextLine());
                    break;
                }
                case 3: {
                    System.out.println("Please enter the new password: ");
                    String newPassword = s.nextLine();
                    System.out.println("Please enter the new password confirmation: ");
                    String newPasswordConfirmation = s.nextLine();
                    if(newPasswordConfirmation.equals(newPassword)) {
                        user.setPassword(newPassword);
                    }
                    else {
                        System.out.println("The passwords do not match!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Please enter the new full name: ");
                    user.setFullName(s.nextLine());
                    break;
                }
                case 5: {
                    System.out.println("""
                            Select which operation you want:
                            1. Add education
                            2. Delete education
                            3. Update education
                            4. Back
                            """);
                    int index = s.nextInt();
                    if(index == 4) {
                        break;
                    }
                    switch (index) {
                        case 1: {
                            Education e = _educationService.read();
                            e.setUserId(user.getId());
                            user.getEducation().add(e);
                            _educationRepository.add(e);
                            break;
                        }
                        case 2: {
                            if(!user.getEducation().isEmpty()) {
                                for (int i = 0; i < user.getEducation().size(); ++i) {
                                    System.out.println((i + 1) + ". " + user.getEducation().get(i).toString());
                                }
                                System.out.println("Select which education you want to delete: ");
                                index = s.nextInt();
                                try {
                                    _educationRepository.delete(user.getEducation().get(index - 1));
                                    user.getEducation().remove(index - 1);
                                } catch (IndexOutOfBoundsException exception) {
                                    System.out.println(exception.getMessage());
                                }
                            }
                            else {
                                System.out.println("This user has no education!");
                            }
                            break;
                        }
                        case 3: {
                            if(!user.getEducation().isEmpty()) {
                                for (int i = 0; i < user.getEducation().size(); ++i) {
                                    System.out.println((i + 1) + ". " + user.getEducation().get(i).toString());
                                }
                                System.out.println("Select which education you want to update: ");
                                index = s.nextInt();
                                try {
                                    _educationService.update(user.getEducation().get(index - 1));
                                    _educationRepository.update(user.getEducation().get(index - 1));
                                } catch (IndexOutOfBoundsException exception) {
                                    System.out.println(exception.getMessage());
                                }
                            }
                            else {
                                System.out.println("This user has no education!");
                            }
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.println("""
                            Select which operation you want:
                            1. Add experience
                            2. Delete experience
                            3. Update experience
                            4. Back
                            """);
                    int index = s.nextInt();
                    if(index == 4) {
                        break;
                    }
                    switch (index) {
                        case 1: {
                            Experience e = _experienceService.read();
                            e.setUserId(user.getId());
                            user.getExperience().add(e);
                            _experienceRepository.add(e);
                            break;
                        }
                        case 2: {
                            if(!user.getExperience().isEmpty()) {
                                for (int i = 0; i < user.getExperience().size(); ++i) {
                                    System.out.println((i + 1) + ". " + user.getExperience().get(i).toString());
                                }
                                System.out.println("Select which experience you want to delete: ");
                                index = s.nextInt();
                                try {
                                    _experienceRepository.delete(user.getExperience().get(index - 1));
                                    user.getExperience().remove(index - 1);
                                } catch (IndexOutOfBoundsException exception) {
                                    System.out.println(exception.getMessage());
                                }
                            }
                            else {
                                System.out.println("This user has no experience!");
                            }
                            break;
                        }
                        case 3: {
                            if(!user.getExperience().isEmpty()) {
                                for (int i = 0; i < user.getExperience().size(); ++i) {
                                    System.out.println((i + 1) + ". " + user.getExperience().get(i).toString());
                                }
                                System.out.println("Select which experience you want to update: ");
                                index = s.nextInt();
                                try {
                                    _experienceService.update(user.getExperience().get(index - 1));
                                    _experienceRepository.update(user.getExperience().get(index - 1));
                                } catch (IndexOutOfBoundsException exception) {
                                    System.out.println(exception.getMessage());
                                }
                            }
                            else {
                                System.out.println("This user has no experience!");
                            }
                            break;
                        }
                    }
                    break;
                }
                case 7: {
                    System.out.println("""
                            Select which operation you want:
                            1. Add certification
                            2. Delete certification
                            3. Update certification
                            4. Back
                            """);
                    int index = s.nextInt();
                    if(index == 4) {
                        break;
                    }
                    switch (index) {
                        case 1: {
                            Certification e = _certificationService.read();
                            e.setUserId(user.getId());
                            user.getCertifications().add(e);
                            _certificationRepository.add(e);
                            break;
                        }
                        case 2: {
                            if(!user.getCertifications().isEmpty()) {
                                for (int i = 0; i < user.getCertifications().size(); ++i) {
                                    System.out.println((i + 1) + ". " + user.getCertifications().get(i).toString());
                                }
                                System.out.println("Select which certification you want to delete: ");
                                index = s.nextInt();
                                try {
                                    _certificationRepository.delete(user.getCertifications().get(index - 1));
                                    user.getCertifications().remove(index - 1);
                                } catch (IndexOutOfBoundsException exception) {
                                    System.out.println(exception.getMessage());
                                }
                            }
                            else {
                                System.out.println("This user has no certifications!");
                            }
                            break;
                        }
                        case 3: {
                            if(!user.getCertifications().isEmpty()) {
                                for (int i = 0; i < user.getCertifications().size(); ++i) {
                                    System.out.println((i + 1) + ". " + user.getCertifications().get(i).toString());
                                }
                                System.out.println("Select which certification you want to update: ");
                                index = s.nextInt();
                                try {
                                    _certificationService.update(user.getCertifications().get(index - 1));
                                    _certificationRepository.update(user.getCertifications().get(index - 1));
                                } catch (IndexOutOfBoundsException exception) {
                                    System.out.println(exception.getMessage());
                                }
                            }
                            else {
                                System.out.println("This user has no certifications!");
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}
