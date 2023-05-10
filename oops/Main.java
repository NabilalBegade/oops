import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create instances of Recruiter and HRManager classes
        Recruiter recruiter = new Recruiter();
        HRManager hrManager = new HRManager();

        // Create instances of the Candidate class with sample data
        Candidate candidate1 = new Candidate("John", "Doe", "01-07-1999", 70, 80, 90, 8.5, 9.0, 2, true, 40, true);
        Candidate candidate2 = new Candidate("Jane", "Doe", "15-05-1998", 50, 60, 70, 7.5, 8.0, 1, false, 30, true);

        // Add candidates to the Recruiter's candidateList
        recruiter.addCandidate(candidate1);
        recruiter.addCandidate(candidate2);

        // Evaluate candidates
        recruiter.evaluateCandidates();
        
        // Get the list of eligible candidates from the HRManager
        List<Candidate> eligibleCandidates = hrManager.getEligibleCandidates(recruiter.getEvaluatedCandidates());
        
        // Print the list of eligible candidates
        System.out.println("Eligible Candidates:");
        for (Candidate candidate : eligibleCandidates) {
            System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
        }
    }
    
    
}

// Candidate class to represent a job candidate
class Candidate {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int physicsMarks;
    private int chemistryMarks;
    private int mathMarks;
    private double ugCGPA;
    private double pgCGPA;
    private int numProjects;
    private boolean isFullTime;
    private int interviewMarks;
    private boolean isIndianCitizen;
    private boolean isEvaluated;
    private double finalMarks;

    // Constructor to initialize candidate data fields
    public Candidate(String firstName, String lastName, String dateOfBirth, int physicsMarks, int chemistryMarks,
                     int mathMarks, double ugCGPA, double pgCGPA, int numProjects, boolean isFullTime,
                     int interviewMarks, boolean isIndianCitizen) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.physicsMarks = physicsMarks;
        this.chemistryMarks = chemistryMarks;
        this.mathMarks = mathMarks;
        this.ugCGPA = ugCGPA;
        this.pgCGPA = pgCGPA;
        this.numProjects = numProjects;
        this.isFullTime = isFullTime;
        this.interviewMarks = interviewMarks;
        this.isIndianCitizen = isIndianCitizen;
        this.isEvaluated = false;
        this.finalMarks = 0.0;
    }

    // Getter methods for candidate data fields
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPhysicsMarks() {
        return physicsMarks;
    }

    public int getChemistryMarks() {
        return chemistryMarks;
    }

    public int getMathMarks() {
        return mathMarks;
    }

    public double getUgCGPA() {
        return ugCGPA;
    }

    public double getPgCGPA() {
        return pgCGPA;
    }

    public int getNumProjects() {
        return numProjects;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

}

/**
 * Recruiter
 */
class Recruiter {
    private List<Candidate> candidates;

    public Recruiter() {
        this.candidates = new ArrayList<>();
    }

    public void addCandidate(Candidate candidate) {
        if (isEligible(candidate)) {
            candidates.add(candidate);
        }
    }

    public List<Candidate> getEvaluatedCandidates() {
        return this.candidates;
    }

    private boolean isEligible(Candidate candidate) {
        // check all the eligibility criteria and return true if the candidate is eligible, false otherwise
        // A candidate whose date of birth falls on or after July 1999
        // LocalDate cutoffDate = LocalDate.parse(dobtoEligible);
        if (candidate.getDateOfBirth().isBefore((LocalDate.of(1999, Month.JULY, 1)))) {
            return false;
        }
        
        // Candidates should have secured an aggregate of 60% in Physics, Chemistry, and Mathematics/Biology in the HSC exam.
        double hscAggregate = candidate.getHsc().getPhysics() + candidate.getHsc().getChemistry() + candidate.getHsc().getMathsOrBiology();
        if (hscAggregate < 60.0) {
            return false;
        }
        
        // The average marks obtained in the subjects of physics, chemistry, mathematics, or biology (PCM or PCB) in the HSC exam put together should be 50% for the SC and ST.
        if (candidate.getCategory() == Candidate.Category.SC || candidate.getCategory() == Candidate.Category.ST) {
            double hscAverage = hscAggregate / 3.0;
            if (hscAverage < 50.0) {
                return false;
            }
        }
        
        // Candidates should have secured a CGPA of 8 or above in the UG exam.
        if (candidate.getChemistryMarks() < 8.0) {
            return false;
        }
        
        // Candidates should have secured a CGPA of 8 or above in the PG exam.
        if (candidate.getPgCgpa() < 8.0) {
            return false;
        }
        
        // The candidate should have done a minimum of two projects during the course of study.
        if (candidate.getNumProjects() < 2) {
            return false;
        }
        
        // Candidates who have studied full-time are eligible.
        if (!candidate.isFullTime()) {
            return false;
        }
        
        // Candidates should have scored 35 or above in the interview selection process.
        if (candidate.getInterviewScore() < 35) {
            return false;
        }
        
        // The candidate should be a citizen of India.
        if (!candidate.isIndian()) {
            return false;
        }
        
        return true;
    }


    public void evaluateCandidates() {
        // Iterate through all candidates
        for (Candidate candidate : candidates) {
            // Check if candidate meets all eligibility criteria
            if (candidate.getAge() >= 22 &&
                candidate.getPercentage() >= 60 &&
                (candidate.getCategory().equals("General") || candidate.getAveragePCM() >= 50) &&
                candidate.getUgCGPA() >= 8 &&
                candidate.getPgCGPA() >= 8 &&
                candidate.getNumProjects() >= 2 &&
                candidate.isFullTime() &&
                candidate.getInterviewScore() >= 35 &&
                candidate.isIndianCitizen()) {
                
                // Add candidate to selected candidates list
                selectedCandidates.add(candidate);
            }
        }
    }
    
}


/**
 * HRManager
 */
class HRManager { 
    public void informCandidates(List<Candidate> eligibleCandidates) {
        // Code to inform candidates of the results
        // ...
    }
    
    public List<Candidate> getEligibleCandidates(List<Candidate> evaluatedCandidates) {
        List<Candidate> eligibleCandidates = new ArrayList<>();
        // Iterate through evaluated candidates
        for (Candidate candidate : evaluatedCandidates) {
            // Check if candidate's date of birth is after July 1999
            if (candidate.getDob().isAfter(LocalDate.of(1999, Month.JULY, 1))) {
                eligibleCandidates.add(candidate);
            }
        }
        return eligibleCandidates;
    }
}




// our previouos conversation was cutoff[]can u continue onwords and complete it