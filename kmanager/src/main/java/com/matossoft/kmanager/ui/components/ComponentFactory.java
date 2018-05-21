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
package com.matossoft.kmanager.ui.components;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.matossoft.kmanager.utils.UIConstants;
import com.matossoft.kmanager.utils.UIHelper;

/**
 * <code>ComponentFactory</code> implements a factory pattern and provides
 * reusable ui components
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.21.2018
 */
public class ComponentFactory 
{
	/**
	 * Component Type enum
	 * 
	 * @author https://github.com/joaodmsmatos/
	 *
	 */
	public enum ComponentType 
	{
		LOGO_PANEL, UNKNOWN
	}

	/**
	 * Private constructor, this prevents this class to be instantiated
	 *
	 */
	private ComponentFactory() {}

	/**
	 * Gets the desired component
	 * 
	 * @param type
	 *            the type of the desired component
	 * @param dim
	 *            the dimensions of the desired component
	 * @return the desired component
	 */
	public static Component getComponent(ComponentType type, Dimension dim) 
	{
		switch (type) 
		{
			case LOGO_PANEL:
				return getKmanagerLogoPanel(dim);
			case UNKNOWN:
			default:
				return null;
		}
	}

	/**
	 * Get the Logo Panel
	 * 
	 * @param dim
	 *            the dimension of the Logo Panel
	 * @return the logo Panel
	 */
	private static Component getKmanagerLogoPanel(Dimension dim) 
	{
		// set attributes
		JPanel kmanagerLogoPanel = new JPanel();
		kmanagerLogoPanel.setBackground(UIConstants.COLOR_TIER1);
		kmanagerLogoPanel.setInheritsPopupMenu(true);
		kmanagerLogoPanel.setMaximumSize(dim);
		kmanagerLogoPanel.setMinimumSize(dim);
		kmanagerLogoPanel.setPreferredSize(dim);
		// set child component
		JLabel kmanagerImageLabel = new JLabel();
		kmanagerImageLabel.setMinimumSize(dim);
		kmanagerImageLabel.setMaximumSize(dim);
		kmanagerImageLabel.setPreferredSize(dim);
		kmanagerImageLabel.setIcon(new ImageIcon(UIHelper.readImage(UIConstants.KMANAGER_LOGO_IMAGE_PATH)));
		kmanagerLogoPanel.add(kmanagerImageLabel);
		return kmanagerLogoPanel;
	}
}
