/*
 * Copyright (C) 2021 util2
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
package org.wingate.assfxmaker.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import org.wingate.assfxmaker.sfx.AfmLegacy;

/**
 *
 * @author util2
 */
public class SfxListCellRenderer extends JPanel implements ListCellRenderer {
    
    private static final int ICON_WIDTH = 30;
    private static final int ITEM_WIDTH = 150;
    private static final int DESC_WIDTH = 350;
    private static final int WHOLE_HEIGHT = 30;
    
    private final ImageIcon afmIcon = new ImageIcon(getClass().getResource("/images/xml-icon-small.png"));
    private final ImageIcon rubyIcon = new ImageIcon(getClass().getResource("/images/rb-icon-small.png"));
    private final ImageIcon pythonIcon = new ImageIcon(getClass().getResource("/images/py-icon-small.png"));
    private final ImageIcon javascriptIcon = new ImageIcon(getClass().getResource("/images/js-icon-small.png"));
    private final ImageIcon luaIcon = new ImageIcon(getClass().getResource("/images/lua-icon-small.png"));
    
    private final JLabel lblImage = new JLabel();
    private final JLabel lblName = new JLabel();
    private final JLabel lblAuthor = new JLabel();
    private final JLabel lblVersion = new JLabel();
    private final JLabel lblDescription = new JLabel();

    public SfxListCellRenderer() {
        init();
    }
    
    private void init(){
        setLayout(null);
        setPreferredSize(new Dimension(ICON_WIDTH + ITEM_WIDTH + DESC_WIDTH, WHOLE_HEIGHT));
        
        lblImage.setSize(ICON_WIDTH, WHOLE_HEIGHT);
        lblImage.setLocation(0, 0);
        add(lblImage);        
        
        lblName.setSize(ITEM_WIDTH, WHOLE_HEIGHT / 2);
        lblName.setLocation(ICON_WIDTH, 0);
        add(lblName);
        
        lblAuthor.setSize(ICON_WIDTH, WHOLE_HEIGHT / 2);
        lblAuthor.setLocation(ICON_WIDTH, WHOLE_HEIGHT / 2);
        lblAuthor.setFont(lblAuthor.getFont().deriveFont(Font.ITALIC));
        add(lblAuthor);
        
        lblVersion.setSize(DESC_WIDTH, WHOLE_HEIGHT / 2);
        lblVersion.setLocation(ICON_WIDTH + ITEM_WIDTH, 0);
        add(lblVersion);
        
        lblDescription.setSize(DESC_WIDTH, WHOLE_HEIGHT / 2);
        lblDescription.setLocation(ICON_WIDTH + ITEM_WIDTH, WHOLE_HEIGHT / 2);
        lblDescription.setFont(lblDescription.getFont().deriveFont(Font.ITALIC));
        add(lblDescription);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object o,
            int index, boolean isSelected, boolean cellHasFocus)
    {
        if(o instanceof AfmLegacy){
            AfmLegacy sfx = (AfmLegacy)o;
            
            lblName.setText(sfx.getName());
            lblAuthor.setText(sfx.getAuthor());
            lblVersion.setText(sfx.getVersion());
            lblDescription.setText(sfx.getDescription());
            
            switch(sfx.getType()){
                case AFM -> {
                    lblImage.setIcon(afmIcon);                    
                    lblName.setForeground(Color.magenta.darker());                                        
                }                
                case Ruby -> {
                    lblImage.setIcon(rubyIcon);
                    lblName.setForeground(Color.red.darker());
                }                
                case Python -> {
                    lblImage.setIcon(pythonIcon);
                    lblName.setForeground(Color.green.darker());
                }                
                case JavaScript -> {
                    lblImage.setIcon(javascriptIcon);
                    lblName.setForeground(Color.yellow);
                }                
                case Lua -> {
                    lblImage.setIcon(luaIcon);
                    lblName.setForeground(Color.blue.darker());
                }
            }
            
            if(isSelected == true){
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            }else{
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
        }
        
        return this;
    }
    
}
