package com.fxreporting.reportgeneration.factory;

import java.util.HashMap;
import java.util.Map;

import com.fxreporting.reportgeneration.constants.ReportConstants;
import com.fxreporting.reportgeneration.dao.FxReportGenerationDAOImpl;
import com.fxreporting.reportgeneration.dao.ReportGenerationDAO;
import com.fxreporting.reportgeneration.service.ReportGenerationService;

public class ReportGenerationDaoFactory {
    
    static Map<String,ReportGenerationDAO> daoMap = new HashMap<>();
    
    static {
        daoMap.put(ReportConstants.AssetType.FX.getAssetType(), new FxReportGenerationDAOImpl());
    }
    
    public static ReportGenerationDAO getReportGenerationDAO(String serviceType){
        return daoMap.get(serviceType);
    }
}
