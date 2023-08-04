package java8.code.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		
		Integer[] i= {10,11,20,21,555,111,77,77,10,20};
		
		//1. Write a program to find the sum of all numbers in a list using Java 8 streams.
		int sum = Arrays.asList(i).stream().mapToInt(m->(int)m).sum();
		System.out.println(sum);
		
		//2. Implement a method that takes a list of strings and returns a new list containing the strings in uppercase.
		String[] s = {"Pavan","Pritish","Vartika","Amit"};
		Arrays.asList(s).stream().map(m-> m.toUpperCase())
		.collect(Collectors.toList()).forEach(a -> System.out.println(a));
		
		//3. Given a list of integers, write a program to filter out the even numbers using Java 8 streams.
		Arrays.asList(i).stream()
				.filter(p -> p%2==0)
				.collect(Collectors.toList()).forEach(System.out::println);
		
		//4. Write a program to find the maximum number in a list of integers using Java 8 streams.
		System.out.println("max val : "+Arrays.asList(i).stream().max(Comparator.comparingInt(Integer::intValue)).get());
		
		//5. Implement a method that takes a list of strings and returns a new list containing only the strings that start with a vowel.
		Arrays.asList(s).stream()
		.filter(p -> p.matches("[aeiouAEIOU].*"))
		.collect(Collectors.toList()).forEach(System.out::println);

		//6. Write a program to remove duplicate elements from a list of integers using Java 8 streams.
		Arrays.asList(i).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().filter(k -> k.getValue()==1).forEach(System.out::println);
		
		//7. Implement a method that takes a list of integers and returns the average of all the numbers.
		Double k = Arrays.asList(i).stream().mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println(k);
		
		//8. Given a list of strings, write a program to concatenate them into a single string using Java 8 streams.
		String single = Arrays.asList(s).stream().collect(Collectors.joining());
		System.out.println(single);
		
		//9. Write a program to find the factorial of a number using Java 8 streams and reduce operation.
		System.out.println(Arrays.asList(i).stream()
				.reduce(1,(a,b)-> a*b).intValue());
		
		//10. Given a list of strings, write a program to sort the strings in alphabetical order using Java 8 streams.
		Arrays.asList(s).stream()
		.sorted()
		//.sorted((a,t) -> t.compareTo(a))
		.collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("---------------------");
		
		 //11. Write a function to check if a given string is a palindrome.
		String singleString = "Pallindrom";
		boolean  kk = Arrays.asList(singleString).stream()
		.filter(m -> new StringBuilder(m).reverse().toString().equals(singleString)).findFirst().isPresent();
		System.out.println("String is Pallindrom : "+kk);	
		
		//12. Write a function to find the first non-repeated character in a string.
		Character ch = singleString.chars().mapToObj(m -> (char)m).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().filter(f -> f.getValue()==1).findFirst().get().getKey();
		System.out.println(ch);
		
		//13.Given two strings, write a function to check if one string is an anagram of the other.
		String str1 = "listen";
        String str2 = "silent";
        System.out.println(str1.chars().sorted().equals(str2.chars().sorted()));
        
       //14. Implement a function to capitalize the first letter of each word in a sentence.
       String sen = "i am a boy";
       String kkr =  Arrays.stream(sen.split(" "))
        .map(m -> m.toString().substring(0, 1).toUpperCase()+m.toString().substring(1)+" ")
        .collect(Collectors.joining());
       System.out.println(kkr);
       
       //15.Given a list of strings, filter out the strings that have length less than 5 characters using streams.
       Arrays.asList(s).stream().collect(Collectors.toMap(Function.identity(),String::length))
       .entrySet().stream()
       .filter(el->el.getValue()>5)
       .collect(Collectors.toList()).forEach(System.out::println);
       
		
	}

}
