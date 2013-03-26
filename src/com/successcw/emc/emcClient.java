package com.successcw.emc;

import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.successcw.nettool.NetTool;

public class emcClient {
	public static DataSetList getAQIByCityName(String CityName)throws Exception{
		try{
	        HttpURLConnection httpurlconnection;
	        DataSetList datasetlist;
	        httpurlconnection = null;
	        datasetlist = null;
	        String str = XmlPackage.packagSelect("from NewEMS_DataTemp where CityName='" + CityName + "'", "SEARCHYOUNGCONTENT");
			URL url = new URL("http://123.127.175.51:9080/IDOC/WebService");
	        httpurlconnection = (HttpURLConnection)url.openConnection();
	        httpurlconnection.setDoOutput(true);
	        httpurlconnection.setRequestMethod("POST");
	        httpurlconnection.setConnectTimeout(30000);
	        httpurlconnection.connect();
	        System.out.println((new StringBuilder("****************request xml==")).append(str).toString());
	        httpurlconnection.getOutputStream().write(str.toString().getBytes());
	        httpurlconnection.getOutputStream().flush();

	        httpurlconnection.getOutputStream().close();
	        String s2 = NetTool.convertStreamToString(httpurlconnection.getInputStream());
	        
	        XMLReader xmlreader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
	        XMLContentHandlerForList xmlcontenthandlerforlist = new XMLContentHandlerForList();
	        xmlreader.setContentHandler(xmlcontenthandlerforlist);
	        xmlreader.parse(new InputSource(new StringReader(s2)));
	        datasetlist = xmlcontenthandlerforlist.dataSet;
	        System.out.println(datasetlist.nameList.size());
	        for(int i = 0; i < datasetlist.nameList.size(); i++) {
	        	System.out.print(datasetlist.nameList.get(i)+"    ");
	        	System.out.println(datasetlist.valueList.get(i));
	        }
//	        Map<String, List<String>> localMap = datasetlist.getMap();
//	        System.out.println("size=" + localMap.get("JCZD_MC").size());
//	        for(int i = ((List)localMap.get("JCZD_MC")).size() - 1; i >= 0; i++) {
//	        	System.out.println(((List)localMap.get("JCZD_MC")).get(i));
//	        	System.out.println(((List)localMap.get("SO2")).get(i));
//	        }
	        

	        //System.out.println((new StringBuilder("*********reply xml =")).append(datasetlist.toString()).toString());
	        
	        return datasetlist;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
      }
}
