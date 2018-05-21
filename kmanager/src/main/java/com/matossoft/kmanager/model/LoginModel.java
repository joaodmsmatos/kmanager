/*
 * Copyright (C) 2018 https://github.com/joaodmsmatos/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.matossoft.kmanager.model;

import java.util.Observable;

import javax.swing.SwingUtilities;

import com.matossoft.kmanager.state.LoginState;
import com.matossoft.kmanager.ui.KmanagerViewController;

/**
 * <code>LoginModel</code> extends <code>Observable</code>
 * and provides the login model
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.21.2018
 */
public class LoginModel extends Observable
{ 
	/** the login state */
	private LoginState state;
	
	/**
	 * LoginModel constructor
	 */
	public LoginModel()
	{
		state = new LoginState();
	}
	
	/**
	 * Cancel Login
	 */
	public void cancelLogin()
	{
		state.setCancel(true);
		setChanged();
		System.exit(0);
	}
	
	/**
	 * Authenticate 
	 */
	public void authenticate(KmanagerViewController kvc)
	{
		state.setOk(true);
		setChanged();
		notifyObservers(state);
		
		// launch key manager application
		SwingUtilities.invokeLater(() -> kvc.setVisible(true));
	}
	
	/**
	 * Register user 
	 */
	public void register()
	{ 
		// TODO: launch registration form
		
		state.setRegister(true);
		setChanged();
		notifyObservers(state);
	}
	
}
