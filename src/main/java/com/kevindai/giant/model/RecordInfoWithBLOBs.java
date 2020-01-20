package com.kevindai.giant.model;

public class RecordInfoWithBLOBs extends RecordInfo {
    private String originalRequestParams;

    private String finalResponse;

    private String requestParams;

    private String response;

    public String getOriginalRequestParams() {
        return originalRequestParams;
    }

    public void setOriginalRequestParams(String originalRequestParams) {
        this.originalRequestParams = originalRequestParams == null ? null : originalRequestParams.trim();
    }

    public String getFinalResponse() {
        return finalResponse;
    }

    public void setFinalResponse(String finalResponse) {
        this.finalResponse = finalResponse == null ? null : finalResponse.trim();
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams == null ? null : requestParams.trim();
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response == null ? null : response.trim();
    }
}