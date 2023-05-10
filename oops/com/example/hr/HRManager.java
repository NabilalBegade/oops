package com.example.hr;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HRManager extends Recruiter{

    public List<Candidate> getEligibleCandidates(List<Candidate> evaluatedCandidates) {
        List<Candidate> eligibleCandidates = new ArrayList<>();
        
        // Iterate through evaluated candidates
        for (Candidate candidate : evaluatedCandidates) {
             
            String dateOfBirthStr = candidate.getDateOfBirth();
            // Convert the string to a LocalDate object
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);

            // Check if candidate's date of birth is after July 1999
            if (dateOfBirth.isAfter(LocalDate.of(1999, Month.JULY, 1))) {
                eligibleCandidates.add(candidate);
            }
        }
        return eligibleCandidates;
    }
}
