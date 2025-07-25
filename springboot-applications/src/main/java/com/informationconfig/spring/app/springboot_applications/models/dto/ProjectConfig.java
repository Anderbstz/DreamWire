package com.informationconfig.spring.app.springboot_applications.models.dto;

import java.util.List;

public class ProjectConfig {
    private String projectName;
    private String packageName;
    private List<String> selectedEntities;
    private List<String> selectedFeatures;
    private boolean includeAuthentication;
    private boolean includeDatabase;
    private String databaseType;
    private boolean includeFrontend;
    private String frontendFramework;
    
    // Constructors
    public ProjectConfig() {}
    
    public ProjectConfig(String projectName, String packageName, List<String> selectedEntities,
                        List<String> selectedFeatures, boolean includeAuthentication,
                        boolean includeDatabase, String databaseType, boolean includeFrontend,
                        String frontendFramework) {
        this.projectName = projectName;
        this.packageName = packageName;
        this.selectedEntities = selectedEntities;
        this.selectedFeatures = selectedFeatures;
        this.includeAuthentication = includeAuthentication;
        this.includeDatabase = includeDatabase;
        this.databaseType = databaseType;
        this.includeFrontend = includeFrontend;
        this.frontendFramework = frontendFramework;
    }
    
    // Getters and Setters
    public String getProjectName() {
        return projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public String getPackageName() {
        return packageName;
    }
    
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    
    public List<String> getSelectedEntities() {
        return selectedEntities;
    }
    
    public void setSelectedEntities(List<String> selectedEntities) {
        this.selectedEntities = selectedEntities;
    }
    
    public List<String> getSelectedFeatures() {
        return selectedFeatures;
    }
    
    public void setSelectedFeatures(List<String> selectedFeatures) {
        this.selectedFeatures = selectedFeatures;
    }
    
    public boolean isIncludeAuthentication() {
        return includeAuthentication;
    }
    
    public void setIncludeAuthentication(boolean includeAuthentication) {
        this.includeAuthentication = includeAuthentication;
    }
    
    public boolean isIncludeDatabase() {
        return includeDatabase;
    }
    
    public void setIncludeDatabase(boolean includeDatabase) {
        this.includeDatabase = includeDatabase;
    }
    
    public String getDatabaseType() {
        return databaseType;
    }
    
    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }
    
    public boolean isIncludeFrontend() {
        return includeFrontend;
    }
    
    public void setIncludeFrontend(boolean includeFrontend) {
        this.includeFrontend = includeFrontend;
    }
    
    public String getFrontendFramework() {
        return frontendFramework;
    }
    
    public void setFrontendFramework(String frontendFramework) {
        this.frontendFramework = frontendFramework;
    }
}