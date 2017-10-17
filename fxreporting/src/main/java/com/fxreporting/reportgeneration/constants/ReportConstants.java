package com.fxreporting.reportgeneration.constants;

public interface ReportConstants {

    public enum AssetType {
        
        FX("FOREX");
        
        private String assetType;
        
        AssetType(String assetType){
            this.assetType = assetType;
        }
        
        public String getAssetType(){
            return assetType;
        }
    }
    
    public enum BuySell {
        BUY("BUY"),SELL("SELL");
        
        private String position;
        
        BuySell(String position){
            this.position = position;
        }
        
        public String toString(){
            return position;
        }
    }
}
