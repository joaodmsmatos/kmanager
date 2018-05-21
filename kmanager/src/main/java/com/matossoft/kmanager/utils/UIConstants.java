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

import java.awt.Color;
import java.awt.Font;

/**
 * <code>UIHelper</code> provides constants to be used 
 * in the kmanager graphical user interface
 * 
 * credits: https://icons8.com/
 * 
 * @author https://github.com/joaodmsmatos/
 * @since 5.18.2018
 */
public class UIConstants 
{   
    /** tier 1 color - dark green*/ 
    public static final Color COLOR_TIER1 = new Color(0, 102, 0);
    
    /** tier 2 color - medium green*/ 
    public static final Color COLOR_TIER2 = new Color(0, 120, 0);
    
    /** tier 3 color - light green*/ 
    public static final Color COLOR_TIER3 = new Color(0, 235, 0);
    
    /** font small */ 
    public static final Font FONT_SMALL = new Font("Segoe UI", 0, 9);
    
    /** font medium */ 
    public static final Font FONT_MEDIUM = new Font("Segoe UI", 0, 13);
    
    /** font big */ 
    public static final Font FONT_BIG = new Font("Segoe UI", 0, 28);
    
    /** kmanager icon path*/
    public static final String KMANAGER_ICON_PATH = "icons/icons8-privacy-32.png";
     
    /** kmanager logo image path*/
    public static final String KMANAGER_LOGO_IMAGE_PATH = "images/kmanagerLogo.png";

    /** 
     * private constructor
     */ 
    private UIConstants() {}
}


