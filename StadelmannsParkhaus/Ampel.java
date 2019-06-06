/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkhaus;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author fst
 */
public class Ampel extends JPanel {

    protected boolean isOffen = false;
    
    public void oeffnen() {
        this.isOffen = true;
        this.repaint();
    }

        public void schliessen() {
        this.isOffen = false;
        this.repaint();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double oben = new Ellipse2D.Double(30, 30, 100, 100);
        Ellipse2D.Double unten = new Ellipse2D.Double(30, 160, 100, 100);

        if (isOffen) {
            g2d.setColor(Color.GRAY);
            g2d.fill(oben);

            g2d.setColor(Color.GREEN);
            g2d.fill(unten);
        } else {
            g2d.setColor(Color.RED);
            g2d.fill(oben);

            g2d.setColor(Color.GRAY);
            g2d.fill(unten);
        }
    }
}
