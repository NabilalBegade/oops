import java.util.ArrayList;
import java.util.List;

public class oops {

  public static void main(String[] args) {
    // Create instances of Recruiter and HRManager classes
    Recruiter recruiter = new Recruiter();
    HRManager hrManager = new HRManager();

    // Create instances of the Candidate class with sample data
    Candidate candidate1 = new Candidate(
      "John",
      "Doe",
      "01-07-1999",
      70,
      80,
      90,
      "SC",
      8.5,
      9.0,
      2,
      true,
      40,
      true
    );
    Candidate candidate2 = new Candidate(
      "Jane",
      "Doe",
      "15-05-1998",
      50,
      60,
      70,
      "NA",
      7.5,
      8.0,
      1,
      false,
      30,
      true
    );
    // Add candidates to the Recruiter's candidateList
    recruiter.addCandidate(candidate1);
    recruiter.addCandidate(candidate2);
    // Evaluate candidates
    // recruiter.evaluateCandidates();

    // Get the list of eligible candidates from the HRManager
    // List<Candidate> eligibleCandidates = hrManager.getEligibleCandidates(recruiter.getEvaluatedCandidates());

    // Print the list of eligible candidates
    // System.out.println("Eligible Candidates:");
    // for (Candidate candidate : eligibleCandidates) {
    // System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
    // }
  }
}

// Candidate class to represent a job candidate
// class Candidate {

//   private String firstName;
//   private String lastName;
//   private String dateOfBirth;
//   private int physicsMarks;
//   private int chemistryMarks;
//   private int mathOrbio;
//   private String category;
//   private double ugCGPA;
//   private double pgCGPA;
//   private int numProjects;
//   private boolean isFullTime;
//   private int interviewMarks;
//   private boolean isIndianCitizen;


//   public Candidate(){}
//   // Constructor to initialize candidate data fields
//   public Candidate(
//     String firstName,
//     String lastName,
//     String dateOfBirth,
//     int physicsMarks,
//     int chemistryMarks,
//     int mathOrbio,
//     String category,
//     double ugCGPA,
//     double pgCGPA,
//     int numProjects,
//     boolean isFullTime,
//     int interviewMarks,
//     boolean isIndianCitizen
//   ) {
//     this.firstName = firstName;
//     this.lastName = lastName;
//     this.dateOfBirth = dateOfBirth;
//     this.physicsMarks = physicsMarks;
//     this.chemistryMarks = chemistryMarks;
//     this.mathOrbio = mathOrbio;
//     this.category = category;
//     this.ugCGPA = ugCGPA;
//     this.pgCGPA = pgCGPA;
//     this.numProjects = numProjects;
//     this.isFullTime = isFullTime;
//     this.interviewMarks = interviewMarks;
//     this.isIndianCitizen = isIndianCitizen;
//   }

//   // Getter methods for candidate data fields
//   public String getFirstName() {
//     return firstName;
//   }

//   public String getLastName() {
//     return lastName;
//   }

//   public String getDateOfBirth() {
//     return dateOfBirth;
//   }

//   public int getPhysicsMarks() {
//     return physicsMarks;
//   }

//   public int getChemistryMarks() {
//     return chemistryMarks;
//   }

//   public int getMathMarks() {
//     return mathOrbio;
//   }

//   public String getCategory(){
//     return category;
//   }

//   public double getUgCGPA() {
//     return ugCGPA;
//   }

//   public double getPgCGPA() {
//     return pgCGPA;
//   }

//   public int getNumProjects() {
//     return numProjects;
//   }

//   public boolean isFullTime() {
//     return isFullTime;
//   }
//   public int getInterviewMarks(){
//     return interviewMarks;
//   }
//   public boolean getIsIndian(){
//     return isIndianCitizen;
//   }
// }

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
      System.out.println("iseligible"+ candidate.getFirstName());
    }
  }

  public List<Candidate> getEvaluatedCandidates() {
    return this.candidates;
  }

  private boolean isEligible(Candidate candidate) {
    // check all the eligibility criteria and return true if the candidate is eligible, false otherwise
        // A candidate whose date of birth falls on or after July 1999
        // LocalDate cutoffDate = LocalDate.parse(dobtoEligible);
      //   if (candidate.getDateOfBirth().isBefore((LocalDate.of(1999, Month.JULY, 1)))) {
      //     return false;
      // }
      // 60% aggregate 
      double hscAggregate = candidate.getChemistryMarks() + candidate.getPhysicsMarks() + candidate.getMathMarks();
      if ((hscAggregate/3.0) < 60.0) {
          return false;
      }

      // FOR SC ST category
      if (candidate.getCategory() == "SC" || candidate.getCategory() == "ST") {
          double hscAverage = hscAggregate / 3.0;
          if (hscAverage < 50.0) {
              return false;
          }
      }
      
      // Candidates should have secured a CGPA of 8 or above in the UG exam.
      if (candidate.getUgCGPA() < 8.0) {
          return false;
      }
      
      // Candidates should have secured a CGPA of 8 or above in the PG exam.
      if (candidate.getPgCGPA()< 8.0) {
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
      if (candidate.getInterviewMarks() < 35) {
          return false;
      }
      
      // The candidate should be a citizen of India.
      if (!candidate.getIsIndian()) {
          return false;
      }
      
    
    return true;
  }
}
