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
package com.matossoft.kmanager.ui;

import com.matossoft.kmanager.state.LoginState;
import com.matossoft.kmanager.ui.components.ComponentFactory;
import com.matossoft.kmanager.ui.components.ComponentFactory.ComponentType;
import com.matossoft.kmanager.utils.UIConstants;
import com.matossoft.kmanager.utils.UIHelper;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <code>ViewController</code> implements <code>Observer</code> interface,
 * providing a view and controller for the MVC
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.18.2018
 */
public class KmanagerViewController extends JFrame implements Observer
{	
	/** serial version unique id */
	private static final long serialVersionUID = -1089020228511926022L;

	/** The logger*/
    private static final Logger LOG = Logger.getLogger(KmanagerViewController.class.getName());
    
	/** Kmanager frame dimension */ 
	private static final Dimension KMANAGER_FRAME_DIMENSION = new Dimension(1450, 900);
	
	/** Dashboard panel dimension */ 	
	private static final Dimension KMANAGER_IMAGE_DIMENSION = new Dimension(400, 150);
	
	/** Argument panel dimension */
	private static final Dimension LEFT_ARGUMENT_PANEL_DIMENSION = new Dimension(400, 900);
	
	/** Argument panel dimension */
	private static final Dimension RIGHT_ARGUMENT_PANEL_DIMENSION = new Dimension(1050, 900);
	
    
    /**
     * Creates new form ui
     */
    public KmanagerViewController() 
    {
        initComponents(); 
    }

    /**
     * Initialize components
     */
    private void initComponents()
    {
    	// set attributes
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(UIConstants.FONT_MEDIUM);
        setBackground(UIConstants.COLOR_TIER1);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
        setResizable(false);
        setIconImage(UIHelper.readImage(UIConstants.KMANAGER_ICON_PATH));
        setAlwaysOnTop(true);
        
        // create child components
        createLeftArgumentPanel();
        createRightArgumentPanel();
        pack();   
        
        //center frame
        setLocationRelativeTo(null);
    }
    
    /**
     * Create left argument panel, container for 
     * dashboard options
     * 
     */
    private void createLeftArgumentPanel()
    {
    	JPanel leftArgumentPanel = new JPanel();
    	leftArgumentPanel.setBackground(UIConstants.COLOR_TIER1);
    	leftArgumentPanel.setForeground(Color.WHITE);
    	leftArgumentPanel.setPreferredSize(LEFT_ARGUMENT_PANEL_DIMENSION);
    	leftArgumentPanel.setMinimumSize(LEFT_ARGUMENT_PANEL_DIMENSION);
    	leftArgumentPanel.setMaximumSize(LEFT_ARGUMENT_PANEL_DIMENSION);
    	leftArgumentPanel.setLayout(new BoxLayout(leftArgumentPanel,BoxLayout.Y_AXIS));
    	leftArgumentPanel.add(ComponentFactory.getComponent(ComponentType.LOGO_PANEL, KMANAGER_IMAGE_DIMENSION));
    	
    	getContentPane().add(leftArgumentPanel);
    }
    
    /**
     * Create right argument panel, moreover 
     * here will reside the table list with 
     * the application keys, or the encrypted notes
     * 
     */
    private void createRightArgumentPanel()
    {
    	JPanel rightArgumentPanel = new JPanel();
    	rightArgumentPanel.setBackground(UIConstants.COLOR_TIER2);
    	rightArgumentPanel.setForeground(Color.WHITE);
    	rightArgumentPanel.setPreferredSize(RIGHT_ARGUMENT_PANEL_DIMENSION);
    	rightArgumentPanel.setMinimumSize(RIGHT_ARGUMENT_PANEL_DIMENSION);
    	rightArgumentPanel.setMaximumSize(RIGHT_ARGUMENT_PANEL_DIMENSION);
    	getContentPane().add(rightArgumentPanel);
    }

    @Override
    public void update(Observable o, Object stateObj) 
    {
		LoginState state = (LoginState) stateObj; 
		
    }
}
