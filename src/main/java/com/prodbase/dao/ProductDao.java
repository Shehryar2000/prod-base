package com.prodbase.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.prodbase.model.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	// Addition of New product
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}

	// Get All Products
	public List<Product> getAll() {

		List<Product> prodList = null;
		try {

			prodList = this.hibernateTemplate.loadAll(Product.class);

		} catch (Exception e) {

		}

		return prodList;
	}

	// Get Single Product
	public Product getProduct(int id) {
		Product prod = this.hibernateTemplate.get(Product.class, id);
		return prod;
	}

	// Delete Product
	@Transactional
	public void deleteProduct(int id) {
		Product prod = this.hibernateTemplate.load(Product.class, id);
		this.hibernateTemplate.delete(prod);
	}

	// Update Product
	@Transactional
	public void updateProduct(Product prod) {
		this.hibernateTemplate.update(prod);
	}
}
