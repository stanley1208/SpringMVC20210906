package com.mvc.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



import com.mvc.entity.products.Group;
import com.mvc.entity.products.Level;
import com.mvc.entity.products.Product;
import com.mvc.entity.products.Size;

public interface ProductService {
	//�ӫ~����
	Map<Integer, Group>groups=new LinkedHashMap<>();
	//�ؤo���X
	Map<Integer, Size>sizes=new LinkedHashMap<>();
	//�ŧO���X
	Map<Integer, Level>levels=new LinkedHashMap<>();
		
	//�ӫ~���X(�s��ثe�Ҧ��ӫ~����ƪ���Ʈw���X)
	List<Product>products=new ArrayList<>();
	//�d�ߩҦ��ӫ~���
	List<Product>query();
	//�d�߳浧�ӫ~���
	Product get(String name);
	//�s�W�ӫ~
	boolean save(Product product);
	//�ק�ӫ~
	boolean update(Product product);
	//�R���ӫ~
	boolean delete(String name);
	
}
