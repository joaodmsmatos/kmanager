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
 * TODO: refactor this class
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.21.2018
 */
public class DashboardState 
{
	/** true to view Preferences page*/
	private boolean launchPreferencesPage = false;
	
	/** status of the preferences icon */ 
	private boolean preferencesIconChanged = false;
	
	/** enabled status of the preferences icon */ 
	private boolean preferencesIconEnabled = false;
	
	/** true to view Passwords page*/
	private boolean launchPasswordsPage = false;
	
	/** status of the passwords icon */ 
	private boolean passwordsIconChanged = false;
	
	/** enabled status of the passwords icon */ 
	private boolean passwordsIconEnabled = false;
	
	/** true to view Passwords page*/
	private boolean launchNotesPage = false;
	
	/** status of the passwords icon */ 
	private boolean notesIconChanged = false;
	
	/** enabled status of the notes icon */ 
	private boolean notesIconEnabled = false;

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
	 * @return the preferencesIconChanged
	 */
	public boolean isPreferencesIconChanged()
	{
		return preferencesIconChanged;
	}

	/**
	 * @param preferencesIconChanged the preferencesIconChanged to set
	 */
	public void setPreferencesIconChanged(boolean preferencesIconChanged) 
	{
		this.preferencesIconChanged = preferencesIconChanged;
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
	 * @return the passwordsIconChanged
	 */
	public boolean isPasswordsIconChanged() 
	{
		return passwordsIconChanged;
	}

	/**
	 * @param passwordsIconChanged the passwordsIconChanged to set
	 */
	public void setPasswordsIconChanged(boolean passwordsIconChanged)
	{
		this.passwordsIconChanged = passwordsIconChanged;
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

	/**
	 * @return the notesIconChanged
	 */
	public boolean isNotesIconChanged() 
	{
		return notesIconChanged;
	}

	/**
	 * @param notesIconChanged the notesIconChanged to set
	 */
	public void setNotesIconChanged(boolean notesIconChanged) 
	{
		this.notesIconChanged = notesIconChanged;
	}

	/**
	 * @return the preferencesIconEnabled
	 */
	public boolean isPreferencesIconEnabled() {
		return preferencesIconEnabled;
	}

	/**
	 * @param preferencesIconEnabled the preferencesIconEnabled to set
	 */
	public void setPreferencesIconEnabled(boolean preferencesIconEnabled) {
		this.preferencesIconEnabled = preferencesIconEnabled;
	}

	/**
	 * @return the passwordsIconEnabled
	 */
	public boolean isPasswordsIconEnabled()
	{
		return passwordsIconEnabled;
	}

	/**
	 * @param passwordsIconEnabled the passwordsIconEnabled to set
	 */
	public void setPasswordsIconEnabled(boolean passwordsIconEnabled)
	{
		this.passwordsIconEnabled = passwordsIconEnabled;
	}

	/**
	 * @return the notesIconEnabled
	 */
	public boolean isNotesIconEnabled() {
		return notesIconEnabled;
	}

	/**
	 * @param notesIconEnabled the notesIconEnabled to set
	 */
	public void setNotesIconEnabled(boolean notesIconEnabled) 
	{
		this.notesIconEnabled = notesIconEnabled;
	}

	@Override
	public String toString() 
	{
		return "DashboardState [launchPreferencesPage=" + launchPreferencesPage + ", preferencesIconChanged="
				+ preferencesIconChanged + ", preferencesIconEnabled=" + preferencesIconEnabled
				+ ", launchPasswordsPage=" + launchPasswordsPage + ", passwordsIconChanged=" + passwordsIconChanged
				+ ", passwordsIconEnabled=" + passwordsIconEnabled + ", launchNotesPage=" + launchNotesPage
				+ ", notesIconChanged=" + notesIconChanged + ", notesIconEnabled=" + notesIconEnabled + "]";
	}
}
