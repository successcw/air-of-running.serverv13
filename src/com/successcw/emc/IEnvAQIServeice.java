package com.successcw.emc;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.1
 * 2013-01-08T13:47:17.415+08:00
 * Generated source version: 2.7.1
 * 
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "IEnvAQIServeice")
@XmlSeeAlso({ObjectFactory.class})
public interface IEnvAQIServeice {

    @WebResult(name = "GetAllAQIPublishLiveDataResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAllAQIPublishLiveData", output = "http://tempuri.org/IEnvAQIServeice/GetAllAQIPublishLiveDataResponse")
    @RequestWrapper(localName = "GetAllAQIPublishLiveData", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllAQIPublishLiveData")
    @WebMethod(operationName = "GetAllAQIPublishLiveData", action = "http://tempuri.org/IEnvAQIServeice/GetAllAQIPublishLiveData")
    @ResponseWrapper(localName = "GetAllAQIPublishLiveDataResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllAQIPublishLiveDataResponse")
    public com.successcw.emc.ArrayOfAQIDataPublishLiveInfo getAllAQIPublishLiveData();

    @WebResult(name = "GetAQIDataByCityNameResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAQIDataByCityName", output = "http://tempuri.org/IEnvAQIServeice/GetAQIDataByCityNameResponse")
    @RequestWrapper(localName = "GetAQIDataByCityName", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIDataByCityName")
    @WebMethod(operationName = "GetAQIDataByCityName", action = "http://tempuri.org/IEnvAQIServeice/GetAQIDataByCityName")
    @ResponseWrapper(localName = "GetAQIDataByCityNameResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIDataByCityNameResponse")
    public com.successcw.emc.ArrayOfAQIDataPublishLiveInfo getAQIDataByCityName(
        @WebParam(name = "CityName", targetNamespace = "http://tempuri.org/")
        java.lang.String cityName
    );

    @WebResult(name = "GetHistoryBySNandCODEResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetHistoryBySNandCODE", output = "http://tempuri.org/IEnvAQIServeice/GetHistoryBySNandCODEResponse")
    @RequestWrapper(localName = "GetHistoryBySNandCODE", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetHistoryBySNandCODE")
    @WebMethod(operationName = "GetHistoryBySNandCODE", action = "http://tempuri.org/IEnvAQIServeice/GetHistoryBySNandCODE")
    @ResponseWrapper(localName = "GetHistoryBySNandCODEResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetHistoryBySNandCODEResponse")
    public com.successcw.emc.ArrayOfAQIChartValue getHistoryBySNandCODE(
        @WebParam(name = "PositionName", targetNamespace = "http://tempuri.org/")
        java.lang.String positionName,
        @WebParam(name = "PollutantCode", targetNamespace = "http://tempuri.org/")
        java.lang.String pollutantCode
    );

    @WebResult(name = "GetAQIDayResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAQIDay", output = "http://tempuri.org/IEnvAQIServeice/GetAQIDayResponse")
    @RequestWrapper(localName = "GetAQIDay", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIDay")
    @WebMethod(operationName = "GetAQIDay", action = "http://tempuri.org/IEnvAQIServeice/GetAQIDay")
    @ResponseWrapper(localName = "GetAQIDayResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIDayResponse")
    public com.successcw.emc.ArrayOfAQIDayBll getAQIDay(
        @WebParam(name = "cityName", targetNamespace = "http://tempuri.org/")
        java.lang.String cityName
    );

    @WebResult(name = "PM2_5AndPM10Result", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/PM2_5AndPM10", output = "http://tempuri.org/IEnvAQIServeice/PM2_5AndPM10Response")
    @RequestWrapper(localName = "PM2_5AndPM10", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.PM25AndPM10")
    @WebMethod(operationName = "PM2_5AndPM10", action = "http://tempuri.org/IEnvAQIServeice/PM2_5AndPM10")
    @ResponseWrapper(localName = "PM2_5AndPM10Response", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.PM25AndPM10Response")
    public com.successcw.emc.ArrayOfAQIDataPublishLiveInfo pm25AndPM10(
        @WebParam(name = "ListOriData", targetNamespace = "http://tempuri.org/")
        com.successcw.emc.ArrayOfAQIDataPublishLiveInfo listOriData
    );

    @WebResult(name = "GetAllAQILiveDataResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAllAQILiveData", output = "http://tempuri.org/IEnvAQIServeice/GetAllAQILiveDataResponse")
    @RequestWrapper(localName = "GetAllAQILiveData", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllAQILiveData")
    @WebMethod(operationName = "GetAllAQILiveData", action = "http://tempuri.org/IEnvAQIServeice/GetAllAQILiveData")
    @ResponseWrapper(localName = "GetAllAQILiveDataResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllAQILiveDataResponse")
    public com.successcw.emc.ArrayOfAQIDataPublishLiveInfo getAllAQILiveData(
        @WebParam(name = "provinceName", targetNamespace = "http://tempuri.org/")
        java.lang.String provinceName
    );

    @WebResult(name = "GetCityNameByPNameResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetCityNameByPName", output = "http://tempuri.org/IEnvAQIServeice/GetCityNameByPNameResponse")
    @RequestWrapper(localName = "GetCityNameByPName", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetCityNameByPName")
    @WebMethod(operationName = "GetCityNameByPName", action = "http://tempuri.org/IEnvAQIServeice/GetCityNameByPName")
    @ResponseWrapper(localName = "GetCityNameByPNameResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetCityNameByPNameResponse")
    public com.successcw.emc.ArrayOfCityInfo getCityNameByPName(
        @WebParam(name = "provinceName", targetNamespace = "http://tempuri.org/")
        java.lang.String provinceName
    );

    @WebResult(name = "GetAQITipResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAQITip", output = "http://tempuri.org/IEnvAQIServeice/GetAQITipResponse")
    @RequestWrapper(localName = "GetAQITip", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQITip")
    @WebMethod(operationName = "GetAQITip", action = "http://tempuri.org/IEnvAQIServeice/GetAQITip")
    @ResponseWrapper(localName = "GetAQITipResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQITipResponse")
    public com.successcw.emc.ArrayOfKeyValueOfintstring getAQITip();

    @WebResult(name = "SetAQI24LayerResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/SetAQI24Layer", output = "http://tempuri.org/IEnvAQIServeice/SetAQI24LayerResponse")
    @RequestWrapper(localName = "SetAQI24Layer", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.SetAQI24Layer")
    @WebMethod(operationName = "SetAQI24Layer", action = "http://tempuri.org/IEnvAQIServeice/SetAQI24Layer")
    @ResponseWrapper(localName = "SetAQI24LayerResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.SetAQI24LayerResponse")
    public java.lang.Boolean setAQI24Layer(
        @WebParam(name = "param", targetNamespace = "http://tempuri.org/")
        java.lang.String param,
        @WebParam(name = "url", targetNamespace = "http://tempuri.org/")
        java.lang.String url
    );

    @WebResult(name = "GetAllHistoryByNameAndTimeResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAllHistoryByNameAndTime", output = "http://tempuri.org/IEnvAQIServeice/GetAllHistoryByNameAndTimeResponse")
    @RequestWrapper(localName = "GetAllHistoryByNameAndTime", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllHistoryByNameAndTime")
    @WebMethod(operationName = "GetAllHistoryByNameAndTime", action = "http://tempuri.org/IEnvAQIServeice/GetAllHistoryByNameAndTime")
    @ResponseWrapper(localName = "GetAllHistoryByNameAndTimeResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllHistoryByNameAndTimeResponse")
    public com.successcw.emc.ArrayOfKeyValueOfstringArrayOfAQIChartValueQi88CNAP getAllHistoryByNameAndTime(
        @WebParam(name = "PositionName", targetNamespace = "http://tempuri.org/")
        java.lang.String positionName,
        @WebParam(name = "PollutantCode", targetNamespace = "http://tempuri.org/")
        java.lang.String pollutantCode,
        @WebParam(name = "StartTime", targetNamespace = "http://tempuri.org/")
        java.lang.String startTime,
        @WebParam(name = "EndTime", targetNamespace = "http://tempuri.org/")
        java.lang.String endTime
    );

    @WebResult(name = "GetAQICityStationResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAQICityStation", output = "http://tempuri.org/IEnvAQIServeice/GetAQICityStationResponse")
    @RequestWrapper(localName = "GetAQICityStation", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQICityStation")
    @WebMethod(operationName = "GetAQICityStation", action = "http://tempuri.org/IEnvAQIServeice/GetAQICityStation")
    @ResponseWrapper(localName = "GetAQICityStationResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQICityStationResponse")
    public com.successcw.emc.ArrayOfAQICityStationInfo getAQICityStation(
        @WebParam(name = "CityName", targetNamespace = "http://tempuri.org/")
        java.lang.String cityName
    );

    @WebResult(name = "GetIaqiHistoryByNameAndTimeResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetIaqiHistoryByNameAndTime", output = "http://tempuri.org/IEnvAQIServeice/GetIaqiHistoryByNameAndTimeResponse")
    @RequestWrapper(localName = "GetIaqiHistoryByNameAndTime", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetIaqiHistoryByNameAndTime")
    @WebMethod(operationName = "GetIaqiHistoryByNameAndTime", action = "http://tempuri.org/IEnvAQIServeice/GetIaqiHistoryByNameAndTime")
    @ResponseWrapper(localName = "GetIaqiHistoryByNameAndTimeResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetIaqiHistoryByNameAndTimeResponse")
    public com.successcw.emc.ArrayOfKeyValueOfstringArrayOfAQIChartValueQi88CNAP getIaqiHistoryByNameAndTime(
        @WebParam(name = "PositionName", targetNamespace = "http://tempuri.org/")
        java.lang.String positionName,
        @WebParam(name = "PollutantCode", targetNamespace = "http://tempuri.org/")
        java.lang.String pollutantCode,
        @WebParam(name = "StartTime", targetNamespace = "http://tempuri.org/")
        java.lang.String startTime,
        @WebParam(name = "EndTime", targetNamespace = "http://tempuri.org/")
        java.lang.String endTime
    );

    @WebResult(name = "GetAQILayerHistoryResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAQILayerHistory", output = "http://tempuri.org/IEnvAQIServeice/GetAQILayerHistoryResponse")
    @RequestWrapper(localName = "GetAQILayerHistory", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQILayerHistory")
    @WebMethod(operationName = "GetAQILayerHistory", action = "http://tempuri.org/IEnvAQIServeice/GetAQILayerHistory")
    @ResponseWrapper(localName = "GetAQILayerHistoryResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQILayerHistoryResponse")
    public com.successcw.emc.ArrayOfAQILayerPublishHistoryInfo getAQILayerHistory(
        @WebParam(name = "PoID", targetNamespace = "http://tempuri.org/")
        java.lang.String poID
    );

    @WebResult(name = "SetIAQIPublishDataResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/SetIAQIPublishData", output = "http://tempuri.org/IEnvAQIServeice/SetIAQIPublishDataResponse")
    @RequestWrapper(localName = "SetIAQIPublishData", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.SetIAQIPublishData")
    @WebMethod(operationName = "SetIAQIPublishData", action = "http://tempuri.org/IEnvAQIServeice/SetIAQIPublishData")
    @ResponseWrapper(localName = "SetIAQIPublishDataResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.SetIAQIPublishDataResponse")
    public java.lang.Boolean setIAQIPublishData(
        @WebParam(name = "aqida", targetNamespace = "http://tempuri.org/")
        com.successcw.emc.ArrayOfIAQIDataPublishLiveInfo aqida
    );

    @WebResult(name = "GetAQIHistoryBySNResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAQIHistoryBySN", output = "http://tempuri.org/IEnvAQIServeice/GetAQIHistoryBySNResponse")
    @RequestWrapper(localName = "GetAQIHistoryBySN", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIHistoryBySN")
    @WebMethod(operationName = "GetAQIHistoryBySN", action = "http://tempuri.org/IEnvAQIServeice/GetAQIHistoryBySN")
    @ResponseWrapper(localName = "GetAQIHistoryBySNResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIHistoryBySNResponse")
    public com.successcw.emc.ArrayOfAQIDataPublishHistoryInfo getAQIHistoryBySN(
        @WebParam(name = "StationName", targetNamespace = "http://tempuri.org/")
        java.lang.String stationName
    );

    @WebResult(name = "SetAQIPublishDataResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/SetAQIPublishData", output = "http://tempuri.org/IEnvAQIServeice/SetAQIPublishDataResponse")
    @RequestWrapper(localName = "SetAQIPublishData", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.SetAQIPublishData")
    @WebMethod(operationName = "SetAQIPublishData", action = "http://tempuri.org/IEnvAQIServeice/SetAQIPublishData")
    @ResponseWrapper(localName = "SetAQIPublishDataResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.SetAQIPublishDataResponse")
    public java.lang.Boolean setAQIPublishData(
        @WebParam(name = "aqida", targetNamespace = "http://tempuri.org/")
        com.successcw.emc.ArrayOfAQIDataPublishLiveInfo aqida
    );

    @WebResult(name = "GetAllAQILayerURLResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAllAQILayerURL", output = "http://tempuri.org/IEnvAQIServeice/GetAllAQILayerURLResponse")
    @RequestWrapper(localName = "GetAllAQILayerURL", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllAQILayerURL")
    @WebMethod(operationName = "GetAllAQILayerURL", action = "http://tempuri.org/IEnvAQIServeice/GetAllAQILayerURL")
    @ResponseWrapper(localName = "GetAllAQILayerURLResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllAQILayerURLResponse")
    public com.successcw.emc.ArrayOfAQILayerPublishLiveInfo getAllAQILayerURL();

    @WebResult(name = "GetAllAQIStationResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAllAQIStation", output = "http://tempuri.org/IEnvAQIServeice/GetAllAQIStationResponse")
    @RequestWrapper(localName = "GetAllAQIStation", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllAQIStation")
    @WebMethod(operationName = "GetAllAQIStation", action = "http://tempuri.org/IEnvAQIServeice/GetAllAQIStation")
    @ResponseWrapper(localName = "GetAllAQIStationResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllAQIStationResponse")
    public com.successcw.emc.ArrayOfStationInfo getAllAQIStation();

    @WebResult(name = "GetAQILayerResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAQILayer", output = "http://tempuri.org/IEnvAQIServeice/GetAQILayerResponse")
    @RequestWrapper(localName = "GetAQILayer", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQILayer")
    @WebMethod(operationName = "GetAQILayer", action = "http://tempuri.org/IEnvAQIServeice/GetAQILayer")
    @ResponseWrapper(localName = "GetAQILayerResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQILayerResponse")
    public com.successcw.emc.AQILayerPublishLiveInfo getAQILayer(
        @WebParam(name = "PoID", targetNamespace = "http://tempuri.org/")
        java.lang.String poID
    );

    @WebResult(name = "GetAllAQIPublishResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAllAQIPublish", output = "http://tempuri.org/IEnvAQIServeice/GetAllAQIPublishResponse")
    @RequestWrapper(localName = "GetAllAQIPublish", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllAQIPublish")
    @WebMethod(operationName = "GetAllAQIPublish", action = "http://tempuri.org/IEnvAQIServeice/GetAllAQIPublish")
    @ResponseWrapper(localName = "GetAllAQIPublishResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllAQIPublishResponse")
    public com.successcw.emc.ArrayOfAQIDataPublishLiveInfo getAllAQIPublish();

    @WebResult(name = "UpDatePolConLimitsResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/UpDatePolConLimits", output = "http://tempuri.org/IEnvAQIServeice/UpDatePolConLimitsResponse")
    @RequestWrapper(localName = "UpDatePolConLimits", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.UpDatePolConLimits")
    @WebMethod(operationName = "UpDatePolConLimits", action = "http://tempuri.org/IEnvAQIServeice/UpDatePolConLimits")
    @ResponseWrapper(localName = "UpDatePolConLimitsResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.UpDatePolConLimitsResponse")
    public java.lang.Boolean upDatePolConLimits(
        @WebParam(name = "ListUpPolLimit", targetNamespace = "http://tempuri.org/")
        com.successcw.emc.ArrayOfAQIPollutantUpperLimitInfo listUpPolLimit
    );

    @WebResult(name = "GetStringUrlByTimeResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetStringUrlByTime", output = "http://tempuri.org/IEnvAQIServeice/GetStringUrlByTimeResponse")
    @RequestWrapper(localName = "GetStringUrlByTime", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetStringUrlByTime")
    @WebMethod(operationName = "GetStringUrlByTime", action = "http://tempuri.org/IEnvAQIServeice/GetStringUrlByTime")
    @ResponseWrapper(localName = "GetStringUrlByTimeResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetStringUrlByTimeResponse")
    public java.lang.String getStringUrlByTime(
        @WebParam(name = "param", targetNamespace = "http://tempuri.org/")
        java.lang.String param,
        @WebParam(name = "time", targetNamespace = "http://tempuri.org/")
        javax.xml.datatype.XMLGregorianCalendar time
    );

    @WebResult(name = "GetAQIHistoryResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAQIHistory", output = "http://tempuri.org/IEnvAQIServeice/GetAQIHistoryResponse")
    @RequestWrapper(localName = "GetAQIHistory", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIHistory")
    @WebMethod(operationName = "GetAQIHistory", action = "http://tempuri.org/IEnvAQIServeice/GetAQIHistory")
    @ResponseWrapper(localName = "GetAQIHistoryResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIHistoryResponse")
    public com.successcw.emc.ArrayOfAQIDataPublishHistoryInfo getAQIHistory(
        @WebParam(name = "stationCode", targetNamespace = "http://tempuri.org/")
        java.lang.String stationCode,
        @WebParam(name = "beginTime", targetNamespace = "http://tempuri.org/")
        javax.xml.datatype.XMLGregorianCalendar beginTime,
        @WebParam(name = "endTime", targetNamespace = "http://tempuri.org/")
        javax.xml.datatype.XMLGregorianCalendar endTime
    );

    @WebResult(name = "GetPolConLimitsResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetPolConLimits", output = "http://tempuri.org/IEnvAQIServeice/GetPolConLimitsResponse")
    @RequestWrapper(localName = "GetPolConLimits", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetPolConLimits")
    @WebMethod(operationName = "GetPolConLimits", action = "http://tempuri.org/IEnvAQIServeice/GetPolConLimits")
    @ResponseWrapper(localName = "GetPolConLimitsResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetPolConLimitsResponse")
    public com.successcw.emc.ArrayOfAQIPollutantUpperLimitInfo getPolConLimits();

    @WebResult(name = "GetIAQIPublishEtyByCityNameResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetIAQIPublishEtyByCityName", output = "http://tempuri.org/IEnvAQIServeice/GetIAQIPublishEtyByCityNameResponse")
    @RequestWrapper(localName = "GetIAQIPublishEtyByCityName", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetIAQIPublishEtyByCityName")
    @WebMethod(operationName = "GetIAQIPublishEtyByCityName", action = "http://tempuri.org/IEnvAQIServeice/GetIAQIPublishEtyByCityName")
    @ResponseWrapper(localName = "GetIAQIPublishEtyByCityNameResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetIAQIPublishEtyByCityNameResponse")
    public com.successcw.emc.ArrayOfIAQIDataPublishLiveEty getIAQIPublishEtyByCityName(
        @WebParam(name = "CityName", targetNamespace = "http://tempuri.org/")
        java.lang.String cityName
    );

    @WebResult(name = "GetAQIDataResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAQIData", output = "http://tempuri.org/IEnvAQIServeice/GetAQIDataResponse")
    @RequestWrapper(localName = "GetAQIData", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIData")
    @WebMethod(operationName = "GetAQIData", action = "http://tempuri.org/IEnvAQIServeice/GetAQIData")
    @ResponseWrapper(localName = "GetAQIDataResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIDataResponse")
    public com.successcw.emc.ArrayOfAQIDataPublishLiveInfo getAQIData();

    @WebResult(name = "GetAQIPublishByTimeResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAQIPublishByTime", output = "http://tempuri.org/IEnvAQIServeice/GetAQIPublishByTimeResponse")
    @RequestWrapper(localName = "GetAQIPublishByTime", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIPublishByTime")
    @WebMethod(operationName = "GetAQIPublishByTime", action = "http://tempuri.org/IEnvAQIServeice/GetAQIPublishByTime")
    @ResponseWrapper(localName = "GetAQIPublishByTimeResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIPublishByTimeResponse")
    public com.successcw.emc.ArrayOfAQIDataPublishHistoryInfo getAQIPublishByTime(
        @WebParam(name = "time", targetNamespace = "http://tempuri.org/")
        javax.xml.datatype.XMLGregorianCalendar time
    );

    @WebResult(name = "GetCNByPNameResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetCNByPName", output = "http://tempuri.org/IEnvAQIServeice/GetCNByPNameResponse")
    @RequestWrapper(localName = "GetCNByPName", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetCNByPName")
    @WebMethod(operationName = "GetCNByPName", action = "http://tempuri.org/IEnvAQIServeice/GetCNByPName")
    @ResponseWrapper(localName = "GetCNByPNameResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetCNByPNameResponse")
    public com.successcw.emc.ArrayOfCityInfo getCNByPName(
        @WebParam(name = "provinceName", targetNamespace = "http://tempuri.org/")
        java.lang.String provinceName
    );

    @WebResult(name = "UpdateLayerUrlResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/UpdateLayerUrl", output = "http://tempuri.org/IEnvAQIServeice/UpdateLayerUrlResponse")
    @RequestWrapper(localName = "UpdateLayerUrl", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.UpdateLayerUrl")
    @WebMethod(operationName = "UpdateLayerUrl", action = "http://tempuri.org/IEnvAQIServeice/UpdateLayerUrl")
    @ResponseWrapper(localName = "UpdateLayerUrlResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.UpdateLayerUrlResponse")
    public java.lang.Boolean updateLayerUrl(
        @WebParam(name = "paramName", targetNamespace = "http://tempuri.org/")
        java.lang.String paramName,
        @WebParam(name = "layerUrl", targetNamespace = "http://tempuri.org/")
        java.lang.String layerUrl
    );

    @WebResult(name = "GetStringUrlResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetStringUrl", output = "http://tempuri.org/IEnvAQIServeice/GetStringUrlResponse")
    @RequestWrapper(localName = "GetStringUrl", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetStringUrl")
    @WebMethod(operationName = "GetStringUrl", action = "http://tempuri.org/IEnvAQIServeice/GetStringUrl")
    @ResponseWrapper(localName = "GetStringUrlResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetStringUrlResponse")
    public java.lang.String getStringUrl(
        @WebParam(name = "param", targetNamespace = "http://tempuri.org/")
        java.lang.String param
    );

    @WebResult(name = "GetCityNameByPIDResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetCityNameByPID", output = "http://tempuri.org/IEnvAQIServeice/GetCityNameByPIDResponse")
    @RequestWrapper(localName = "GetCityNameByPID", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetCityNameByPID")
    @WebMethod(operationName = "GetCityNameByPID", action = "http://tempuri.org/IEnvAQIServeice/GetCityNameByPID")
    @ResponseWrapper(localName = "GetCityNameByPIDResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetCityNameByPIDResponse")
    public com.successcw.emc.ArrayOfCityInfo getCityNameByPID(
        @WebParam(name = "pid", targetNamespace = "http://tempuri.org/")
        java.lang.Integer pid
    );

    @WebResult(name = "GetAQIPublishStationResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAQIPublishStation", output = "http://tempuri.org/IEnvAQIServeice/GetAQIPublishStationResponse")
    @RequestWrapper(localName = "GetAQIPublishStation", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIPublishStation")
    @WebMethod(operationName = "GetAQIPublishStation", action = "http://tempuri.org/IEnvAQIServeice/GetAQIPublishStation")
    @ResponseWrapper(localName = "GetAQIPublishStationResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAQIPublishStationResponse")
    public com.successcw.emc.ArrayOfAQICityInfo getAQIPublishStation();

    @WebResult(name = "GetHistoryByNameAndTimeResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetHistoryByNameAndTime", output = "http://tempuri.org/IEnvAQIServeice/GetHistoryByNameAndTimeResponse")
    @RequestWrapper(localName = "GetHistoryByNameAndTime", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetHistoryByNameAndTime")
    @WebMethod(operationName = "GetHistoryByNameAndTime", action = "http://tempuri.org/IEnvAQIServeice/GetHistoryByNameAndTime")
    @ResponseWrapper(localName = "GetHistoryByNameAndTimeResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetHistoryByNameAndTimeResponse")
    public com.successcw.emc.ArrayOfAQIChartValue getHistoryByNameAndTime(
        @WebParam(name = "PositionName", targetNamespace = "http://tempuri.org/")
        java.lang.String positionName,
        @WebParam(name = "PollutantCode", targetNamespace = "http://tempuri.org/")
        java.lang.String pollutantCode,
        @WebParam(name = "StartTime", targetNamespace = "http://tempuri.org/")
        java.lang.String startTime,
        @WebParam(name = "EndTime", targetNamespace = "http://tempuri.org/")
        java.lang.String endTime
    );

    @WebResult(name = "GetCityStationResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetCityStation", output = "http://tempuri.org/IEnvAQIServeice/GetCityStationResponse")
    @RequestWrapper(localName = "GetCityStation", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetCityStation")
    @WebMethod(operationName = "GetCityStation", action = "http://tempuri.org/IEnvAQIServeice/GetCityStation")
    @ResponseWrapper(localName = "GetCityStationResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetCityStationResponse")
    public com.successcw.emc.ArrayOfAQIDataPublishLiveInfo getCityStation(
        @WebParam(name = "pid", targetNamespace = "http://tempuri.org/")
        java.lang.Integer pid
    );

    @WebResult(name = "GetAllIAQIPublishEtyResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetAllIAQIPublishEty", output = "http://tempuri.org/IEnvAQIServeice/GetAllIAQIPublishEtyResponse")
    @RequestWrapper(localName = "GetAllIAQIPublishEty", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllIAQIPublishEty")
    @WebMethod(operationName = "GetAllIAQIPublishEty", action = "http://tempuri.org/IEnvAQIServeice/GetAllIAQIPublishEty")
    @ResponseWrapper(localName = "GetAllIAQIPublishEtyResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetAllIAQIPublishEtyResponse")
    public com.successcw.emc.ArrayOfIAQIDataPublishLiveEty getAllIAQIPublishEty();

    @WebResult(name = "GetDataResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetData", output = "http://tempuri.org/IEnvAQIServeice/GetDataResponse")
    @RequestWrapper(localName = "GetData", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetData")
    @WebMethod(operationName = "GetData", action = "http://tempuri.org/IEnvAQIServeice/GetData")
    @ResponseWrapper(localName = "GetDataResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetDataResponse")
    public com.successcw.emc.ArrayOfAQILayerPublishHistoryInfo getData(
        @WebParam(name = "IndicatorCode", targetNamespace = "http://tempuri.org/")
        java.lang.String indicatorCode
    );

    @WebResult(name = "GetPidResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IEnvAQIServeice/GetPid", output = "http://tempuri.org/IEnvAQIServeice/GetPidResponse")
    @RequestWrapper(localName = "GetPid", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetPid")
    @WebMethod(operationName = "GetPid", action = "http://tempuri.org/IEnvAQIServeice/GetPid")
    @ResponseWrapper(localName = "GetPidResponse", targetNamespace = "http://tempuri.org/", className = "com.successcw.emc.GetPidResponse")
    public java.lang.Integer getPid(
        @WebParam(name = "cityname", targetNamespace = "http://tempuri.org/")
        java.lang.String cityname
    );
}