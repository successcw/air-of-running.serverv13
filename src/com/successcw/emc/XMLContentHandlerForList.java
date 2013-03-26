package com.successcw.emc;

import java.io.PrintStream;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLContentHandlerForList extends DefaultHandler
{
  public DataSetList dataSet = new DataSetList();
  private boolean flag = false;
  int nameCounter = 0;
  private int nodeCount;
  private String tagName;
  private String temp = "";
  int valueCounter = 0;

  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws SAXException
  {
    this.flag = false;
    if (this.tagName.equals("DOCUMENTID"))
      this.dataSet.Documentid.add(new String(paramArrayOfChar, paramInt1, paramInt2));

//      if (this.tagName.equals("CONTENTTYPENAME"))
//      {
//        this.dataSet.type = new String(paramArrayOfChar, paramInt1, paramInt2);
//        continue;
//      }
//      if (this.tagName.equals("CONTENTID"))
//      {
//        this.temp += new String(paramArrayOfChar, paramInt1, paramInt2);
//        continue;
//      }
//      if (this.tagName.equals("NODETYPENAME"))
//      {
//        this.temp += new String(paramArrayOfChar, paramInt1, paramInt2);
//        this.nodeCount = (1 + this.nodeCount);
//        continue;
//      }
      if (this.tagName.equals("NAME"))
      {
        this.temp = new String(paramArrayOfChar, paramInt1, paramInt2);
        //System.out.print(this.temp + "   ");
      }
      if (this.tagName.equals("VALUE"))
      {
        this.temp = new String(paramArrayOfChar, paramInt1, paramInt2);
        //System.out.println(this.temp);
      }
//      if (!this.tagName.equals("ERROR"))
//        continue;
//      this.dataSet.valueList.add("出错了");

  }

  public void endDocument()
    throws SAXException
  {
    System.out.println("nameCounter" + this.nameCounter);
    System.out.println("valueCounter" + this.valueCounter);
  }

  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
	  //System.out.println("endElement paramString1"+ paramString1 + "paramString2=" + paramString2 + "paramString3=" + paramString3);
    this.tagName = paramString3;
    
    if (this.tagName.equals("NAME"))
    {
    	this.dataSet.nameList.add(this.temp);
    }
    if (this.tagName.equals("VALUE"))
    {
    	this.dataSet.valueList.add(this.temp);
    }
  }

  public void startDocument()
    throws SAXException
  {
  }

  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    this.tagName = paramString3;
    //System.out.println(this.tagName);
    this.flag = true;
  }
}