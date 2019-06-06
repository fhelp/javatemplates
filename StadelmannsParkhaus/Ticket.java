/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkhaus;

import org.joda.time.*;

/**
 *
 * @author fst
 */
public class Ticket {
    protected final double PREIS = 2.5;
    
    protected DateTime ausgabe;

    public DateTime getAusgabe() {
        return ausgabe;
    }

    public DateTime getVerfall() {
        return verfall;
    }
    protected DateTime verfall;
    
    public Ticket()
    {
        this.ausgabe = new DateTime(DateTimeZone.UTC);
        this.verfall = ausgabe.plusSeconds(10);
    }
    
    public void setBezahlt()
    {
        DateTime jetzt = new DateTime(DateTimeZone.UTC);
        verfall = jetzt.plusSeconds(10);
    }
    
    public double getBetrag()
    {
        DateTime jetzt = new DateTime(DateTimeZone.UTC);
        int sek = Seconds.secondsBetween(verfall, jetzt).getSeconds();
        
        if (sek <= 0)
            return 0;
        else
            return sek * this.PREIS;
    }
    
}
