package com.prodbase.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.prodbase.dao.ProductDao;
import com.prodbase.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping(path = "/")
	public String home(Model model) {
		List<Product> products = productDao.getAll();
		model.addAttribute("products", products);
		return "index";
	}

	@RequestMapping(path = "/add-product")
	public String addProduct(Model model) {
		model.addAttribute("title", "ProdBase - Add Product");
		return "add_product_form";
	}

	@RequestMapping(path = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath() + "/");
		return rv;
	}

	@RequestMapping(path = "/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable(name = "productId") int id, HttpServletRequest request) {
		this.productDao.deleteProduct(id);
		RedirectView rv = new RedirectView();
		rv.setUrl(request.getContextPath() + "/");
		return rv;
	}

	@RequestMapping(path = "/update/{productId}")
	public String updateProduct(@PathVariable(name = "productId") int id, Model model) {
		Product product = this.productDao.getProduct(id);
		model.addAttribute("product", product);
		return "update_form";
	}
}
