
package com.successcw.emc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BaseEntity complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BaseEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseEntity", namespace = "http://schemas.datacontract.org/2004/07/Fundway.Env.DataAccess")
@XmlSeeAlso({
    CityInfo.class,
    IAQIDataPublishLiveInfo.class,
    AQICityStationInfo.class,
    AQILayerPublishHistoryInfo.class,
    AQIDataPublishLiveInfo.class,
    StationInfo.class,
    AQIDataPublishHistoryInfo.class,
    AQICityInfo.class,
    AQIPollutantUpperLimitInfo.class,
    AQILayerPublishLiveInfo.class
})
public class BaseEntity {


}
