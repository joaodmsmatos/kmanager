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
 * <code>LoginState</code> provides the login 
 * state variables
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.21.2018
 */
public class LoginState 
{
	/** cancel state */
	private boolean cancel = false;
	
	/** ok state */ 
	private boolean ok = false;
	
	/** register state */
	private boolean register = false;
	
	/**
	 * @return the cancel
	 */
	public boolean isCancel() 
	{
		return cancel;
	}
	
	/**
	 * @param cancel the cancel to set
	 */
	public void setCancel(boolean cancel) 
	{
		this.cancel = cancel;
	}
	
	/**
	 * @return the ok
	 */
	public boolean isOk() 
	{
		return ok;
	}
	
	/**
	 * @param ok the ok to set
	 */
	public void setOk(boolean ok) 
	{
		this.ok = ok;
	}
	
	/**
	 * @return the register
	 */
	public boolean isRegister() 
	{
		return register;
	}
	
	/**
	 * @param register the register to set
	 */
	public void setRegister(boolean register) 
	{
		this.register = register;
	}
}
