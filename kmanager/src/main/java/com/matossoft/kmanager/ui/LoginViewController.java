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

import com.matossoft.kmanager.model.LoginModel;
import com.matossoft.kmanager.state.LoginState;
import com.matossoft.kmanager.ui.components.ComponentFactory.ComponentType;
import com.matossoft.kmanager.ui.components.generic.KButton;
import com.matossoft.kmanager.ui.components.ComponentFactory;
import com.matossoft.kmanager.utils.UIConstants;
import com.matossoft.kmanager.utils.UIHelper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;

/**
 * <code>LoginViewController</code> implements <code>Observer</code> interface,
 * providing a view and controller for the Login MVC
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.18.2018
 */
public class LoginViewController extends JFrame implements Observer
{
	/** Serial version unique id*/
	private static final long serialVersionUID = 8364713166207457306L;
	
	/** Login frame dimension */ 
	private static final Dimension LOGIN_FRAME_DIMENSION = new Dimension(525, 450);
	
	/** Logo panel dimension */ 	
	private static final Dimension KMANAGER_IMAGE_DIMENSION = new Dimension(525, 150);
	
	/** Argument panel dimension */
	private static final Dimension ARGUMENT_PANEL_DIMENSION = new Dimension(525, 200);
	
	/** Confirm panel dimension*/
	private static final Dimension CONFIRM_PANEL_DIMENSION = new Dimension(525, 100);
	
	/** The login model */
	private transient LoginModel loginModel;
	
	/** The KeyManager View Controller */
	private KmanagerViewController kvc;
	
	/**
     * LoginViewController constructor
     */
    public LoginViewController(LoginModel loginModel, KmanagerViewController kvc)
    {
    	this.loginModel = loginModel;
    	this.kvc = kvc;
    	
        initComponents();
    }

    /**
     * Initialize components
     */
    private void initComponents() 
    {
    	// set attributes
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(LOGIN_FRAME_DIMENSION);
        setMinimumSize(LOGIN_FRAME_DIMENSION);
        setPreferredSize(LOGIN_FRAME_DIMENSION);
        setIconImage(UIHelper.readImage(UIConstants.KMANAGER_ICON_PATH));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(UIConstants.COLOR_TIER1);
        setResizable(false);
        
        // create child components
        createLogopanel();
        createArgumentPanel();
        createConfirmPanel();
        pack();
        
        //center frame
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
    }
        
    /**
     * Create logo panel ui components
     */
    private void createLogopanel()
    {
    	JPanel kmanagerLogoPanel = (JPanel) ComponentFactory.
    			getComponent(ComponentType.LOGO_PANEL, KMANAGER_IMAGE_DIMENSION,null,null);
        
    	// add logo panel to content pane
        getContentPane().add(kmanagerLogoPanel);
    }
    
    /**
     * Create argument panel ui components
     */
    private void createArgumentPanel()
    {
    	// set attributes
        JPanel argumentPanel = new JPanel();
        argumentPanel.setBackground(UIConstants.COLOR_TIER2);
        argumentPanel.setMaximumSize(ARGUMENT_PANEL_DIMENSION);
        argumentPanel.setMinimumSize(ARGUMENT_PANEL_DIMENSION);
        argumentPanel.setPreferredSize(ARGUMENT_PANEL_DIMENSION);
        argumentPanel.setRequestFocusEnabled(false);
        argumentPanel.setLayout(new GridBagLayout());

        //set child arguments
        JLabel loginLabel = new JLabel();
        loginLabel.setFont(UIConstants.FONT_MEDIUM);
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setText("login");
        JPasswordField loginTextField = new JPasswordField(12);
        loginTextField.setEchoChar('*');
        loginTextField.setBackground(UIConstants.COLOR_TIER1);
        JLabel mpasswordLabel = new JLabel();
        mpasswordLabel.setFont(UIConstants.FONT_MEDIUM);
        mpasswordLabel.setForeground(Color.WHITE);
        mpasswordLabel.setText("master password");        
        JPasswordField mpasswordTextField = new JPasswordField(12);
        mpasswordTextField.setEchoChar('*');
        mpasswordTextField.setBackground(UIConstants.COLOR_TIER1);

        // add childs
        GridBagConstraints constrains = new GridBagConstraints();
		constrains.insets = new Insets(15, 15, 15, 15);
		constrains.gridx = 0;
		constrains.gridy = 0;
		argumentPanel.add(loginLabel, constrains);
		constrains.gridx = 1;
		constrains.gridy = 0;
		constrains.fill = GridBagConstraints.HORIZONTAL;
		argumentPanel.add(loginTextField, constrains);
		constrains.gridx = 0;
		constrains.gridy = 1;
		argumentPanel.add(mpasswordLabel, constrains);
		constrains.gridx = 1;
		constrains.gridy = 1;
		constrains.fill = GridBagConstraints.HORIZONTAL;
		argumentPanel.add(mpasswordTextField, constrains);
		
		// add argument panel to content pane
		getContentPane().add(argumentPanel);
    }
    
    /**
     * Create confirm panel ui components
     */
    private void createConfirmPanel()
    {       
    	// set attributes
    	JPanel confirmPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	confirmPanel.setBackground(UIConstants.COLOR_TIER2);
    	confirmPanel.setPreferredSize(CONFIRM_PANEL_DIMENSION);
    	confirmPanel.setMaximumSize(CONFIRM_PANEL_DIMENSION);
    	confirmPanel.setMinimumSize(CONFIRM_PANEL_DIMENSION);
    	
    	//set child arguments
    	KButton okButton = (KButton) ComponentFactory.getComponent(ComponentType.BUTTON,null,"OK", null);
    	okButton.addMouseListener(new MouseAdapter() 
        {
        	@Override
            public void mouseReleased(MouseEvent evt) 
        	{
        		loginModel.authenticate(kvc);
            }
        }); 
        
    	KButton cancelButton = (KButton) ComponentFactory.getComponent(ComponentType.BUTTON,null,"Cancel", null);
    	cancelButton.addMouseListener(new MouseAdapter() 
        {
        	@Override
            public void mouseReleased(MouseEvent evt) 
        	{
        		loginModel.cancelLogin();
            }
        });      
        
    	KButton notRegisteredButton = (KButton) ComponentFactory.getComponent(ComponentType.BUTTON,null,"Not registered? ", null);
    	notRegisteredButton.addMouseListener(new MouseAdapter() 
        {
        	@Override
            public void mouseReleased(MouseEvent evt) 
        	{
        		loginModel.register();
            }
        }); 
    	
        // add childs
    	confirmPanel.add(okButton);
    	confirmPanel.add(cancelButton);
    	confirmPanel.add(notRegisteredButton);
    	
    	// add argument panel to content pane
    	getContentPane().add(confirmPanel);
    }

	@Override
	public void update(Observable arg0, Object stateObj) 
	{
		LoginState state = (LoginState) stateObj; 
		
		if(state.isOk())
		{
			dispose();
		}
		if(state.isRegister())
		{
			setVisible(false);
		}
				
		// restore state
		state.setOk(false);
		state.setRegister(false);
	}
}
