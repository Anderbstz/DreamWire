package com.informationconfig.spring.app.springboot_applications.models.dto;

import java.util.List;

public class ProjectAnalysis {
    private String analyzedIdea;
    private List<String> suggestedEntities;
    private List<String> suggestedEndpoints;
    private List<String> suggestedFeatures;
    private String projectStructure;
    
    // Constructors
    public ProjectAnalysis() {}
    
    public ProjectAnalysis(String analyzedIdea, List<String> suggestedEntities, 
                          List<String> suggestedEndpoints, List<String> suggestedFeatures,
                          String projectStructure) {
        this.analyzedIdea = analyzedIdea;
        this.suggestedEntities = suggestedEntities;
        this.suggestedEndpoints = suggestedEndpoints;
        this.suggestedFeatures = suggestedFeatures;
        this.projectStructure = projectStructure;
    }
    
    // Getters and Setters
    public String getAnalyzedIdea() {
        return analyzedIdea;
    }
    
    public void setAnalyzedIdea(String analyzedIdea) {
        this.analyzedIdea = analyzedIdea;
    }
    
    public List<String> getSuggestedEntities() {
        return suggestedEntities;
    }
    
    public void setSuggestedEntities(List<String> suggestedEntities) {
        this.suggestedEntities = suggestedEntities;
    }
    
    public List<String> getSuggestedEndpoints() {
        return suggestedEndpoints;
    }
    
    public void setSuggestedEndpoints(List<String> suggestedEndpoints) {
        this.suggestedEndpoints = suggestedEndpoints;
    }
    
    public List<String> getSuggestedFeatures() {
        return suggestedFeatures;
    }
    
    public void setSuggestedFeatures(List<String> suggestedFeatures) {
        this.suggestedFeatures = suggestedFeatures;
    }
    
    public String getProjectStructure() {
        return projectStructure;
    }
    
    public void setProjectStructure(String projectStructure) {
        this.projectStructure = projectStructure;
    }
}