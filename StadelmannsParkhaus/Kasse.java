/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkhaus;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author fst
 */
public class Kasse extends JFrame{
    private Leitsystem system;
    JTable table;
    JLabel betrag;
            
    public Kasse(Leitsystem system)
    {
        this.system = system;
        this.setTitle("Kasse");
        this.setSize(400, 300);
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        
        
        pane.add(getCenter(), BorderLayout.CENTER); 
        pane.add(getLeft(), BorderLayout.WEST);
        pane.add(getRight(), BorderLayout.EAST);
        pane.add(getFooter(), BorderLayout.SOUTH);
        
        
        this.setVisible(true);
        
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
    protected JComponent getLeft() {

        JButton button = new JButton("Ticket zahlen");
        //button.setMinimumSize(new Dimension(200, 200));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                system.zahlen(table.getSelectedRow());
                table.repaint();
            }
        });

        return button;
    }      protected JComponent getCenter() {
        betrag = new JLabel("0.00", JLabel.CENTER);
        betrag.setFont(new Font("Courier", Font.BOLD, 24));
        return betrag;
    }
    
    protected JComponent getFooter(){
        table = new JTable(new Grid(this.system));

        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(true);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                Ticket ticket = system.getTickets().get(table.getSelectedRow());
                if (ticket != null)
                {
                    betrag.setText(Double.toString(ticket.getBetrag()));
                    table.repaint();
                }
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(200, 200));

        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);

        return panel;
    }
}
