package java8.code.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SetA {

	public static void main(String[] args) {

		String[] str = { "", "Pavan", "Pritish", "", "Vartika", "Amit" };
		Integer[] i = { 11, 22, 31, 13, 98, 222, 111, 22 };

		List<Integer> l = Arrays.asList(i);
		List<String> s = Arrays.asList(str);

		// Given a list of integers, find out all the even numbers exist in the list
		// using Stream functions?
		List<Integer> even = l.stream().filter(f -> f % 2 == 0).collect(Collectors.toList());
		System.out.println("even : " + even);

		// Given a list of integers, find out all the numbers starting with 1 using
		// Stream functions?
		List<Integer> stringStarts1 = l.stream().map(m -> m + "").filter(f -> f.startsWith("1"))
				.map(m -> Integer.parseInt(m)).collect(Collectors.toList());
		System.out.println("stringStarts1 : " + stringStarts1);

		// How to find duplicate elements in a given integers list in java using Stream
		// functions?
		Map<Integer, Long> duplicateElement = l.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("duplicateElement: " + duplicateElement);

		// Given the list of integers, find the first element of the list using Stream
		// functions?
		Integer firstElement = l.stream().findFirst().get();
		System.out.println("firstElement : " + firstElement);

		// Given a list of integers, find the total number of elements present in the
		// list using Stream functions?
		Long total = l.stream().count();
		System.out.println("total : " + total);

		// Given a list of integers, find the maximum value element present in it using
		// Stream functions?
		Integer max = l.stream().max(Comparator.comparingInt(Integer::intValue)).get();
		System.out.println("max : " + max);

		// Given a String, find the first non-repeated character in it using Stream
		// functions?
		Integer nonRepeatedCharacter = l.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(f -> f.getValue() == 1).map(m -> m.getKey()).findFirst().get();
		System.out.println("FirstNonRepeatedCharacter : " + nonRepeatedCharacter);

		// Given a String, find the first repeated character in it using Stream
		// functions
		Integer repeatedCharacter = l.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(f -> f.getValue() != 1).map(m -> m.getKey()).findFirst().get();
		System.out.println("FirstRepeatedCharacter : " + repeatedCharacter);

//				Given a list of integers, sort all the values present in it using Stream functions?
		List<Integer> sortAllValues = l.stream().sorted().collect(Collectors.toList());
		System.out.println("sortAllValues : " + sortAllValues);

//				Given a list of integers, sort all the values present in it in descending order using Stream functions?
		List<Integer> sortDescending = l.stream().sorted((l1, l2) -> l2.compareTo(l1)).collect(Collectors.toList());
		List<Integer> sortDescending1 = l.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());
		System.out.println("sortDescending : " + sortDescending);
		System.out.println("sortDescending other Approche : " + sortDescending1);

//				Counting Empty String
		Long emptyStringCount = s.stream().filter(f -> f.isEmpty()).count();
		System.out.println("emptyStringCount : " + emptyStringCount);

//				Count String whose length is more than three
		  Long moreThanThreeLengthCount =
		  s.stream().filter(f -> !f.isEmpty()).collect(Collectors.toMap(Function.identity(), String::length))
		  .entrySet().stream().filter(f -> f.getValue() > 3).count();
		  System.out.println("moreThanThreeLengthCount : " + moreThanThreeLengthCount);
		 

//				Count number of String which starts with "a"
		Long stringStartsWithACount = s.stream().filter(f -> f.startsWith("s")).count();
		System.out.println("stringStartsWithACount : " + stringStartsWithACount);

//				Remove all empty Strings from List
		List<String> removeEmpty = s.stream().filter(f -> !f.isEmpty()).collect(Collectors.toList());
		System.out.println("removeEmpty : " + removeEmpty);

//				Create a List with String more than 2 characters
		List<String> moreThanTwoChar = s.stream().filter(f -> !f.equals("")).collect(Collectors.toMap(Function.identity(), String::length))
				.entrySet().stream().filter(f -> f.getValue() > 2).map(m -> m.getKey()).collect(Collectors.toList());
		System.out.println(moreThanTwoChar);

//				Convert String to uppercase and Join them with coma
		String stringToUpper = s.stream().map(m -> m.toUpperCase() + ",").collect(Collectors.joining());
		System.out.println("stringToUpper : " + stringToUpper);

//				Create a List of the square of all distinct numbers
		l.stream().distinct().map(m -> m*m).collect(Collectors.toList());

//				Get count, min, max, sum, and the average for numbers
		l.stream().min(Comparator.comparing(Integer::intValue));
		l.stream().max(Comparator.comparing(Integer::intValue));
		l.stream().mapToInt(m -> m).sum();
		l.stream().mapToInt(m -> m).average();
	}

}
