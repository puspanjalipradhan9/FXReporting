package com.fxreporting.reportgeneration.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReportGenerationUtilsTest {
    @Test
    public void shouldReturnFalseWhenGivenDateIsMoreThanCurrentDate(){
        Date givenDate = ReportGenerationUtils.convertStringToDate("01/01/2100");
        assertFalse(ReportGenerationUtils.isDateCurrent(givenDate));
    }
    
    @Test
    public void shouldReturnFalseWhenGivenDateIsEqualCurrentDate(){
        Date givenDate = new Date();
        assertTrue(ReportGenerationUtils.isDateCurrent(givenDate));
    }
    
    @Test
    public void shouldReturnWeekendAsTrueForFridayForAED(){
        Date givenDate = ReportGenerationUtils.convertStringToDate("10/06/2017");
        assertTrue(ReportGenerationUtils.isWeekend(givenDate, "AED"));
    }
    
    @Test
    public void shouldReturnWeekendAsTrueForSundayForAED(){
        Date givenDate = ReportGenerationUtils.convertStringToDate("10/08/2017");
        assertFalse(ReportGenerationUtils.isWeekend(givenDate, "AED"));
    }
}
