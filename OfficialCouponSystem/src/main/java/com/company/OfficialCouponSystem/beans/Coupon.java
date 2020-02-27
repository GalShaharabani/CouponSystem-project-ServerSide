package com.company.OfficialCouponSystem.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import com.company.OfficialCouponSystem.util.Category;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class Coupon {
	private long id;
	private long companyID;
	private Category category;
	private String title;
	private String description;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="IST")
	private Date startDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="IST")
	private Date endDate;
	private int amount;
	private double price;
	private String image;

	public Coupon(long id, long companyID, Category category, String title, String description, Date startDate,
			Date endDate, int amount, double price, String image) {
		super();
		this.id = id;
		this.companyID = companyID;
		this.category = category;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
	}
	
	

	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column
	public long getCompanyID() {
		return companyID;
	}

	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}
	@Column
	//@Enumerated(EnumType.STRING)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	@Column
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Column
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Column
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Column
	public int getAmount() {
		return amount;
	}
	@Column
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Column
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@Column
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", companyID=" + companyID + ", category=" + category + ", title=" + title
				+ ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", amount="
				+ amount + ", price=" + price + ", image=" + image + "]";
	}

	

}
