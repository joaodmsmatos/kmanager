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

import com.matossoft.kmanager.model.KManagerModel;
import com.matossoft.kmanager.model.LoginModel;
import com.matossoft.kmanager.state.DashboardState;
import com.matossoft.kmanager.state.LoginState;
import com.matossoft.kmanager.ui.components.ComponentFactory;
import com.matossoft.kmanager.ui.components.ComponentFactory.ComponentType;
import com.matossoft.kmanager.utils.UIConstants;
import com.matossoft.kmanager.utils.UIHelper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * <code>KmanagerViewController</code> implements <code>Observer</code>
 * interface, providing a view and controller for the Key Manager MVC
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.18.2018
 */
public class KmanagerViewController extends JFrame implements Observer
{
	/** serial version unique id */
	private static final long serialVersionUID = -1089020228511926022L;

	/** The logger */
	private static final Logger LOG = Logger.getLogger(KmanagerViewController.class.getName());

	/** Kmanager frame dimension */
	private static final Dimension KMANAGER_FRAME_DIMENSION = new Dimension(1450, 900);

	/** Logo panel dimension */
	private static final Dimension LOGO_PANEL_DIMENSION = new Dimension(400, 150);

	/** Filler panel dimension */
	private static final Dimension FILLER_PANEL_DIMENSION = new Dimension(400, 75);

	/** Dashboard panel dimension */
	private static final Dimension LEFT_ARGUMENT_PANEL_DIMENSION = new Dimension(400, 900);

	/** Argument panel dimension */
	private static final Dimension RIGHT_ARGUMENT_PANEL_DIMENSION = new Dimension(1050, 900);
	
	/** The kmanager model  */
	private transient KManagerModel kmanagerModel;
	
	/** Dashboard components*/
	private JLabel preferencesLabel;
	private JLabel passwordsLabel;
	private JLabel notesLabel;
	
	/**
	 * Creates new form ui
	 */
	public KmanagerViewController(KManagerModel kmanagerModel) 
	{
		this.kmanagerModel = kmanagerModel;
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
		createDashboardPanel();
		createArgumentPanel();
		pack();

		// center frame
		setLocationRelativeTo(null);
	}

	/**
	 * Create left argument panel, container for dashboard options
	 * 
	 */
	private void createDashboardPanel()
	{
		// set attributes
		JPanel leftArgumentPanel = new JPanel();
		leftArgumentPanel.setBackground(UIConstants.COLOR_TIER1);
		leftArgumentPanel.setForeground(Color.WHITE);
		leftArgumentPanel.setPreferredSize(LEFT_ARGUMENT_PANEL_DIMENSION);
		leftArgumentPanel.setMinimumSize(LEFT_ARGUMENT_PANEL_DIMENSION);
		leftArgumentPanel.setMaximumSize(LEFT_ARGUMENT_PANEL_DIMENSION);
		leftArgumentPanel.setLayout(new BoxLayout(leftArgumentPanel, BoxLayout.Y_AXIS));

		// create child components
		// add logo panel to left argument panel
		leftArgumentPanel.add(ComponentFactory.getComponent(ComponentType.LOGO_PANEL, LOGO_PANEL_DIMENSION));

		// add filler to left argument panel
		JPanel filler = (JPanel) ComponentFactory.getComponent(ComponentType.FILLER_PANEL, FILLER_PANEL_DIMENSION);

		leftArgumentPanel.add(filler);

		// add dashboard panel
		JPanel dashboardPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
		dashboardPanel.setOpaque(false);

		// add preferences component to dashboard
		preferencesLabel = createDashboardLabel("Preferences", UIConstants.PREFERENCES_ICON_PATH, dashboardPanel, new JPanel());
		dashboardPanel.add(preferencesLabel);
		
		// add password component to dashboard
		passwordsLabel = createDashboardLabel("Passwords", UIConstants.PASSWORDS_ICON_PATH, dashboardPanel, new JPanel());
		dashboardPanel.add(passwordsLabel);
		
		// add notes component to dashboard
		notesLabel = createDashboardLabel("Secure Notes", UIConstants.ENCRYPTED_FILES_ICON_PATH, dashboardPanel, new JPanel());
		dashboardPanel.add(notesLabel);
		
		// add dashboard panel to left argument panel
		leftArgumentPanel.add(dashboardPanel);

		// create info panel
		JPanel infoPanel = new JPanel(new BorderLayout());
		JLabel infoLabel = new JLabel();
		infoLabel.setText("About");
		infoLabel.setFont(UIConstants.FONT_SMALL);
		infoLabel.setForeground(Color.WHITE);
		infoLabel.setHorizontalTextPosition(JLabel.RIGHT);
		infoLabel.setVerticalTextPosition(JLabel.CENTER);
		infoLabel.setIcon(new ImageIcon(UIHelper.readImage(UIConstants.INFO_ICON_PATH)));
		infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		infoPanel.setOpaque(false);
		infoPanel.add(infoLabel, BorderLayout.PAGE_END);

		// add info panel panel to left argument panel
		leftArgumentPanel.add(infoPanel);

		// finally add left argument panel to the content pane
		getContentPane().add(leftArgumentPanel);
	}

