package controllers;

import java.util.ArrayList;

import models.User;
import models.UserModel;
import views.UserView;

public class UserController 
{
	private UserView vista;
	
	public UserController() 
	{
		vista = new UserView();
	}

	public void showUsers()
	{
		UserModel um = new UserModel();
		ArrayList<User> data = um.get();
	
		vista.showAllUsers(data);
	}
	
	public ArrayList<User> actualizar()
	{
		UserModel um = new UserModel();
		return um.get();
	}
}
