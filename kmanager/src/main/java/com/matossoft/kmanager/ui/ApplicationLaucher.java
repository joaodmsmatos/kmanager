/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matossoft.kmanager.ui;

import com.matossoft.kmanager.model.Model;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 * ApplicationLauncehr provides the kmanager application entry point
 * 
 * @author joaod
 */
public class ApplicationLaucher 
{
    /** The logger*/
    private static final Logger LOG = Logger.getLogger(ApplicationLaucher.class.getName());
    
    /**
     * Application entry point
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
        SwingUtilities.invokeLater(() -> 
        {
            vc.setVisible(true);
        }); 
    }
}
