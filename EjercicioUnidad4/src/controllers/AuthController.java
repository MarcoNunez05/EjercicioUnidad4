package controllers;
import views.AuthView;

public class AuthController {

	public AuthView v;
	
	int n;
	
	public AuthController() 
	{
		v = new AuthView();
	}
	
	public void login()
	{
		v.login();
	}

}
