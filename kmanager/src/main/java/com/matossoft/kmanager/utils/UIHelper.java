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
package com.matossoft.kmanager.utils;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * <code>UIHelper</code> provides utility methods 
 * to be used in the kmanager graphical user interface
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.18.2018
 */
public class UIHelper 
{
    /** the logger*/
    private static final Logger LOG = Logger.getLogger(UIConstants.class.getName());
    
    /** 
     * private constructor
     */ 
    private UIHelper() {}

    /**
     * utility method to read an Image by path
     * 
     * @param path the path
     * @return the image corresponding to the icon
     */
    public static Image readImage(String path)
    {
        Image i = null;
        
        try {
            i = ImageIO.read(ClassLoader.getSystemResource(path));    
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return i;
    }
}