	/**
	 * Create right argument panel, moreover here will reside the table list with
	 * the application keys, the encrypted notes or the preferences page
	 * 
	 */
	private void createArgumentPanel() 
	{
		JPanel rightArgumentPanel = new JPanel();
		rightArgumentPanel.setBackground(UIConstants.COLOR_TIER2);
		rightArgumentPanel.setForeground(Color.WHITE);
		rightArgumentPanel.setPreferredSize(RIGHT_ARGUMENT_PANEL_DIMENSION);
		rightArgumentPanel.setMinimumSize(RIGHT_ARGUMENT_PANEL_DIMENSION);
		rightArgumentPanel.setMaximumSize(RIGHT_ARGUMENT_PANEL_DIMENSION);
		getContentPane().add(rightArgumentPanel);
	}

	private JLabel createDashboardLabel(String name, String IconPath, JPanel container, JPanel targetContainer)
	{
		// set attributes
		JLabel label = new JLabel();
		label.setText(name);
		label.setFont(UIConstants.FONT_MEDIUM);
		label.setForeground(Color.WHITE);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.BOTTOM);
		label.setIcon(new ImageIcon(UIHelper.readImage(IconPath)));
		label.setBorder(new EmptyBorder(3, 3, 3, 3));

		// set listeners
		label.addMouseListener(new MouseAdapter() 
		{
			/*
			@Override
			public void mouseEntered(MouseEvent evt) 
			{
				//kmanagerModel.enableElement(name, true);
				label.setBorder(new LineBorder(Color.WHITE, 3, true));
			}

			@Override
			public void mouseExited(MouseEvent evt) 
			{
				//kmanagerModel.enableElement(name, false);
				label.setBorder(new EmptyBorder(3, 3, 3, 3));
			}
			*/
			@Override
			public void mouseReleased(MouseEvent evt) 
			{
				kmanagerModel.lauchPage(name);
			}
		});
		return label;
	}

	/**
	 * Creates the preferences panel
	 * 
	 * @param ParentContainer
	 *            the parent container
	 * @param container
	 *            the container
	 */
	private void createPreferencesPanel(JPanel ParentContainer, JPanel container) 
	{
		// TODO
	}

	/**
	 * Creates the passwords panel
	 * 
	 * @param ParentContainer
	 *            the parent container
	 * @param container
	 *            the container
	 */
	private void createPasswordsPanel(JPanel ParentContainer, JPanel container) 
	{
		// TODO
	}

	/**
	 * Creates the encrypted notes panel
	 * 
	 * @param ParentContainer
	 *            the parent container
	 * @param container
	 *            the container
	 */
	private void createNotesPanel(JPanel ParentContainer, JPanel container) 
	{
		// TODO
	}

	// TODO refactor this, not a nice approach...
	@Override
	public void update(Observable o, Object stateObj) 
	{
		if(!(stateObj instanceof DashboardState))
		{
			return;
		}
		
		DashboardState dashboardState = (DashboardState) stateObj;
		
		if(dashboardState.isLaunchPreferencesPage())
		{
			preferencesLabel.setBorder(new LineBorder(Color.WHITE, 3, true));
			notesLabel.setBorder(new EmptyBorder(3, 3, 3, 3));
			passwordsLabel.setBorder(new EmptyBorder(3, 3, 3, 3));
			createPreferencesPanel(null, null);
		}
		else if(dashboardState.isLaunchPasswordsPage())
		{
			passwordsLabel.setBorder(new LineBorder(Color.WHITE, 3, true));
			notesLabel.setBorder(new EmptyBorder(3, 3, 3, 3));
			preferencesLabel.setBorder(new EmptyBorder(3, 3, 3, 3));
			createPasswordsPanel(null, null);
		}
		else if(dashboardState.isLaunchNotesPage())
		{
			notesLabel.setBorder(new LineBorder(Color.WHITE, 3, true));
			passwordsLabel.setBorder(new EmptyBorder(3, 3, 3, 3));
			preferencesLabel.setBorder(new EmptyBorder(3, 3, 3, 3));
			createNotesPanel(null, null);
		}
		
/*
		else if(dashboardState.isPreferencesIconChanged() && dashboardState.isPreferencesIconEnabled() && !dashboardState.isLaunchPreferencesPage())
		{
			preferencesLabel.setBorder(new LineBorder(Color.WHITE, 3, true));
		}
		else if(dashboardState.isPreferencesIconChanged() && !dashboardState.isPreferencesIconEnabled() && !dashboardState.isLaunchPreferencesPage())
		{
			preferencesLabel.setBorder(new EmptyBorder(3, 3, 3, 3));
		}
		else if(dashboardState.isPasswordsIconChanged() && dashboardState.isPasswordsIconEnabled() && !dashboardState.isLaunchPasswordsPage())
		{
			passwordsLabel.setBorder(new LineBorder(Color.WHITE, 3, true));
		}
		else if(dashboardState.isPasswordsIconChanged() && !dashboardState.isPasswordsIconEnabled() && !dashboardState.isLaunchPasswordsPage())
		{
			passwordsLabel.setBorder(new EmptyBorder(3, 3, 3, 3));
		}
		else if(dashboardState.isNotesIconChanged() && dashboardState.isNotesIconEnabled() && !dashboardState.isLaunchNotesPage())
		{
			notesLabel.setBorder(new LineBorder(Color.WHITE, 3, true));
		}
		else if(dashboardState.isNotesIconChanged() && !dashboardState.isNotesIconEnabled() && !dashboardState.isLaunchNotesPage())
		{
			notesLabel.setBorder(new EmptyBorder(3, 3, 3, 3));
		}

		//reset changed flags
		dashboardState.setPreferencesIconChanged(false);
		dashboardState.setPasswordsIconChanged(false);
		dashboardState.setNotesIconChanged(false);
*/		
		// TEST....
		System.out.println(dashboardState.toString());
	}
}
