package Map;

import java.util.HashMap;
import java.util.Map;

import Collection.Book;

public class LinkedHashMap {

	public static void main(String[] args) {

		//Creating map of Books    
	    Map<Integer,Book> map=new HashMap<Integer,Book>();    
	    //Creating Books    
	    Book b1=new Book(103,"Let us C","Yashwant Kanetkar","BPB",8);    
	    Book b2=new Book(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);    
	    Book b3=new Book(102,"Operating System","Galvin","Wiley",6);    
	    //Adding Books to map   
	    map.put(1,b1);  
	    map.put(2,b2);  
	    map.put(3,b3);  
	      
	    //Traversing map  
	    map.forEach((k,b)-> System.out.println(k+" Details: "+ b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity));
	
		//* Order Preserved----------------------
	}

}
