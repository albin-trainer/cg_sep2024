package com.cg.entity;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data// @Setter + @Getter
public class Review {
	@Id
	@GeneratedValue
private int revId;
private String reviewerName;
private String review;
private float ratings;
private LocalDate dateOfReview;
@ManyToOne
@JoinColumn(name="pid")//optional
private Product product;

}
