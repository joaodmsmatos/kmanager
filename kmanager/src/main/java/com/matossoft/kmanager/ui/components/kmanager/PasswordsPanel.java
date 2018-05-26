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
package com.matossoft.kmanager.ui.components.kmanager;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.matossoft.kmanager.utils.UIConstants;

/**
 * <code>PasswordsPanel</code> extends <code>JPanel</code> and provides
 * the password table view
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.26.2018
 */
public class PasswordsPanel extends JPanel 
{
	/** Generated serial version unique id */
	private static final long serialVersionUID = -1606833825608141300L;
	
	public PasswordsPanel() 
	{
		setOpaque(false);
		initComponents();
	}

	private void initComponents()
	{
		JLabel header = new JLabel("Password Table");
		header.setFont(UIConstants.FONT_BIG);
		header.setForeground(Color.WHITE);
		add(header);
	}
}
