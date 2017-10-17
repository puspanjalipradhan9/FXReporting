package com.fxreporting.reportgeneration.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fxreporting.reportgeneration.constants.ReportConstants.BuySell;

public class FxTrade extends Trade {
    private String     entity;
    private BuySell    buySell;
    private double agreedFX;
    private String     currency;
    private Date       instructionDate;
    private Date       settlementDate;
    private int        units;
    private double     pricePerUnits;
    
    public FxTrade(FxTradeBuilder fx) {
        this.entity = fx.entity;
        this.buySell = fx.buySell;
        this.agreedFX = fx.agreedFX;
        this.currency = fx.currency;
        this.instructionDate = fx.instructionDate;
        this.settlementDate = fx.settlementDate;
        this.units = fx.units;
        this.pricePerUnits = fx.pricePerUnits;
    }
    
    public String getEntity() {
        return entity;
    }
    
    public void setEntity(String entity) {
        this.entity = entity;
    }
    
    public BuySell getBuySell() {
        return buySell;
    }
    
    public void setPosition(BuySell buySell) {
        this.buySell = buySell;
    }
    
    public double getAgreedFX() {
        return agreedFX;
    }
    
    public void setAgreedFX(double agreedFX) {
        this.agreedFX = agreedFX;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public Date getInstructionDate() {
        return instructionDate;
    }
    
    public void setInstructionDate(Date instructionDate) {
        this.instructionDate = instructionDate;
    }
    
    public Date getSettlementDate() {
        return settlementDate;
    }
    
    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }
    
    public int getUnits() {
        return units;
    }
    
    public void setUnits(int units) {
        this.units = units;
    }
    
    public double getPricePerUnits() {
        return pricePerUnits;
    }
    
    public void setPricePerUnits(double pricePerUnits) {
        this.pricePerUnits = pricePerUnits;
    }
    
    public static class FxTradeBuilder {
        
        private String     entity;
        private BuySell    buySell;
        private double agreedFX;
        private String     currency;
        private Date       instructionDate;
        private Date       settlementDate;
        private int        units;
        private double     pricePerUnits;
        
        public FxTradeBuilder setEntity(String entity) {
            this.entity = entity;
            return this;
        }
        
        public FxTradeBuilder setBuySell(BuySell buySell) {
            this.buySell = buySell;
            return this;
        }
        
        public FxTradeBuilder setAgreedFX(double agreedFX) {
            this.agreedFX = agreedFX;
            return this;
        }
        
        public FxTradeBuilder setCurrency(String currency) {
            this.currency = currency;
            return this;
        }
        
        public FxTradeBuilder setInstructionDate(Date instructionDate) {
            this.instructionDate = instructionDate;
            return this;
        }
        
        public FxTradeBuilder setSettlementDate(Date settlementDate) {
            this.settlementDate = settlementDate;
            return this;
        }
        
        public FxTradeBuilder setUnits(int units) {
            this.units = units;
            return this;
        }
        
        public FxTradeBuilder setPricePerUnits(double pricePerUnits) {
            this.pricePerUnits = pricePerUnits;
            return this;
        }
        
        public FxTrade build() {
            return new FxTrade(this);
        }
        
    }
}
