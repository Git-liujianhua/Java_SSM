package com.bjpowernode.vo;

public class QueryParam {
    private String paramName;
    private Integer paramAge;

    public QueryParam() {
    }
    public QueryParam(String paramName, Integer paramAge) {
        this.paramName = paramName;
        this.paramAge = paramAge;
    }
    public String getParamName() {
        return paramName;
    }
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
    public Integer getParamAge() {
        return paramAge;
    }
    public void setParamAge(Integer paramAge) {
        this.paramAge = paramAge;
    }
}
