package com.example.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	private String id;
	private String name;
	private String description;
}
