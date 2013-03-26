package com.successcw.emc;

public class XmlPackage {
	  public static String packagSelect(String paramString1, String paramString2)
	  {
	    StringBuffer localStringBuffer = new StringBuffer();
	    localStringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Envelope  xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">");
	    localStringBuffer.append("<Body><REQUEST><AUTHENTICATION><SERVERDEF><SERVERNAME>server</SERVERNAME></SERVERDEF><LOGONDATA>");
	    localStringBuffer.append("<USERNAME>" + "docadmin" + "</USERNAME><PASSWORD>" + "passw0rd" + "</PASSWORD ></LOGONDATA></AUTHENTICATION><COMMAND>" + paramString2 + "</COMMAND><DATA><SIMPLESEARCH>" + true + "</SIMPLESEARCH><CONTENTTYPENAME>" + "NewEMS_DataTemp" + "</CONTENTTYPENAME><QUERY>" + paramString1 + "</QUERY><RETENTIONDOC>true</RETENTIONDOC><CHECKDOCONLY>true</CHECKDOCONLY></DATA></REQUEST></Body></Envelope>");
	    return localStringBuffer.toString();
	  }
}
