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

import com.matossoft.kmanager.model.Model;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;


/**
 * <code>ApplicationLaucher</code> provides the kmanager application entry point,
 * Key manager application is implemented using the Model View Controller
 * and Observer design patterns
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.18.2018
 */
public class ApplicationLaucher 
{
    /** The logger*/
    private static final Logger LOG = Logger.getLogger(ApplicationLaucher.class.getName());
    
    /**
     * kmanager application entry point
     * 
     * @param args the application arguments 
     */
    public static void main(String[] args)
    {           
        // create ui frame
        final ViewController vc = new ViewController();
     
        //create model   
        Model m = new Model();
        
        //add observer
        m.addObserver(vc);
        
        //launch application
        SwingUtilities.invokeLater(() -> vc.setVisible(true)); 
    }
}
