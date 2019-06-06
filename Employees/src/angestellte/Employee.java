/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angestellte;


import java.io.*;

public class Employee implements Serializable {
    private String name;
    private String vorname;
    private Job job;
    private int staffNr;

    public Employee(String name, String vorname, Job job, int staffNr) {
        this.name = name;
        this.vorname = vorname;
        this.job = job;
        this.staffNr = staffNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getStaffNr() {
        return staffNr;
    }

    public void setStaffNr(int staffNr) {
        this.staffNr = staffNr;
    }
    
    
}
