/*

KELOMPOK 2
Adam Geraldy
Abby Setyo
Firda Aminy


*/

package id.kelompok2.projectmanagement.employees;

public abstract class Person {
    /**
     * 
     */
    private static final long serialVersionUID = -1L;
    private String name;
    private long id;
    private double salary;
    private String password;
    private String fullName; 

    public Person() {}

    public Person(String name, long id, String password) {
            this.name = name;
            this.id = id;
            this.password = password;
    }

    public Person(String name, long id, double salary, String password) {
            this.name = name;
            this.id = id;
            this.salary = salary;
            this.password = password;
    }

    public String getName() {
            return name;
    }

    public String getPassword() {
            return password;
    }

    public long getId() {
            return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
	
    public double getSalary() {
            return salary;
    }

    public void setName(String name) {
            this.name = name;
    }

    public void setPassword(String password) {
            this.password = password;
    }

    public void setId(long id) {
            this.id = id;
    }

    public void setSalary(double salary) {
            this.salary = salary;
    }
}
