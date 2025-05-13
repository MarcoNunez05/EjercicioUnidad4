package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JLabel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProductModel 
{
	int id;
	
	public ProductModel()
	{
		
	}
	
	public JSONArray getProductList()
	{
		JSONParser jsonParser = new JSONParser();
 		String url = AuthModel.class.getResource("/files/json/products.json").getPath();
         
         try (FileReader reader = new FileReader(url))
         {
             //Read JSON file
             Object obj = jsonParser.parse(reader);
   
             return (JSONArray) obj;
         }
         
         catch (FileNotFoundException e) 
         {
             e.printStackTrace();
         } 
         catch (IOException e) 
         {
             e.printStackTrace();
         } 
         catch (ParseException e) 
         {
             e.printStackTrace();
         }
         
         return null;
	}
	
	public Vector<Vector<String>> get()
 	{
		
		JSONArray productList = getProductList();
        System.out.println(productList);
             
        Vector<Vector<String>> listaDatos = new Vector<>();
        for (int i = 0; i < productList.size(); i++) 
        {
        	JSONObject jsonObj = (JSONObject)productList.get(i);
			Vector<String> data = new Vector<>();
				
			data.add(jsonObj.get("ID").toString());
			data.add(jsonObj.get("Nombre").toString());
			data.add(jsonObj.get("Descripcion").toString());
			data.add(jsonObj.get("Precio").toString());
			data.add(jsonObj.get("Stock").toString());
				
			listaDatos.add(data);
        }
               
        return listaDatos;		
 	}
	
	public int getID()
	{
		int id = 1;
		JSONArray productList = getProductList();
		
		for (int i = 0; i < productList.size(); i++)
		{
			JSONObject jsonObj = (JSONObject)productList.get(i);
			if (Integer.parseInt(jsonObj.get("ID").toString()) != id)
			{
				return id;
			}
			else
				id++;
		}
		
		return id;
	}
 
	
	public boolean addProduct(int id, String n, String d, String p, String s)
	{
		
		JSONArray productList = getProductList();
		JSONObject jsonObject = new JSONObject();
		
		String url = AuthModel.class.getResource("/files/json/products.json").getPath();
		
		
		jsonObject.put("ID", id);
		jsonObject.put("Nombre", n);
		jsonObject.put("Descripcion", d);
		jsonObject.put("Precio", p);
		jsonObject.put("Stock", s);
		
		productList.add(jsonObject);
		
		try (FileWriter file = new FileWriter(url)) {
            file.write(productList.toString()); // Use toString(2) for pretty printing
            file.flush();
            file.close();
            System.out.println("JSON array written to file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return false;
	}
	
	public void remover(String d)
	{
		
		JSONArray productList = getProductList();
		
		String url = AuthModel.class.getResource("/files/json/products.json").getPath();
        
		for (int i = 0; i < productList.size(); i++) 
		{
			JSONObject jsonObj = (JSONObject)productList.get(i);
			if (jsonObj.get("ID").toString().equals(d))
			{
				productList.remove(i);
			}
		} 
         
        System.out.println(productList); 
         
         // Write the JSON array to a file
         try (FileWriter file = new FileWriter(url)) {
             file.write(productList.toString()); // Use toString(2) for pretty printing
             file.flush();
             file.close();
             System.out.println("JSON array written to file successfully!");
         } catch (IOException e) {
             e.printStackTrace();
         }
         
	}
	
}
