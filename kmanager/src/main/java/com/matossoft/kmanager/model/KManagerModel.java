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
	
	/**
	 * launch the page correspondent to the given name
	 * 
	 * @param name the page name
	 */
	public void lauchPage(String name)
	{
		switch(name)
		{
			case "Preferences":
				dashboardState.setLaunchPreferencesPage(true);
				dashboardState.setLaunchPasswordsPage(false);
				dashboardState.setLaunchNotesPage(false);
				break;
			case "Passwords":
				dashboardState.setLaunchPasswordsPage(true);
				dashboardState.setLaunchPreferencesPage(false);
				dashboardState.setLaunchNotesPage(false);
				break;
			case "Secure Notes":
				dashboardState.setLaunchNotesPage(true);
				dashboardState.setLaunchPreferencesPage(false);
				dashboardState.setLaunchPasswordsPage(false);		
				break;
			default:
				return;
		}
		setChanged();
		notifyObservers(dashboardState);		
	}
}
