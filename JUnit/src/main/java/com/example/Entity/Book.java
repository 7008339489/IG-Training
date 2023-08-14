package com.example.Entity;

import javax.persistence.*;

import com.sun.istack.NotNull;

import lombok.*;


@Data
@Entity
@Table(name = "book_record")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String name;

	@NotNull
	private String summary;
	
	private String rating;
	
	

	public Book() {
		super();
	}

	public Book(Long id, String name, String summary, String rating) {
		super();
		this.id = id;
		this.name = name;
		this.summary = summary;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", summary=" + summary + ", rating=" + rating + "]";
	}
	
	
	
}
