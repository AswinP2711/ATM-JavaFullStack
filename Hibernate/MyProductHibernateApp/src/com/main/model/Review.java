package com.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(nullable=false)
	private int rating;
	@Column(nullable=false)
	private String review_text;
	@ManyToOne
	private Product product;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int id, int rating, String review_text, Product product) {
		super();
		this.id = id;
		this.rating = rating;
		this.review_text = review_text;
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview_text() {
		return review_text;
	}
	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", review_text=" + review_text + ", product=" + product
				+ "]";
	}
	
	
}
