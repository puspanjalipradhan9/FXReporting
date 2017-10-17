package com.fxreporting.reportgeneration.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.fxreporting.reportgeneration.constants.ReportConstants;
import com.fxreporting.reportgeneration.constants.ReportConstants.BuySell;
import com.fxreporting.reportgeneration.dao.ReportGenerationDAO;
import com.fxreporting.reportgeneration.dto.EntityRanking;
import com.fxreporting.reportgeneration.dto.FxReportingDTO;
import com.fxreporting.reportgeneration.dto.FxTrade;
import com.fxreporting.reportgeneration.exception.ReportException;
import com.fxreporting.reportgeneration.factory.ReportGenerationDaoFactory;
import com.fxreporting.reportgeneration.utils.ReportGenerationUtils;

/*
 * The FxReportGenerationServiceImpl is resposible for fetching all the trades from the database and then prepation of the corresponding Report. 
 * 
 */
public class FxReportGenerationServiceImpl implements ReportGenerationService {
    
    ReportGenerationDAO reportGenerationDAO = ReportGenerationDaoFactory.getReportGenerationDAO(ReportConstants.AssetType.FX.getAssetType());
    


    @Override
    public boolean createReport() {
        FxReportingDTO fxReportingDTO = fetchTotalIncomingAndOutGoingTradesAndEntitiesRankingCurrentDay();
        printReport(fxReportingDTO);
        return true;
    }
    
    /*
     * This function is reponsible for printing out the Report and Printing out the Ranking of the Entities.
     */
    private void printReport(FxReportingDTO fxReportingDTO){
        System.out.println("Totoal Incoming Amount : "+fxReportingDTO.getIncomingAmount());
        System.out.println("Totoal Outgoing Amount : "+fxReportingDTO.getOutgoingAmount());
        System.out.println("Totoal Incoming Entities Ranking : ");
        for(EntityRanking entityRanking : fxReportingDTO.getIncomingEntitiesRaking()){
            System.out.println(entityRanking);
        }
        
        System.out.println("Totoal Outgoing Entities Ranking : ");
        for(EntityRanking entityRanking : fxReportingDTO.getOutogingEntitiesRaking()){
            System.out.println(entityRanking);
        }
    }
    
    /*
     * 
     */
    private FxReportingDTO fetchTotalIncomingAndOutGoingTradesAndEntitiesRankingCurrentDay() {
        List<FxTrade> listFxTrades = reportGenerationDAO.fetchTradesOfTheDay();
        if(listFxTrades==null || listFxTrades.size()==0){
            throw new ReportException("Could not find any Trades for the particular day");
        }
        FxReportingDTO fxReportingDTO = new FxReportingDTO();
        BigDecimal totalOutgoingAmount = new BigDecimal("0");
        BigDecimal totalIncomingAmount = new BigDecimal("0");
        Map<String, EntityRanking> entityValueMapIncoming = new HashMap<>();
        Map<String, EntityRanking> entityValueMapOutgoing = new HashMap<>();
        
        //Iterate through the list of Trades
        for (FxTrade fxTrade : listFxTrades) {
            if (ReportGenerationUtils.isDateCurrent(fxTrade.getSettlementDate()) && isNotWeekend(fxTrade)) {
                if (fxTrade.getBuySell().toString().equals(BuySell.SELL.toString())) {
                    double sellAmount = fxTrade.getPricePerUnits() * fxTrade.getAgreedFX() * fxTrade.getUnits();
                    totalIncomingAmount= totalIncomingAmount.add(new BigDecimal(sellAmount));
                    entityValueMapping(entityValueMapIncoming,fxTrade,sellAmount);
                    
                } else {
                    double buyAmount = fxTrade.getPricePerUnits() * fxTrade.getAgreedFX() * fxTrade.getUnits();
                    totalOutgoingAmount = totalOutgoingAmount.add(new BigDecimal(buyAmount));
                    entityValueMapping(entityValueMapOutgoing,fxTrade,buyAmount);
                }
                
            }
        }
        
        fxReportingDTO.setIncomingAmount(totalIncomingAmount);
        fxReportingDTO.setOutgoingAmount(totalOutgoingAmount);
        fxReportingDTO.setIncomingEntitiesRaking(prepareEntityRankingSet(entityValueMapIncoming));
        fxReportingDTO.setOutogingEntitiesRaking(prepareEntityRankingSet(entityValueMapOutgoing));
        
        return fxReportingDTO;
    }
    
    private TreeSet<EntityRanking> prepareEntityRankingSet( Map<String, EntityRanking> map){
        TreeSet<EntityRanking> set = new TreeSet<>();
        for(Map.Entry<String, EntityRanking> entry : map.entrySet()){
            set.add(entry.getValue());
        }
        
        return set;
    }
    
    private void entityValueMapping(Map<String,EntityRanking> map,FxTrade fxTrade,double amount){
        if (map.containsKey(fxTrade.getEntity())) {
            EntityRanking entityRanking = map.get(fxTrade.getEntity());
            if(entityRanking.getAmount()<amount){
                entityRanking.setAmount(amount);
            }
        } else {
            map.put(fxTrade.getEntity(), new EntityRanking(fxTrade.getEntity(), amount));
        }
    }
    
    private boolean isNotWeekend(FxTrade fxTrade) {
        return !ReportGenerationUtils.isWeekend(fxTrade.getSettlementDate(), fxTrade.getCurrency());
    }

    public ReportGenerationDAO getReportGenerationDAO() {
        return reportGenerationDAO;
    }

    public void setReportGenerationDAO(ReportGenerationDAO reportGenerationDAO) {
        this.reportGenerationDAO = reportGenerationDAO;
    }
}
