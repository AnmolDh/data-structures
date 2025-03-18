public class Main {
    public static void main(String[] args) {
        Company cg = new Company("CG");

        cg.addEmployee(92, "John Smith");
        cg.addEmployee(31, "Jake Williams");
        cg.addEmployee(99, "James Brown");
        cg.addEmployee(11, "John Willow");

        cg.sortByEmployeeId();

        cg.displayEmployees();
    }
}