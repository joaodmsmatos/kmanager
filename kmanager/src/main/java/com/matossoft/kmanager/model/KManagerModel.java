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

import com.matossoft.kmanager.state.DashboardState;

/**
 * <code>KManagerModel</code> extends <code>Observable</code>
 * and provides the key manager model
 * TODO: refactor this
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.21.2018
 */
public class KManagerModel extends Observable
{ 
	/** the login state */
	private DashboardState dashboardState;
	
	/**
	 * LoginModel constructor
	 */
	public KManagerModel()
	{
		dashboardState = new DashboardState();
	}
	
	
	public void enableElement(String name, boolean enable)
	{
		switch(name)
		{
			case "Preferences":
				dashboardState.setPreferencesIconEnabled(enable);
				dashboardState.setPreferencesIconChanged(true);
				break;
			case "Passwords":
				dashboardState.setPasswordsIconEnabled(enable);
				dashboardState.setPasswordsIconChanged(true);
				break;
			case "Secure Notes":
				dashboardState.setNotesIconEnabled(enable);
				dashboardState.setNotesIconChanged(true);
				break;
		}	
		setChanged();
		notifyObservers(dashboardState);
	}
	
	public void lauchPage(String name)
	{
		switch(name)
		{
			case "Preferences":
				//dashboardState.setPreferencesIconChanged(true);
				//dashboardState.setPreferencesIconEnabled(true);
				//dashboardState.setPasswordsIconEnabled(false);
				//dashboardState.setNotesIconEnabled(false);
				dashboardState.setLaunchPreferencesPage(true);
				dashboardState.setLaunchPasswordsPage(false);
				dashboardState.setLaunchNotesPage(false);
				break;
			case "Passwords":
				//dashboardState.setPreferencesIconChanged(true);
				//dashboardState.setPasswordsIconEnabled(true);
				//dashboardState.setPreferencesIconEnabled(false);
				//dashboardState.setNotesIconEnabled(false);
				dashboardState.setLaunchPasswordsPage(true);
				dashboardState.setLaunchPreferencesPage(false);
				dashboardState.setLaunchNotesPage(false);
				break;
			case "Secure Notes":
				//dashboardState.setPreferencesIconChanged(true);
				//dashboardState.setNotesIconEnabled(true);
				//dashboardState.setPreferencesIconEnabled(false);
				//dashboardState.setPasswordsIconEnabled(false);
				dashboardState.setLaunchNotesPage(true);
				dashboardState.setLaunchPreferencesPage(false);
				dashboardState.setLaunchPasswordsPage(false);		
				break;
		}
		setChanged();
		notifyObservers(dashboardState);		
	}
}
