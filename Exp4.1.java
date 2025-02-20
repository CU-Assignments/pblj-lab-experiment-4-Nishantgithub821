import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

class EmployeeManagement {
    private List<Employee> employees = new ArrayList<>();

    void addEmployee(int id, String name, double salary) {
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println("Error: Employee with ID " + id + " already exists.");
                return;
            }
        }
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee Added: " + id + ", Name=" + name + ", Salary=" + salary);
    }

    void updateEmployee(int id, double newSalary) {
        for (Employee e : employees) {
            if (e.id == id) {
                e.salary = newSalary;
                System.out.println("Employee ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("Error: Employee ID " + id + " not found.");
    }

    void removeEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().id == id) {
                iterator.remove();
                System.out.println("Employee ID " + id + " removed successfully.");
                return;
            }
        }
        System.out.println("Error: Employee ID " + id + " not found.");
    }

    void searchEmployeeByID(int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println("Employee Found: " + e);
                return;
            }
        }
        System.out.println("Error: Employee ID " + id + " not found.");
    }

    void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement();
        em.displayAllEmployees();
        em.addEmployee(101, "Anish", 50000);
        em.addEmployee(102, "Bobby", 60000);
        em.updateEmployee(101, 55000);
        em.searchEmployeeByID(102);
        em.removeEmployee(101);
        em.displayAllEmployees();
        em.addEmployee(102, "Charlie", 70000);
    }
}
