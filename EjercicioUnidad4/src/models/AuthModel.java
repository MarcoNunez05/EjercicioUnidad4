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

}
