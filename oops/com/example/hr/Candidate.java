package com.example.hr;
// Candidate class 
public class Candidate {

    private String firstName;
    private String lastName;
    protected String dateOfBirth;
    private int physicsMarks;
    private int chemistryMarks;
    private int mathOrbio;
    private String category;
    private double ugCGPA;
    private double pgCGPA;
    private int numProjects;
    private boolean isFullTime;
    private int interviewMarks;
    private boolean isIndianCitizen;
  
  
    public Candidate(){}
    // Constructor to initialize candidate data fields
    public Candidate(
      String firstName,
      String lastName,
      String dateOfBirth,
      int physicsMarks,
      int chemistryMarks,
      int mathOrbio,
      String category,
      double ugCGPA,
      double pgCGPA,
      int numProjects,
      boolean isFullTime,
      int interviewMarks,
      boolean isIndianCitizen
    ) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.dateOfBirth = dateOfBirth;
      this.physicsMarks = physicsMarks;
      this.chemistryMarks = chemistryMarks;
      this.mathOrbio = mathOrbio;
      this.category = category;
      this.ugCGPA = ugCGPA;
      this.pgCGPA = pgCGPA;
      this.numProjects = numProjects;
      this.isFullTime = isFullTime;
      this.interviewMarks = interviewMarks;
      this.isIndianCitizen = isIndianCitizen;
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
      return mathOrbio;
    }
  
    public String getCategory(){
      return category;
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
    public int getInterviewMarks(){
      return interviewMarks;
    }
    public boolean getIsIndian(){
      return isIndianCitizen;
    }
    public boolean isIndianCitizen() {
      return false;
    }
  }
  