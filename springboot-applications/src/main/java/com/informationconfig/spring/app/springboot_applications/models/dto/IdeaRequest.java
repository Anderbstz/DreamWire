package com.informationconfig.spring.app.springboot_applications.models.dto;

public class IdeaRequest {
    private String idea;
    private String projectName;
    private String description;
    
    // Constructors
    public IdeaRequest() {}
    
    public IdeaRequest(String idea, String projectName, String description) {
        this.idea = idea;
        this.projectName = projectName;
        this.description = description;
    }
    
    // Getters and Setters
    public String getIdea() {
        return idea;
    }
    
    public void setIdea(String idea) {
        this.idea = idea;
    }
    
    public String getProjectName() {
        return projectName;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}