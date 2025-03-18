package Sorting_Algorithms;

public class Applicant {
    String role;
    float expectedSalary;

    public Applicant(String role, float expectedSalary) {
        this.role = role;
        this.expectedSalary = expectedSalary;
    }

    @Override
    public String toString() {
        return "Role: " + role + ", Expected Salary: " + expectedSalary;
    }
}
