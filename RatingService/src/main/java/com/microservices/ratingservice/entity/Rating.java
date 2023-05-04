package com.microservices.ratingservice.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {
	
	@Id
	private String ratingId;
	private String hotelId;
	private String userId;
	private String feedback;
	private int rating;
	
	@Transient
	private Hotel hotel;
 	
}
