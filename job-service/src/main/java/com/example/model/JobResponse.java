package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobResponse {
	private String id;
	private String title;
	private String description;
	private Long minSalary;
	private Long maxSalary;
	private String location;
}
