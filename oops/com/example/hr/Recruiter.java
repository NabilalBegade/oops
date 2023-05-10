package com.example.hr;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Recruiter
 */
public class Recruiter extends Candidate {

    private double hscAggregate;
    private List<Candidate> candidates;

    public Recruiter() {
        this.hscAggregate = 0;
        this.candidates = new ArrayList<>();
    }

    public void addCandidate(Candidate candidate) {
        if (isEligible(candidate)) {
            candidates.add(candidate);
            System.out.println("iseligible" + candidate.getFirstName());
        }
    }

    public List<Candidate> getEvaluatedCandidates() {
        return this.candidates;
    }

    private boolean isEligible(Candidate candidate) {
        // date of birth
        String dob = candidate.getDateOfBirth();

        // Convert the string to a LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthdaDate = LocalDate.parse(dob, formatter);

        if (birthdaDate.isBefore((LocalDate.of(1999, Month.JULY, 1)))) {

            return false;
        }

        // 60% aggregate
        hscAggregate = (candidate.getChemistryMarks() + candidate.getPhysicsMarks() + candidate.getMathMarks()) / 3;
        if (hscAggregate < 60.0) {

            return false;
        }

        // FOR SC ST category
        if (candidate.getCategory() == "SC" || candidate.getCategory() == "ST") {
            
            if (hscAggregate < 50.0) {
                
                return false;
            }
        }

        // Candidates should have secured a CGPA of 8 or above in the UG exam.
        if (candidate.getUgCGPA() < 8.0) {
            return false;
        }

        // Candidates should have secured a CGPA of 8 or above in the PG exam.
        if (candidate.getPgCGPA() < 8.0) {
            return false;
        }

        // The candidate should have done a minimum of two projects during the course of
        // study.
        if (candidate.getNumProjects() < 2) {
            return false;
        }

        // Candidates who have studied full-time are eligible.
        if (!candidate.isFullTime()) {
            return false;
        }

        // Candidates should have scored 35 or above in the interview selection process.
        if (candidate.getInterviewMarks() < 35) {
            return false;
        }

        // The candidate should be a citizen of India.
        if (!candidate.getIsIndian()) {
            return false;
        }

        return true;
    }

    public void evaluateCandidates(Candidate candidate) {
        // Get the date of birth as a string
        String dateOfBirthStr = candidate.getDateOfBirth();

        // Convert the string to a LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);

        // Calculate the age
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dateOfBirth, currentDate).getYears();

        // Check if candidate meets all eligibility criteria
        if (age >= 22 &&
                hscAggregate >= 60 &&
                (candidate.getCategory().equals("SC") || candidate.getCategory().equals("ST") || hscAggregate >= 50)
                &&
                candidate.getUgCGPA() >= 8 &&
                candidate.getPgCGPA() >= 8 &&
                candidate.getNumProjects() >= 2 &&
                candidate.isFullTime() &&
                candidate.getInterviewMarks() >= 35 &&
                candidate.isIndianCitizen()) {

            // Add candidate to selected candidates list
            candidates.add(candidate);
        }
    }

}
