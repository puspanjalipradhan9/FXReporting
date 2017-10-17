package com.fxreporting.reportgeneration.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fxreporting.reportgeneration.constants.ReportConstants.BuySell;
import com.fxreporting.reportgeneration.dto.FxTrade;
import com.fxreporting.reportgeneration.utils.ReportGenerationUtils;

/*
 * The FxGenerationDAO is resposible for fetching all the trades from the database. 
 * In case the volumes will be high, then the same calculations can be done at the Database layers layers itself.
 * If the volumes are low the entire volume can be loaded up at the time of invocation of the method of the application.
 */
public class FxReportGenerationDAOImpl implements ReportGenerationDAO {

    @Override
    public List<FxTrade> fetchTradesOfTheDay() {
        return prepareData();
    }
    
    
    public List<FxTrade>  prepareData(){
        
        List<FxTrade> fxTradesList = new ArrayList<>();
        fxTradesList.add(new FxTrade.FxTradeBuilder()
                                     .setEntity("foo")
                                     .setBuySell(BuySell.BUY)
                                     .setAgreedFX(0.50)
                                     .setCurrency("SGP")
                                     .setInstructionDate(ReportGenerationUtils.convertStringToDate("10/27/2017"))
                                     .setSettlementDate(new Date())
                                     .setUnits(200)
                                     .setPricePerUnits(100.25).build());
        
        fxTradesList.add(new FxTrade.FxTradeBuilder()
                .setEntity("bar")
                .setBuySell(BuySell.SELL)
                .setAgreedFX(0.22)
                .setCurrency("AED")
                .setInstructionDate(ReportGenerationUtils.convertStringToDate("10/27/2017"))
                .setSettlementDate(new Date())
                .setUnits(450)
                .setPricePerUnits(150.5).build());  
        
        
        fxTradesList.add(new FxTrade.FxTradeBuilder()
                .setEntity("BARCLAYS")
                .setBuySell(BuySell.BUY)
                .setAgreedFX(0.3)
                .setCurrency("INR")
                .setInstructionDate(ReportGenerationUtils.convertStringToDate("10/27/2017"))
                .setSettlementDate(new Date())
                .setUnits(300)
                .setPricePerUnits(150.5).build());          
        
        return fxTradesList;
        
    }
}
