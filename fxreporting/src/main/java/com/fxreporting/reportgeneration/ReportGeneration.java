package com.fxreporting.reportgeneration;

import com.fxreporting.reportgeneration.constants.ReportConstants;
import com.fxreporting.reportgeneration.factory.ReportGenerationHandlerFactory;
import com.fxreporting.reportgeneration.handler.ReportGenerationHandler;

/**
 * This class is the initiater app which will be responsible for the Generation of  Report.
 * The class can be injected with arguments to decide the type of Handler to be used 
 *
 */
public class ReportGeneration{
    
    
    public static void main( String[] args ){
        ReportGeneration reportGeneration = new ReportGeneration();
        reportGeneration.handle(ReportConstants.AssetType.FX.getAssetType());
    }
    
    public void handle(String reportType){
        try{
            ReportGenerationHandler handler = ReportGenerationHandlerFactory.getReportGenerationHandler(reportType);
            handler.handle();
        }catch(Exception e){
            System.out.println("Exception occured while handling the Report Generation "+e.getMessage());
        }
    }
}
