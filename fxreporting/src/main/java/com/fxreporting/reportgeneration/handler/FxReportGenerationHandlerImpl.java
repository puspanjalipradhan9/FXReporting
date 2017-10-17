package com.fxreporting.reportgeneration.handler;

import com.fxreporting.reportgeneration.constants.ReportConstants;
import com.fxreporting.reportgeneration.factory.ReportGenerationServiceFactory;
import com.fxreporting.reportgeneration.service.ReportGenerationService;

/*
 * The FxReportGenerationHandler is responsible for the Genration of FX Trade Reports.
 *  The service Implementation could be injected using Spring injection factory Method.
 */
public class FxReportGenerationHandlerImpl implements ReportGenerationHandler {
    
    ReportGenerationService reportGenerationService = null;
    
    {
        reportGenerationService = ReportGenerationServiceFactory.getReportGenerationService(ReportConstants.AssetType.FX.getAssetType());
    }
    
    public void handle(){
        reportGenerationService.createReport();
    }
}
