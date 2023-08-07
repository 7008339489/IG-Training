package java8.code.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SetB {

	public static void main(String[] args) {
		
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(1, "Jhansi", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(2, "Smith", 25, "Male", "Sales", 2015, 13500.0));
		employeeList.add(new Employee(3, "David", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(4, "Orlen", 28, "Male", "Development", 2014, 32500.0));
		employeeList.add(new Employee(5, "Charles", 27, "Male", "HR", 2013, 22700.0));
		employeeList.add(new Employee(6, "Cathy", 43, "Male", "Security", 2016, 10500.0));
		employeeList.add(new Employee(7, "Ramesh", 35, "Male", "Finance", 2010, 27000.0));
		employeeList.add(new Employee(8, "Suresh", 31, "Male", "Development", 2015, 34500.0));
		employeeList.add(new Employee(9, "Gita", 24, "Female", "Sales", 2016, 11500.0));
		employeeList.add(new Employee(10, "Mahesh", 38, "Male", "Security", 2015, 11000.5));
		employeeList.add(new Employee(11, "Gouri", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(12, "Nithin", 25, "Male", "Development", 2016, 28200.0));
		employeeList.add(new Employee(13, "Swathi", 27, "Female", "Finance", 2013, 21300.0));
		employeeList.add(new Employee(14, "Buttler", 24, "Male", "Sales", 2017, 10700.5));
		employeeList.add(new Employee(15, "Ashok", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(16, "Sanvi", 26, "Female", "Development", 2015, 28900.0));
		
		
	//1.How many male and female employees are there in the organization?
		employeeList.stream().collect(Collectors.groupingBy(g->g.getGender(),Collectors.counting()))
		.forEach((k,v)-> System.out.println(k+" : "+v));

	  //2.Print the name of all departments in the organization?
		employeeList.stream().map(m-> m.getDepartment()).collect(Collectors.toList())
		.forEach(System.out::println);

	 // 3. What is the average age of male and female employees?
		Double avg = employeeList.stream().filter(f -> f.getGender().equals("Male") || f.getGender().equals("Female"))
		.mapToInt(m -> m.getAge()).average().getAsDouble();
		System.out.println(avg);

	  //4.Get the details of highest paid employee in the organization?
		Employee highestPaidEmployee = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
		System.out.println("Highest Paid Employee : "+highestPaidEmployee);

//	  5.Get the names of all employees who have joined after 2015?
		employeeList.stream().filter(f->f.getYearOfJoining()>2015).collect(Collectors.toList())
		.forEach(System.out::println);

//	  6.Count the number of employees in each department?
		employeeList.stream().collect(Collectors.groupingBy(d -> d.getDepartment(),Collectors.counting()));

//	  7.What is the average salary of each department?
		Double averageSalary = employeeList.stream().mapToDouble(m->m.getSalary()).mapToInt(i->(int)i).average().getAsDouble();
		System.out.println(averageSalary);
		
//	  8.Get the details of youngest male employee in the product development
		Employee youngestMaleEmployee = employeeList.stream().filter(p -> p.getDepartment().equals("Development") && p.getGender().equals("Male"))
						.min(Comparator.comparingInt(Employee::getAge)).get();
		System.out.println(youngestMaleEmployee);
				
//	  9.Who has the most working experience in the organization?
		Employee mostWorkingExperience = employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get();
		System.out.println("Most working experience : "+mostWorkingExperience);
		
//	  10.How many male and female employees are there in the sales and marketing team?
		employeeList.stream().filter(f-> f.getDepartment().equals("Sales"))
		.collect(Collectors.groupingBy(gender -> gender.getGender(),Collectors.counting()))
		.forEach((k,v) -> System.out.println(k + " : "+v));

//	  11.What is the average salary of male and female employees?
		employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)))
		.forEach((k,v) -> System.out.println("Gender : "+k + " Avarage : "+v));
		
		
//	12.List down the names of all employees in each department?
		employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.groupingBy(Employee::getName)))
		.forEach((k,v)->System.out.println("Department : "+ k + " Names : "+v));
		
//	13 What is the average salary and total salary of the whole organization?
		/*
		 * employeeList.stream()
		 * .collect(Collectors.toMap(Collectors.averagingDouble(Employee::getSalary),));
		 */
		
//	14 Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years?
//	15 Who is the oldest employee in the organization? What is his age and which department he belongs to?
	        		}

}
