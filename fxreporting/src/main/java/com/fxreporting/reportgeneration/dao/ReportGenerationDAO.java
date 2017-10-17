package com.fxreporting.reportgeneration.dao;

import java.util.List;

import com.fxreporting.reportgeneration.dto.FxTrade;

public interface ReportGenerationDAO {
    public List<FxTrade> fetchTradesOfTheDay();
}
