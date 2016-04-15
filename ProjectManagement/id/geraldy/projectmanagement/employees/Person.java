package id.geraldy.projectmanagement.employees;

abstract class Person {
	protected String name;
	protected long id;
	protected double salary;
	
	public Person(String name, long id) {
		this.name = name;
		this.id = id;
	}
	
	public Person(String name, long id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public long getId() {
		return id;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
