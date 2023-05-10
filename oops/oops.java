
import java.util.List;

import com.example.hr.Candidate;
import com.example.hr.HRManager;
import com.example.hr.Recruiter;

public class oops extends HRManager {

  public static void main(String[] args) {
    // Create instances of Recruiter and HRManager classes
    Recruiter recruiter = new Recruiter();
    HRManager hrManager = new HRManager();

    // Create instances of the Candidate class with sample data
    Candidate candidate1 = new Candidate(
        "John",
        "Doe",
        "2000-07-01",
        70,
        80,
        90,
        "SC",
        8.5,
        9.0,
        2,
        true,
        40,
        true);
    Candidate candidate2 = new Candidate(
        "Jane",
        "Doe",
        "1998-05-15",
        50,
        60,
        70,
        "NA",
        7.5,
        8.0,
        1,
        false,
        30,
        true);

    // Add candidates to the Recruiter's candidateList
    recruiter.addCandidate(candidate1);
    recruiter.addCandidate(candidate2);
    
    // Evaluate candidates
    recruiter.evaluateCandidates(candidate1);
    recruiter.evaluateCandidates(candidate2);
    

    // Get the list of eligible candidates from the HRManager
    List<Candidate> eligibleCandidates =
    hrManager.getEligibleCandidates(recruiter.getEvaluatedCandidates());

    // Print the list of eligible candidates
    System.out.println("Eligible Candidates:");
    for (Candidate candidate : eligibleCandidates) {
    System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
    }
  }
}
