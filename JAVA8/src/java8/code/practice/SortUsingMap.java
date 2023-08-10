package java8.code.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortUsingMap {

	public static void main(String[] args) {

		Map<String,Integer> mp =  new HashMap<>();
		mp.put("Pritish", 95);
        mp.put("Aditi", 83);
        mp.put("Harsimran", 47);
        mp.put("Preeti", 78);
        
        
       Map<String,Integer> newMap =  mp.entrySet().stream().sorted(Map.Entry.comparingByValue())
    		   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1,
                       LinkedHashMap::new));
       
       mp.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(System.out::println);
       
       System.out.println(newMap);
       
       	Map<Employee,Integer> mpEmp =  new HashMap<>();
       	mpEmp.put(new Employee(1, "Jhansi", 32, "Female", "HR", 2011, 25000.0),95);
		mpEmp.put(new Employee(2, "Smith", 25, "Male", "Sales", 2015, 13500.0),47);
		mpEmp.put(new Employee(3, "David", 29, "Male", "Infrastructure", 2012, 18000.0),83);
		mpEmp.put(new Employee(4, "Orlen", 28, "Male", "Development", 2014, 32500.0),78);
		mpEmp.put(new Employee(5, "Charles", 27, "Male", "HR", 2013, 22700.0),99);
		mpEmp.put(new Employee(6, "Cathy", 43, "Male", "Security", 2016, 10500.0),93);
		mpEmp.put(new Employee(7, "Ramesh", 35, "Male", "Finance", 2010, 27000.0),18);
		mpEmp.put(new Employee(8, "Suresh", 31, "Male", "Development", 2015, 34500.0),12);
		mpEmp.put(new Employee(9, "Gita", 24, "Female", "Sales", 2016, 11500.0),9);
		mpEmp.put(new Employee(10, "Mahesh", 38, "Male", "Security", 2015, 11000.5),5);
		mpEmp.put(new Employee(11, "Gouri", 27, "Female", "Infrastructure", 2014, 15700.0),36);
		mpEmp.put(new Employee(12, "Nithin", 25, "Male", "Development", 2016, 28200.0),63);
		mpEmp.put(new Employee(13, "Swathi", 27, "Female", "Finance", 2013, 21300.0),10);
		mpEmp.put(new Employee(14, "Buttler", 24, "Male", "Sales", 2017, 10700.5),11);
		mpEmp.put(new Employee(15, "Ashok", 23, "Male", "Infrastructure", 2018, 12700.0),57);
		mpEmp.put(new Employee(16, "Sanvi", 26, "Female", "Development", 2015, 28900.0),9);
		
		mpEmp.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getYearOfJoining))).forEach(System.out::println);
	}

}
