/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angestellte;


import java.io.*;


public class Job implements Serializable {
    
    private double salary;
    private String nameOfJob;

    public Job(double salaray, String nameOfJob) {
        this.salary = salaray;
        this.nameOfJob = nameOfJob;
    }
    
    public boolean equals(Job job) {
        return (this.salary == job.salary && 
                this.nameOfJob.equals(job.nameOfJob));
        
        
    }

    public double getSalaray() {
        return salary;
    }

    public void setSalaray(double salaray) {
        this.salary = salaray;
    }

    public String getNameOfJob() {
        return nameOfJob;
    }

    public void setNameOfJob(String nameOfJob) {
        this.nameOfJob = nameOfJob;
    }

    
    
}
