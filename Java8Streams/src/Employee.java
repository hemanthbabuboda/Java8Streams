
public class Employee {
	int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public String getName() { return name; }
    public int getId() { return id; }

    public String toString() {
        return "{" + id + ", " + name + ", " + department + ", " + salary + "}";
    }
}
