package java8.code.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UsingReduce {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int result = numbers.stream().reduce(Integer::sum).get();
		int result1 = numbers.stream().reduce(1, (a, b) -> a * b);
		System.out.println(result);

		List<String> words = Arrays.asList("Helloo", " ", "world", "!!");

		String concatenated = words.stream().reduce("", (acc, word) -> acc + word);

		System.out.println("Concatenated: " + concatenated);

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
		System.out.println("-------------------------------1---------------------------------");
		// 1. Given a list of integers, calculate the sum of the squares of all even
		// numbers in the list.
		int sumOfSqure = numbers.stream().filter(f -> f % 2 == 0).map(m -> m * m).reduce(Integer::sum).get();
		System.out.println(sumOfSqure);
		System.out.println("-------------------------------2---------------------------------");
		// 2.Given a list of strings, find the longest string using the reduce method.
		String longestString = words.stream().reduce((a, b) -> a.length() > b.length() ? a : b).get();
		System.out.println(longestString);
		System.out.println("-------------------------------3---------------------------------");
		// 3.Given a list of names, capitalize the first letter of each name and return
		// the modified list using the map operation.
		words.stream().map(m -> m.substring(0, 1).toUpperCase() + m.substring(1).toLowerCase())
				.collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("-------------------------------4---------------------------------");
		// 4.Given a list of Person objects (with name and age attributes), calculate
		// the average age of all people in the list.
		Double ageAvg = employeeList.stream().mapToInt(e -> e.getAge()).average().getAsDouble();
		System.out.println(ageAvg);
		System.out.println("-------------------------------5---------------------------------");
		// Given a list of words, group them into a map where the key is the length of
		// the word, and the value is a list of words with that length.
		Map<Integer, String> mapVal = words.stream()
				.collect(Collectors.toMap(String::length, Function.identity(), (e1, e2) -> e1, LinkedHashMap::new));
		mapVal.forEach((k, v) -> System.out.println(k + " " + v));

		Map<Integer, List<String>> mapVal1 = words.stream().collect(Collectors.groupingBy(String::length));
		mapVal1.forEach((k, v) -> System.out.println(k + " " + v));
		System.out.println("-------------------------------6---------------------------------");
		// Given a list of strings, concatenate them into a single string using the
		// reduce method.
		String singleStr = words.stream().reduce("", (a, b) -> a + b);
		System.out.println(singleStr);
		System.out.println("-------------------------------7---------------------------------");
		// Given a list of words, count the occurrences of each word and store them in a
		// map.
		words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + " -> " + v));
		System.out.println("-------------------------------8---------------------------------");
		// Given a list of strings, reverse each string and return the modified list.
		words.stream().map(m -> new StringBuilder(m).reverse()).forEach(System.out::println);

	}

}
