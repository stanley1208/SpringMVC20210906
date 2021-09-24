package com.mvc.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mvc.entity.products.Group;
import com.mvc.entity.products.Product;

public interface ProductService {
	//商品分類
	Map<Integer, Group>groups=new LinkedHashMap<>();
	//商品集合(存放目前所有商品的資料的資料庫集合)
	List<Product>products=new ArrayList<>();
	//查詢所有商品資料
	List<Product>query();
	//查詢單筆商品資料
	Product get(String name);
	//新增商品
	boolean save(Product product);
	//修改商品
	boolean update(Product product);
	//刪除商品
	boolean delete(Product name);
	
}
