package com.fxreporting;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.fxreporting.reportgeneration.ReportGeneration;
import com.fxreporting.reportgeneration.constants.ReportConstants;

@RunWith(MockitoJUnitRunner.class)
public class ReportgenerationTest {
    
    ReportGeneration reportGeneration;
    
    @Before
    public void setUp(){
        reportGeneration = new ReportGeneration();
    }
    
    @Test
    public void shouldGenerateFxReport(){
        reportGeneration.handle(ReportConstants.AssetType.FX.getAssetType());
    }
}
