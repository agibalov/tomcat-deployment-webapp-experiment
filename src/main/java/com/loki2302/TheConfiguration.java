package com.loki2302;

public class TheConfiguration {
    private final String environmentName;
    private final String rootUrl;
    
    public TheConfiguration(
            String environmentName, 
            String rootUrl) {
        this.environmentName = environmentName;
        this.rootUrl = rootUrl;            
    }
    
    public String getEnvironmentName() {
        return environmentName;
    }
    
    public String getRootUrl() {
        return rootUrl;
    }
}