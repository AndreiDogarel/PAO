package service;

import interfaces.GenericService;
import model.Experience;

import java.time.LocalDate;
import java.util.Scanner;

public class ExperienceService implements GenericService<Experience> {
    @Override
    public Experience read() {
        Experience experience = new Experience();
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter your role: ");
        experience.setJobRole(s.nextLine());

        System.out.println("Please enter the company name: ");
        experience.setCompanyName(s.nextLine());

        System.out.println("Please enter your start date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(s.nextLine());
        experience.setStartDate(date);

        System.out.println("Please enter your end date (yyyy-mm-dd): ");
        date = LocalDate.parse(s.nextLine());
        experience.setEndDate(date);

        System.out.println("Please enter your employment type: ");
        experience.setEmploymentType(s.nextLine());

        System.out.println("Please enter your job location");
        experience.setLocation(s.nextLine());

        System.out.println("Please enter your job location type: ");
        experience.setLocationType(s.nextLine());

        System.out.println("Are you currently working at this job? (yes/no): ");
        String response = s.nextLine();
        experience.setCurrentlyWorking(response.equalsIgnoreCase("yes"));

        return experience;
    }

    @Override
    public void update(Experience obj) {
        Scanner s = new Scanner(System.in);

        while(true) {
            System.out.println("""
                    What do you want to change?
                    1. Job role
                    2. Company name
                    3. Start date
                    4. End date
                    5. Employment type
                    6. Job location
                    7. Job location type
                    8. Back
                    """);

            int response = s.nextInt();
            s.nextLine();
            if(response == 8) {
                break;
            }
            switch (response) {
                case 1: {
                    System.out.println("Please enter the new job role: ");
                    obj.setJobRole(s.nextLine());
                    break;
                }
                case 2: {
                    System.out.println("Please enter the new company name: ");
                    obj.setCompanyName(s.nextLine());
                    break;
                }
                case 3: {
                    System.out.println("Please enter the new start date: ");
                    LocalDate date = LocalDate.parse(s.nextLine());
                    obj.setStartDate(date);
                    break;
                }
                case 4: {
                    System.out.println("Please enter the new end date: ");
                    LocalDate date = LocalDate.parse(s.nextLine());
                    obj.setEndDate(date);
                    break;
                }
                case 5: {
                    System.out.println("Please enter the new employment type: ");
                    obj.setEmploymentType(s.nextLine());
                    break;
                }
                case 6: {
                    System.out.println("Please enter the new location: ");
                    obj.setLocation(s.nextLine());
                    break;
                }
                case 7: {
                    System.out.println("Please enter the new location type: ");
                    obj.setLocationType(s.nextLine());
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
