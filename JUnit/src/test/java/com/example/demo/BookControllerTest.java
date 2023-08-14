package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.Entity.Book;
import com.example.controller.BookController;
import com.example.repository.BookRepository;

@SpringBootTest
public class BookControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private BookRepository bookRepo;
	
	@InjectMocks
	private BookController bookController;
	
	Book record_1 =  new Book(1L,"Atomic Habits","How to Build Better habits","5");
	Book record_2 =  new Book(2L,"Grokking Algorithms","Learn Argorithm in the fun way","6");
	Book record_3 =  new Book(3L,"think fast & slow","How to create good mental model about thinking","9");
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	}
	
	
	@Test
	private void getAllRecord_success() throws Exception{
		List<Book> records = new ArrayList<Book>();
		records.add(record_1);
		records.add(record_2);
		records.add(record_3);
		
		Mockito.when(bookRepo.findAll()).thenReturn(records);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/book")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath("$[2]", is("think fast & slow")));
		/////////////////////////////////////////////////////////////////////////////////////////////
		Boolean actualRes = bookRepo.existsById(3L);
		assertThat(actualRes).isTrue();
	}
	
	@Test
	private void updatebookRecord_success() throws Exception{
		
		Mockito.when(bookRepo.findById(record_1.getId())).thenReturn(java.util.Optional.ofNullable(record_1));
		//Mockito.when(bookRepo.save(updatedRecord)).thenReturn(updatedRecord);
	}
	
	
	@AfterEach
	void tearDown() {
		System.out.println("Tear Down");
		bookRepo.deleteAll();
	}
	

}
