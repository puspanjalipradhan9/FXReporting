package com.fxreporting.reportgeneration.factory;

import java.util.HashMap;
import java.util.Map;

import com.fxreporting.reportgeneration.constants.ReportConstants;
import com.fxreporting.reportgeneration.handler.FxReportGenerationHandlerImpl;
import com.fxreporting.reportgeneration.handler.ReportGenerationHandler;

public class ReportGenerationHandlerFactory {
    
    static Map<String,ReportGenerationHandler> handlerMap = new HashMap<>();
    
    static {
        handlerMap.put(ReportConstants.AssetType.FX.getAssetType(), new FxReportGenerationHandlerImpl());
    }
    
    public static ReportGenerationHandler getReportGenerationHandler(String handlerType){
        return handlerMap.get(handlerType);
    }
}
