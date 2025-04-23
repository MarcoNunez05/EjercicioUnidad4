package models;

public class AuthModel 
{

	public AuthModel() 
	{
		
	}
	
	public boolean autenticar(String u, String p)
	{
		
		if(u.equals("admin") && p.equals("123456") ) 
		{
			return true;
		}
		else
			return false;
		 
	}
	
	public void register(String n, String b, String p, String c)
	{
		System.out.println( "      Nombre : " + n + "\n" +
							"   Biografía : " + b + "\n" +
							"Preferencias : " + p + "\n" +
							"     Colonia : " + c);
			
	}

}
