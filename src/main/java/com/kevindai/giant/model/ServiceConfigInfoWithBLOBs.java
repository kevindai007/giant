package com.kevindai.giant.model;

public class ServiceConfigInfoWithBLOBs extends ServiceConfigInfo {
    private String responseScript;

    private String requestScript;

    private String inputTemplate;

    private String outputTemplate;

    private String inputConfig;

    private String outConfig;

    public String getResponseScript() {
        return responseScript;
    }

    public void setResponseScript(String responseScript) {
        this.responseScript = responseScript == null ? null : responseScript.trim();
    }

    public String getRequestScript() {
        return requestScript;
    }

    public void setRequestScript(String requestScript) {
        this.requestScript = requestScript == null ? null : requestScript.trim();
    }

    public String getInputTemplate() {
        return inputTemplate;
    }

    public void setInputTemplate(String inputTemplate) {
        this.inputTemplate = inputTemplate == null ? null : inputTemplate.trim();
    }

    public String getOutputTemplate() {
        return outputTemplate;
    }

    public void setOutputTemplate(String outputTemplate) {
        this.outputTemplate = outputTemplate == null ? null : outputTemplate.trim();
    }

    public String getInputConfig() {
        return inputConfig;
    }

    public void setInputConfig(String inputConfig) {
        this.inputConfig = inputConfig == null ? null : inputConfig.trim();
    }

    public String getOutConfig() {
        return outConfig;
    }

    public void setOutConfig(String outConfig) {
        this.outConfig = outConfig == null ? null : outConfig.trim();
    }
}