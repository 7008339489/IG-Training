package java8.code.practice;

import java.util.stream.IntStream;

public class RandomNumber {

	public static void main(String[] args) {

		//java.util.stream.IntStream.rangeClosed(1, 100).sum();
		//System.out.println(
				System.out.println(IntStream.range(1, 100).sum());
				System.out.println(IntStream.range(0, 100).reduce(0,(a,b)->a+b));
				//IntStream.rangeClosed(1, 100).sum());
				
				IntStream.range(0,100).reduce(0,(a,b) -> a+b);
				IntStream.range(0,100).reduce(Integer::sum);
		
				System.out.println(IntStream.rangeClosed(1, 100).filter(p -> p%2 == 0).sum());
  	}

}
