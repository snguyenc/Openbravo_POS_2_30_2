//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007-2009 Openbravo, S.L.
//    http://www.openbravo.com/product/pos
//
//    This file is part of Openbravo POS.
//
//    Openbravo POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Openbravo POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Openbravo POS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.printer.screen;

import java.awt.*;
import com.openbravo.pos.printer.ticket.BasicTicket;
import java.util.Map;

class JTicket extends javax.swing.JPanel {
    
    private static final int H_GAP = 8;
    private static final int V_GAP = 8;
    private static final int COLUMNS = 42;
    private static final int LINEWIDTH = COLUMNS * 7;    
    
    private BasicTicket basict;
    private Map desktophints;
   
    /** Creates new form JTicket */
    public JTicket(BasicTicket t) {
        
        basict = t;
        desktophints = (Map) Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints");
        initComponents();
    }
    
    protected void paintComponent(Graphics g) {
        paintBorder(g);
        
        Graphics2D g2d = (Graphics2D) g;

        if (desktophints != null) {
            g2d.addRenderingHints(desktophints);
        }
        
        Insets i = getInsets();
        g2d.setPaint(new GradientPaint(getWidth() - i.left - i.right - 100, getHeight() - i.top - i.bottom - 100, getBackground()
                                     , getWidth() - i.left - i.right, getHeight() - i.top - i.bottom, new Color(0xf0f0f0), true));
        g2d.fillRect(i.left, i.top, getWidth() - i.left - i.right, getHeight() - i.top - i.bottom);
        
        g.setColor(getForeground());
        basict.draw(g2d, i.left + H_GAP, i.top + V_GAP, LINEWIDTH);   
    }  
    
      
    public Dimension getPreferredSize() {
        Insets ins = getInsets();
        return new Dimension((int) (LINEWIDTH + 2 * H_GAP) + ins.left + ins.right
                           , (int) (basict.getHeight() + 2 * V_GAP) + ins.top + ins.bottom);
    }

    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents

        setLayout(new java.awt.BorderLayout());

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0)));
    }//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
