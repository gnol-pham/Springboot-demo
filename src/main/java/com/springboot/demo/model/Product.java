package com.springboot.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.jpa.repository.Query;

@Entity
@Table(
	uniqueConstraints={
		@UniqueConstraint(columnNames={"name"})
	}
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
	@Id @GeneratedValue
	private Long id;

	private String name;

	private int time;

	private Double price;

	private String url;
}
