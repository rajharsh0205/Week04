package com.generics.aidrivenresumescreeningsystem;

import java.util.ArrayList;
import java.util.List;

// Define an abstract class for Job Roles
abstract class JobRole {
    protected String candidateName;
    protected int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public abstract void displayRole();
}

// Implement specific job roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    public void displayRole() {
        System.out.println(candidateName + " applied for Software Engineer with " + experienceYears + " years of experience.");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    public void displayRole() {
        System.out.println(candidateName + " applied for Data Scientist with " + experienceYears + " years of experience.");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    public void displayRole() {
        System.out.println(candidateName + " applied for Product Manager with " + experienceYears + " years of experience.");
    }
}

// Create a Generic Resume Class
class Resume<T extends JobRole> {
    private T candidate;

    public Resume(T candidate) {
        this.candidate = candidate;
    }

    public void processResume() {
        System.out.println("Processing resume...");
        candidate.displayRole();
    }
}

// Screening Pipeline with Wildcards
class ResumeScreeningSystem {
    public static void processJobApplications(List<? extends JobRole> applications) {
        System.out.println("\n--- Screening Resumes ---");
        for (JobRole job : applications) {
            job.displayRole();
        }
    }
}

// Main Class to Run the System
public class ResumeScreeningApp {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Harsh", 3));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Raj", 5));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Om", 7));

        // Process individual resumes
        seResume.processResume();
        dsResume.processResume();
        pmResume.processResume();

        // Step 6: Batch Screening using Wildcards
        List<JobRole> applicants = new ArrayList<>();
        applicants.add(new SoftwareEngineer("Ankit", 4));
        applicants.add(new DataScientist("Rahul", 6));
        applicants.add(new ProductManager("Vishal", 8));

        ResumeScreeningSystem.processJobApplications(applicants);
    }
}
