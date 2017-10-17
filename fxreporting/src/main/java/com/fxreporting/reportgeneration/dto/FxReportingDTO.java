package com.fxreporting.reportgeneration.dto;

import java.math.BigDecimal;
import java.util.TreeSet;

public class FxReportingDTO {
    
    private BigDecimal incomingAmount;
    private BigDecimal outgoingAmount;
    private TreeSet<EntityRanking> incomingEntitiesRaking;
    private TreeSet<EntityRanking> outogingEntitiesRaking;
    
    public BigDecimal getIncomingAmount() {
        return incomingAmount;
    }
    public void setIncomingAmount(BigDecimal incomingAmount) {
        this.incomingAmount = incomingAmount;
    }
    public BigDecimal getOutgoingAmount() {
        return outgoingAmount;
    }
    public void setOutgoingAmount(BigDecimal outgoingAmount) {
        this.outgoingAmount = outgoingAmount;
    }
    public TreeSet<EntityRanking> getIncomingEntitiesRaking() {
        return incomingEntitiesRaking;
    }
    public void setIncomingEntitiesRaking(TreeSet<EntityRanking> incomingEntitiesRaking) {
        this.incomingEntitiesRaking = incomingEntitiesRaking;
    }
    public TreeSet<EntityRanking> getOutogingEntitiesRaking() {
        return outogingEntitiesRaking;
    }
    public void setOutogingEntitiesRaking(TreeSet<EntityRanking> outogingEntitiesRaking) {
        this.outogingEntitiesRaking = outogingEntitiesRaking;
    }


}
