package com.mvc.entity.products;

import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class Product {
	
	@NotBlank(message = "請選擇商品分類")
	@NotNull(message = "請選擇商品分類")
	private Group group;//商品分類
	
	@NotBlank(message = "商品名稱不可是空值")
	@Size(min = 3,max = 50,message = "商品名稱必須介於3~50字之間")
	private String name;//商品名稱
	
	@NotBlank(message = "商品價格不可是空值")
	@Range(min = 1,max = 10000,message = "商品價格必須介於1~10000之間")
	private Double price;//商品價格
	
	@NotBlank(message = "商品數量不可是空值")
	@Min(value = 1,message = "商品數量必須大於或等於1")
	private Integer amount;//商品數量
	
	@PastOrPresent(message = "上架日期不可大於今日")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  date;//上架日期

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Product [group=" + group + ", name=" + name + ", price=" + price + ", amount=" + amount + ", date="
				+ date + "]";
	}
	
	
	
}
