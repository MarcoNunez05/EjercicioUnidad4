package models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthModel 
{

	
	public AuthModel() 
	{
		
	}
	
	public boolean autenticar(String u, String p)
	{
		// Regresamos true para que siempre nos deje ingresar al sistema
		return true;
		
		/*
		String url = AuthModel.class.getResource("/files/usuariosRegistrados.txt").getPath();
		
		try (BufferedReader br = new BufferedReader(new FileReader(url))) 
		{
		    String line;
		    while ((line = br.readLine()) != null) 
		    {
		       String[] arrString = line.split("[,\\s]");
		       
		       if((u.equals(arrString[0]) || u.equals(arrString[2])) && p.equals(arrString[4])) 
				{
					return true;
				}
		    }
			
			return false;
			
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Algo salió mal");
		}
		 
		return false;
		*/
	}
	
	public void register(String n, String b, String p, String c)
	{
		System.out.println( "      Nombre : " + n + "\n" +
							"   Biografía : " + b + "\n" +
							"Preferencias : " + p + "\n" +
							"     Colonia : " + c);
			
	}
	
	public void registrar(String n, String a, String e, String am, String c, String u, String p, String cr) throws IOException
	{
		FileWriter archivo = null;
		PrintWriter escritor = null;
		
		try
		{	
			archivo = new FileWriter("src/files/usuarios.txt", true);
			escritor = new PrintWriter(archivo);
			
			escritor.println(n + "|" + a + "|" + e + "|" + am + "|" + c + "|" + u + "|" + p + "|" + cr);
		}
		catch (Exception ex)
		{
			System.out.println("Error: " + ex.getMessage());
		}
		finally
		{
			archivo.close();
		}
	}

}
