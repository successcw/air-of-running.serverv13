package com.successcw.emc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSetList
  implements Serializable
{
  public List<String> CONTENTID = new ArrayList();
  public List<String> Documentid = new ArrayList();
  public String ERROR = "";
  public String SUCCESS = "";
  public Map<String, List<String>> map = new HashMap();
  public List<String> nameList = new ArrayList();
  public String type;
  public List<String> valueList = new ArrayList();

  public Map<String, List<String>> getMap()
  {
    int i = this.nameList.size();
    //System.out.println("nameList size " + i);
    int j = 0;
    if (j >= i)
      return this.map;
    ArrayList localArrayList = new ArrayList();
    int k = j + 1;
    while (true)
    {
      if (k > this.valueList.size())
      {
        this.map.put((String)this.nameList.get(j), localArrayList);
        j++;
        break;
      }
      localArrayList.add((String)this.valueList.get(k - 1));
      k += i;
    }
    return this.map;
  }
}
