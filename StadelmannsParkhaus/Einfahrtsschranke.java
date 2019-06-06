/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkhaus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author fst
 */
public class Einfahrtsschranke extends Schranke {

    public Einfahrtsschranke(Leitsystem system) {
        super(system);
        this.setSize(160, 350);
        this.setTitle("Einfahrtsschranke");
    }

    protected JComponent getFooter() {

        JButton button = new JButton("Ticket ausgeben");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {system.einfahren();}
        });

        return button;
    }

}
