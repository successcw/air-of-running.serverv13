package com.successcw.nettool;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {

	String elementValue = null;
	Boolean elementOn = false;
	public static XMLGettersSetters data = null;

	public static XMLGettersSetters getXMLData() {
		return data;
	}

	public static void setXMLData(XMLGettersSetters data) {
		XMLHandler.data = data;
	}

	/** 
	 * This will be called when the tags of the XML starts.
	 **/
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		elementOn = true;

		//System.out.println("startElement");
		//System.out.println(qName);
		if (qName.equals("weather"))
		{
			//System.out.println("get weather");
			data = new XMLGettersSetters();
			data.setDescription(attributes.getValue("pubdate"));
		} 
		if (qName.equals("condition"))
		{
			//System.out.println("get condition");
			data.setDescription(attributes.getValue("temp"));
			data.setDescription(attributes.getValue("wind"));
		}
		if (qName.equals("foreca"))
		{
			//System.out.println("get foreca");
			data.setDescription(attributes.getValue("text"));
			data.setDescription(attributes.getValue("high"));
			data.setDescription(attributes.getValue("low"));
			data.setDescription(attributes.getValue("code2"));
			data.setDescription(attributes.getValue("date"));
		}
	}

	/** 
	 * This will be called when the tags of the XML end.
	 **/
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		elementOn = false;

		/** 
		 * Sets the values after retrieving the values from the XML tags
		 * */ 
		if (qName.equalsIgnoreCase("condition")) {
			
			//Log.i("XML", "get condition");
			//data.setDescription(elementValue);
		}
	}

	/** 
	 * This is called to get the tags value
	 **/
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		if (elementOn) {
			elementValue = new String(ch, start, length);
			elementOn = false;
		}

	}

}
