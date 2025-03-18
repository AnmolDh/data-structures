import java.util.ArrayList;

public class Company {
    private String name;
    private final ArrayList<Employee> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(int id, String name) {
        employees.add(new Employee(id, name));
    }

    public void sortByEmployeeId() {
        for (int i = 1; i < employees.size(); i++) {
            Employee temp = employees.get(i);
            int j = i-1;
            while (j >= 0 && employees.get(j).getId() > temp.getId()) {
                employees.set(j+1, employees.get(j));
                j--;
            }
            employees.set(j+1, temp);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
