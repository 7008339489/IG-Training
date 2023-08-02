package IG.Training.oops;

public class Encapsulation {
	
	public int id;
	public String name;
	public Long Salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSalary() {
		return Salary;
	}
	public void setSalary(Long salary) {
		Salary = salary;
	}
	
	@Override
	public String toString() {
		return "Encapsulation [id=" + id + ", name=" + name + ", Salary=" + Salary + "]";
	}
	
}
