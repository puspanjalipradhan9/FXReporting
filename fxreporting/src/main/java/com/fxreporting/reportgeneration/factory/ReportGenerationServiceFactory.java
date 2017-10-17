package com.fxreporting.reportgeneration.factory;

import java.util.HashMap;
import java.util.Map;

import com.fxreporting.reportgeneration.constants.ReportConstants;
import com.fxreporting.reportgeneration.service.FxReportGenerationServiceImpl;
import com.fxreporting.reportgeneration.service.ReportGenerationService;

public class ReportGenerationServiceFactory {
    
    static Map<String,ReportGenerationService> serviceMap = new HashMap<>();
    
    static {
        serviceMap.put(ReportConstants.AssetType.FX.getAssetType(), new FxReportGenerationServiceImpl());
    }
    
    public static ReportGenerationService getReportGenerationService(String serviceType){
        return serviceMap.get(serviceType);
    }
}
