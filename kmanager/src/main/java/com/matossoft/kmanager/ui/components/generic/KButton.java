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
package com.matossoft.kmanager.ui.components.generic;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.matossoft.kmanager.utils.UIConstants;
import com.matossoft.kmanager.utils.UIHelper;

/**
 * <code>KButton</code> extends <code>JLabel</code> and provides
 * a custom button
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.26.2018
 */
public class KButton extends JLabel 
{
	/** Generated serial version unique id */
	private static final long serialVersionUID = 6867043580085751928L;
	
	/**
	 * KButton constructor
	 * 
	 * @param name
	 * @param iconPath
	 */
	public KButton(String name)
	{
		// set attributes
		setAttributes(name);
		addListeners();
	}
	
	/**
	 * KButton constructor
	 * 
	 * @param name the button text
	 * @param iconPath the button icon image path
	 */
	public KButton(String name, String iconPath)
	{
		// set attributes
		setAttributes(name);
		
		if(iconPath != null)
		{
			setIcon(new ImageIcon(UIHelper.readImage(iconPath)));
		}
		
		addListeners();
	}
	
	/**
	 * Set button attributes
	 * 
	 * @param name the button text
	 */
	private void setAttributes(String name)
	{
		setText(name);
		setFont(UIConstants.FONT_MEDIUM);
		setForeground(Color.WHITE);
		setHorizontalTextPosition(JLabel.CENTER);
		setVerticalTextPosition(JLabel.BOTTOM);
		setBorder(new EmptyBorder(3, 3, 3, 3));		
	}
	/**
	 * Add mouse listener
	 */
	private void addListeners()
	{
		addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent evt) 
			{
				setBorder(new LineBorder(Color.WHITE, 3, true));
			}

			@Override
			public void mouseExited(MouseEvent evt) 
			{	
				setBorder(new EmptyBorder(3, 3, 3, 3));
			}
			
			@Override
			public void mouseReleased(MouseEvent evt) 
			{
				setBorder(new EmptyBorder(3, 3, 3, 3));
			}
			
		});
	}
}
