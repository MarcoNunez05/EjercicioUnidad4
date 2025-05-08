package controllers;

import views.ProductView;

import java.util.Vector;

import org.json.simple.JSONArray;

import models.ProductModel;

public class ProductController 
{
	public ProductView view;
	public ProductModel model;
	
	public ProductController()
	{
		view = new ProductView();
	}
	
	public void productos()
	{
		model = new ProductModel();
		Vector<Vector<String>> data = model.get();

		view.product(data);
	}
	
	public Vector<Vector<String>> actualizar()
	{
		model = new ProductModel();
		return model.get();
	}
	
	public void addView()
	{
		view.addProduct();
	}
	
	public void add(String n, String d, String p, String s)
	{
		model = new ProductModel();
		model.addProduct(model.getID(),n, d, p, s);
		Vector<Vector<String>> data = model.get();
		
		view.product(data);
	}
}
