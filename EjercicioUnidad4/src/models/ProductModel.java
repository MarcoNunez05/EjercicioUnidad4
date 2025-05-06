package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JLabel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProductModel 
{
	public ProductModel()
	{
		
	}
	
	public Vector<Vector<String>> get()
 	{
 		
 		JSONParser jsonParser = new JSONParser();
 		String url = AuthModel.class.getResource("/files/json/products.json").getPath();
         
         try (FileReader reader = new FileReader(url))
         {
             //Read JSON file
             Object obj = jsonParser.parse(reader);
   
             JSONArray productList = (JSONArray) obj;
             System.out.println(productList);
             
             Vector<Vector<String>> listaDatos = new Vector<>();
             for (int i = 0; i < productList.size(); i++) 
             {
				JSONObject jsonObj = (JSONObject)productList.get(i);
				Vector<String> data = new Vector<>();
				
				data.add(jsonObj.get("ID").toString());
				data.add(jsonObj.get("Nombre").toString());
				data.add(jsonObj.get("Precio").toString());
				data.add(jsonObj.get("Stock").toString());
				
				listaDatos.add(data);
             }
               
             return listaDatos;
           
   
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
 
}
