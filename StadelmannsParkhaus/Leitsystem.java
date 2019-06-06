/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkhaus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author fst
 */
public class Leitsystem extends JFrame implements ActionListener {

    protected final int MAX_PLAETZE = 100;

    protected TreeMap<Integer, Ticket> tickets = new TreeMap<Integer, Ticket>();
    protected Kasse kasse = new Kasse(this);
    protected Einfahrtsschranke einfahrt = new Einfahrtsschranke(this);
    protected Ausfahrtsschranke ausfahrt = new Ausfahrtsschranke(this);

    public TreeMap<Integer, Ticket> getTickets() {
        //System.out.println(tickets.size());
        return tickets;
    }

    public Leitsystem() {
        CreateMenu();

        this.setTitle("Leitsystem");
        this.setSize(200, 200);
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public int getFreiePlaetze() {
        return MAX_PLAETZE - this.getBelegtePlaetze();
    }

    public int getBelegtePlaetze() {
        return tickets.size();
    }

    public void einfahren() {
        if (this.getFreiePlaetze() > 0) {
            int index = tickets.size() == 0 ? 0 : tickets.lastKey() + 1;
            tickets.put(index, new Ticket());
            einfahrt.oeffnen(false);
        }
    }

    public void ausfahren(int key) {
        Ticket ticket = tickets.get(key);

        if (ticket != null && ticket.verfall.isAfterNow()) {
            ausfahrt.oeffnen(false);
            
            tickets.remove(key);
        }
    }
    public void zahlen(int key) {
        Ticket ticket = tickets.get(key);

        if (ticket != null) {
            ticket.setBezahlt();
        }
    }
    protected void CreateMenu() {
        JMenuBar bar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        bar = new JMenuBar();

        menu = new JMenu("Befehle");
        bar.add(menu);

        //Einfahrtsschranke
        submenu = new JMenu("Einfahrtsschranke");

        menuItem = new JMenuItem("Oeffnen");
        menuItem.setActionCommand("Einfahrt.Oeffnen");
        menuItem.addActionListener(this);
        submenu.add(menuItem);

        menuItem = new JMenuItem("Offen lassen");
        menuItem.setActionCommand("Einfahrt.OffenLassen");
        menuItem.addActionListener(this);
        submenu.add(menuItem);

        menuItem = new JMenuItem("Schliessen");
        menuItem.setActionCommand("Einfahrt.Schliessen");
        menuItem.addActionListener(this);
        submenu.add(menuItem);

        menu.add(submenu);

        //Ausfahrtsschranke
        submenu = new JMenu("Ausfahrtsschranke");

        menuItem = new JMenuItem("Oeffnen");
        menuItem.setActionCommand("Ausfahrt.Oeffnen");
        menuItem.addActionListener(this);
        submenu.add(menuItem);

        menuItem = new JMenuItem("Offen lassen");
        menuItem.setActionCommand("Ausfahrt.OffenLassen");
        menuItem.addActionListener(this);
        submenu.add(menuItem);

        menuItem = new JMenuItem("Schliessen");
        menuItem.setActionCommand("Ausfahrt.Schliessen");
        menuItem.addActionListener(this);
        submenu.add(menuItem);

        menu.add(submenu);

        menu.addSeparator();
        menuItem = new JMenuItem("Beenden");
        menuItem.setActionCommand("Beenden");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        this.setJMenuBar(bar);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Einfahrt.Oeffnen":
                einfahrt.oeffnen(false);
                break;
            case "Einfahrt.OffenLassen":
                einfahrt.oeffnen(true);
                break;
            case "Einfahrt.Schliessen":
                einfahrt.schliessen();
                break;
            case "Ausfahrt.Oeffnen":
                ausfahrt.oeffnen(false);
                break;
            case "Ausfahrt.OffenLassen":
                ausfahrt.oeffnen(true);
                break;
            case "Ausfahrt.Schliessen":
                ausfahrt.schliessen();
                break;
            case "Beenden":
                System.exit(0);
                break;
        }
    }
}
