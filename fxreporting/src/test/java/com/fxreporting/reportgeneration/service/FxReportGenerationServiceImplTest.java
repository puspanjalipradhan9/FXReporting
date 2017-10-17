package com.fxreporting.reportgeneration.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.fxreporting.reportgeneration.constants.ReportConstants.BuySell;
import com.fxreporting.reportgeneration.dao.ReportGenerationDAO;
import com.fxreporting.reportgeneration.dto.FxTrade;
import com.fxreporting.reportgeneration.exception.ReportException;
import com.fxreporting.reportgeneration.utils.ReportGenerationUtils;

@RunWith(MockitoJUnitRunner.class)
public class FxReportGenerationServiceImplTest {
    
    FxReportGenerationServiceImpl fxReportGenerationServiceImpl = null;
    
    @Mock 
    ReportGenerationDAO reportGenerationDAO;
    
    @Before
    public void setUp(){
        fxReportGenerationServiceImpl = new FxReportGenerationServiceImpl();
        when(reportGenerationDAO.fetchTradesOfTheDay()).thenReturn(prepareData());
        fxReportGenerationServiceImpl.setReportGenerationDAO(reportGenerationDAO);
    }
    
    @Test
    public void shouldCreateReport(){
        assertTrue(fxReportGenerationServiceImpl.createReport());
    }
    
    @Test(expected=ReportException.class)
    public void shouldThrowExceptionWhileCreatingReport(){
        when(reportGenerationDAO.fetchTradesOfTheDay()).thenReturn(null);
        assertTrue(fxReportGenerationServiceImpl.createReport());
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
        
        
        fxTradesList.add(new FxTrade.FxTradeBuilder()
                .setEntity("foo")
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
