/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkhaus;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author fst
 */
public class Ausfahrtsschranke extends Schranke {
    
    JTable table;
    

    public Ausfahrtsschranke(Leitsystem system) {
        super(system);

        pane.add(getRight(), BorderLayout.EAST);

        this.setSize(350, 500);
        this.setTitle("Ausfahrtsschranke");
    }

    protected JComponent getFooter() {

        table = new JTable(new Grid(this.system));

        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(true);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                system.ausfahren(table.getSelectedRow());
                table.repaint();
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(200, 200));

        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);

        return panel;
    }

    protected JComponent getRight() {

        JButton button = new JButton("Liste aktualisieren");
        //button.setMinimumSize(new Dimension(200, 200));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                table.repaint();
            }
        });

        return button;
    }
}
