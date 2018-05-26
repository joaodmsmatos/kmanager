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
package com.matossoft.kmanager.state;

/**
 * <code>DashboardState</code> provides the dashboard 
 * state variables
 * 
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.21.2018
 */
public class DashboardState 
{
	/** true to view Preferences page*/
	private boolean launchPreferencesPage = false;
	
	/** true to view Passwords page*/
	private boolean launchPasswordsPage = false;
	
	/** true to view Passwords page*/
	private boolean launchNotesPage = false;
	
	/**
	 * @return the launchPreferencesPage
	 */
	public boolean isLaunchPreferencesPage() 
	{
		return launchPreferencesPage;
	}

	/**
	 * @param launchPreferencesPage the launchPreferencesPage to set
	 */
	public void setLaunchPreferencesPage(boolean launchPreferencesPage) 
	{
		this.launchPreferencesPage = launchPreferencesPage;
	}
	
	/**
	 * @return the launchPasswordsPage
	 */
	public boolean isLaunchPasswordsPage() 
	{
		return launchPasswordsPage;
	}

	/**
	 * @param launchPasswordsPage the launchPasswordsPage to set
	 */
	public void setLaunchPasswordsPage(boolean launchPasswordsPage)
	{
		this.launchPasswordsPage = launchPasswordsPage;
	}

	/**
	 * @return the launchNotesPage
	 */
	public boolean isLaunchNotesPage() 
	{
		return launchNotesPage;
	}

	/**
	 * @param launchNotesPage the launchNotesPage to set
	 */
	public void setLaunchNotesPage(boolean launchNotesPage) 
	{
		this.launchNotesPage = launchNotesPage;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "DashboardState [launchPreferencesPage=" + launchPreferencesPage + ", launchPasswordsPage="
				+ launchPasswordsPage + ", launchNotesPage=" + launchNotesPage + "]";
	}
}
