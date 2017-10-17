package com.fxreporting.reportgeneration.dto;

import java.util.TreeSet;

public class EntityRanking implements Comparable{
    private String entity;
    private double amount;
    
    public EntityRanking(String entity,double amount){
        this.entity = entity;
        this.amount = amount;
    }
    
    public String getEntity() {
        return entity;
    }
    public void setEntity(String entity) {
        this.entity = entity;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof EntityRanking){
            EntityRanking entityRanking = (EntityRanking) o;
            return this.amount<entityRanking.amount?+1:-1;
        }
        return 0;
    }

    public String toString(){
        return "Entity : "+this.entity+" , Amount : "+this.amount;
    }
    
}


