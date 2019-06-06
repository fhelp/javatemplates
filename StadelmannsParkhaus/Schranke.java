/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkhaus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author fst
 */
public abstract class Schranke extends JFrame {

    protected Leitsystem system;
    protected Container pane;
    protected Ampel ampel = new Ampel();
    protected JComponent footer;
    protected boolean isOffen = false;

    public Schranke(Leitsystem system) {
        this.system = system;
        
        footer = this.getFooter();

        pane = getContentPane();
        pane.setLayout(new BorderLayout());

        pane.add(ampel, BorderLayout.CENTER);
        pane.add(footer, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void oeffnen(boolean isOffenHalten) {
        this.isOffen = true;
        ampel.oeffnen();

        if (!isOffenHalten) {
            Timer timer = new Timer();
            timer.schedule(new Task(this), 3000);
        }

    }

    public void schliessen() {
        isOffen = false;

        ampel.schliessen();
    }

    protected abstract JComponent getFooter();

    class Task extends TimerTask {

        protected Schranke schranke;

        public Task(Schranke schranke) {
            this.schranke = schranke;
        }

        public void run() {
            schranke.schliessen();
        }
    }
}
