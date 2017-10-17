package com.fxreporting.reportgeneration.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.fxreporting.reportgeneration.dto.FxTrade;

@RunWith(MockitoJUnitRunner.class)
public class FxReportGenerationDAOImplTest {
    
    FxReportGenerationDAOImpl fxReportGenerationDAOImpl;
    
    @Before
    public void setUp(){
        fxReportGenerationDAOImpl = new FxReportGenerationDAOImpl();
    }
    @Test
    public void shouldReturnTradesOfTheCurrentDay(){
        List<FxTrade> listFxTrades = fxReportGenerationDAOImpl.fetchTradesOfTheDay();
        assertTrue(listFxTrades.size()>0);
    }

}
