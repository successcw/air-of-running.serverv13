package com.successcw.cloudservice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.successcw.emc.AQIDataPublishLiveInfo;
import com.successcw.emc.ArrayOfAQIDataPublishLiveInfo;
import com.successcw.emc.EnvAQIServeice;
import com.successcw.emc.IEnvAQIServeice;
import com.successcw.mysql.mysqlService;
import com.successcw.nettool.NetTool;


public class airofrunning extends HttpServlet {
	private Timer timer2;
	private datastoreTimer datastore;
	private String[] cityWeather = {
		"CHXX0008",
		"CHXX0133",
		"CHXX0122",
		"WMXX1038",
		"WMXX1037",
		"CHXX0266",
		"CHXX0308",
		"CHXX0302",
		"WMXX1041",
		"CHXX0300",
		"WMXX1039",
		"CHXX0131",
		"WMXX1040",
		"CHXX0129",
		"CHXX0249",
		"CHXX0119",
		"CHXX0019",
		"CHXX0010",
		"CHXX0046",
		"CHXX0116",
		"CHXX0099",
		"WMXX1009",
		"CHXX0437",
		"CHXX0015",
		"WMXX1007",
		"CHXX0101",
		"WMXX1012",
		"WMXX1011",
		"WMXX1014",
		"WMXX1013",
		"CHXX0166",
		"WMXX1008",
		"WMXX1010",
		"CHXX0044",
		"WMXX1016",
		"CHXX0462",
		"CHXX0062",
		"CHXX0056",
		"CHXX0460",
		"CHXX0455",
		"WMXX1263",
		"CHXX0461",
		"CHXX0117",
		"WMXX1017",
		"CHXX0448",
		"CHXX0031",
		"CHXX0140",
		"CHXX0097",
		"CHXX0064",
		"CHXX0110",
		"CHXX0165",
		"CHXX0138",
		"CHXX0013",
		"CHXX0037",
		"CHXX0120",
		"WMXX1000",
		"CHXX0028",
		"CHXX0058",
		"WMXX1003",
		"CHXX0053",
		"CHXX0123",
		"WMXX1002",
		"CHXX0100",
		"CHXX0502",
		"CHXX0017",
		"CHXX0016",
		"CHXX0039",
		"CHXX0076",
		"CHXX0080",
		"CHXX0141",
		"CHXX0079",
		"CHXX0236",
		"CHXX0259",
		"CHXX0135"
	};
	private String[] city = {
		"北京",
		"天津",
		"石家庄",
		"秦皇岛",
		"邯郸",
		"邢台",
		"保定",
		"承德",
		"衡水",
		"张家口",
		"廊坊",
		"唐山",
		"沧州",
		"太原",
		"呼和浩特",
		"沈阳",
		"大连",
		"长春",
		"哈尔滨",
		"上海",
		"南京",
		"无锡",
		"徐州",
		"常州",
		"苏州",
		"南通",
		"连云港",
		"淮安",
		"盐城",
		"扬州",
		"镇江",
		"泰州",
		"宿迁",
		"杭州",
		"宁波",
		"温州",
		"嘉兴",
		"湖州",
		"衢州",
		"舟山",
		"台州",
		"丽水",
		"绍兴",
		"金华",
		"合肥",
		"福州",
		"厦门",
		"南昌",
		"济南",
		"青岛",
		"郑州",
		"武汉",
		"长沙",
		"广州",
		"深圳",
		"珠海",
		"佛山",
		"江门",
		"肇庆",
		"惠州",
		"东莞",
		"中山",
		"南宁",
		"海口",
		"重庆",
		"成都",
		"贵阳",
		"昆明",
		"拉萨",
		"西安",
		"兰州",
		"西宁",
		"银川",
		"乌鲁木齐"
	};
	private String[] beijingStation = {
        "永定门内",
        "榆垡",
        "植物园",
        "丰台花园",
        "顺义",
        "延庆",
        "平谷",
        "房山",
        "亦庄",
        "云岗",
        "密云水库",
        "怀柔",
        "八达岭",
        "万寿西宫",
        "昌平",
        "门头沟",
        "通州",
        "大兴",
        "定陵",
        "前门",
        "东四",
        "天坛",
        "奥体中心",
        "农展馆",
        "密云",
        "古城",
        "官园",
        "南三环",
        "北部新区",
        "万柳",
        "永乐店",
        "琉璃河",
        "东高村",
        "东四环",
        "西直门北"
	};
	private String[] beijingStationUnicode = {
		"\u6c38\u5b9a\u95e8\u5185",
		"\u6986\u57a1",
		"\u690d\u7269\u56ed",
		"\u4e30\u53f0\u82b1\u56ed",
		"\u987a\u4e49",
		"\u5ef6\u5e86",
		"\u5e73\u8c37",
		"\u623f\u5c71",
		"\u4ea6\u5e84",
		"\u4e91\u5c97",
		"\u5bc6\u4e91\u6c34\u5e93",
		"\u6000\u67d4",
		"\u516b\u8fbe\u5cad",
		"\u4e07\u5bff\u897f\u5bab",
		"\u660c\u5e73",
		"\u95e8\u5934\u6c9f",
		"\u901a\u5dde",
		"\u5927\u5174",
		"\u5b9a\u9675",
		"\u524d\u95e8",
		"\u4e1c\u56db",
		"\u5929\u575b",
		"\u5965\u4f53\u4e2d\u5fc3",
		"\u519c\u5c55\u9986",
		"\u5bc6\u4e91",
		"\u53e4\u57ce",
		"\u5b98\u56ed",
		"\u5357\u4e09\u73af",
		"\u5317\u90e8\u65b0\u533a",
		"\u4e07\u67f3",
		"\u6c38\u4e50\u5e97",
		"\u7409\u7483\u6cb3",
		"\u4e1c\u9ad8\u6751",
		"\u4e1c\u56db\u73af",
		"\u897f\u76f4\u95e8\u5317"
	};
	private String[] SHStation = {
			"上海平均",
			"普陀监测站",
			"杨浦四漂",
			"卢湾师专附小",
			"青浦淀山湖",
			"虹口凉城",
			"静安监测站",
			"徐汇上师大",
			"浦东川沙",
			"浦东监测站",
			"浦东张江"
	};
	private int[] SHStationValue = {
			0,
			201,
			209,
			185,
			203,
			215,
			183,
			207,
			193,
			228,
			195
	};
	public static Integer TryParseInt(String str) {
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException ex) {
            return null;
        }
	}
	
	 public static String toUnicode(String s) {
		 String s1 = "";
		 for (int i = 0; i < s.length(); i++) {
			 s1 +="\\u" +  Integer.toHexString(s.charAt(i) & 0xffff);
		 }
		 return s1;
	 }

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		ArrayList<String> WEATHER = null;
		int averageAQI = 0;
		int count = 0;
		String beijingAQI;
		String beijingPM25;
		int reqCity;
		int reqStation;
		String USAQI = "";
		String SHAQI = "";
		mysqlService mysql = new mysqlService();

		if(req.getParameter("city") == null && req.getParameter("download") == null && req.getParameter("checkNewVersion") == null) {
		
			resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");
		    PrintWriter out = resp.getWriter();;
		    String srvInfo = System.getenv("VCAP_SERVICES");

		    out.println("<html>");
		    out.println("<head><title>demolet</title></head>");
		    out.println("<body>");
		    out.println("<p>hello,world!.</p>");
		    out.println("<p>");
		    //out.println(srvInfo);
		    out.println("</p>");
		    out.println("</body></html>");
		    out.close();
		} else if(req.getParameter("checkNewVersion") != null) {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");
		    PrintWriter out = resp.getWriter();
		    out.print("{\"versionCode\":\"4\",\"versionName\":\"1.3\",\"contents\":\"" +
		    		"1.大幅提升载入速度;2.加入自动更新机制;3.调整出错UI;4.添加“关于”界面\"}");
		} else if(req.getParameter("download") != null){
			
			 //写流文件到前端浏览器
		    ServletOutputStream out = resp.getOutputStream();
		    resp.setHeader("Content-disposition", "attachment;filename=AirofRunning.apk");
		    BufferedInputStream bis = null;
		    BufferedOutputStream bos = null;
		    try {
		      bis = new BufferedInputStream(mysql.getFile());
		      bos = new BufferedOutputStream(out);
		      byte[] buff = new byte[2048];
		      int bytesRead;
		      while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
		        bos.write(buff, 0, bytesRead);
		      }
		    } catch (IOException e) {
		      throw e;
		    } finally {
		      if (bis != null)
		        bis.close();
		      if (bos != null)
		        bos.close();
		    }
		} else if(req.getParameter("city") != null && req.getParameter("station") != null) {

			resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");
			reqCity = Integer.valueOf(req.getParameter("city"));
			reqStation = Integer.valueOf(req.getParameter("station"));
		    PrintWriter out = resp.getWriter();
		    String[] resultSet = null;

		    try {
			    resultSet = mysql.getFromDatabase(reqCity, reqStation);
	
				out.print("{\"SHISHITEMPRATURE\":\"");
				out.print(resultSet[0]);
				out.print("\",");
				out.print("\"AIRCONDITION\":\"");
				out.print(resultSet[1]);
				out.print("\",");
				out.print("\"TEMPRATURE\":\"");	
				out.print(resultSet[2]);
				out.print("\",");
				out.print("\"WIND\":\"");	
				out.print(resultSet[3]);
				out.print("\",");
				out.print("\"WEATHERICON\":\"");
				out.print(resultSet[4]);
				out.print("\",");
				out.print("\"TEMPRATUREUPDATETIME\":\"");	
				out.print(resultSet[5]);
				out.print("\",");
				out.print("\"WEATHERFORECASE\":\"");	
				out.print(resultSet[6]);
				out.print("\",");
				
				out.print("\"USAQIVALUE\":\"");
				out.print(resultSet[7]);
				out.print("\",");
				out.print("\"USAQITIME\":\"");
				out.print(resultSet[8]);
				out.print("\",");
				
				out.print("\"averageAQI\":\"");
				out.print(resultSet[9]);
				out.print("\",");
				out.print("\"AQI\":\"");
				out.print(resultSet[10]);
				out.print("\",");
				out.print("\"time\":\"");
				out.print(resultSet[11]);
				out.print("\",");
				out.print("\"station\":\"");
				out.print(resultSet[12]);
				out.print("\",");
				out.print("\"quality\":\"");
				out.print(resultSet[13]);
				out.print("\",");
				out.print("\"PM2_5\":\"");	      	
				out.print(resultSet[14]);
				out.print("\",");
				out.print("\"area\":\"");
				out.print(resultSet[15]);
				out.print("\"}");
				out.close();
				
			}catch(Exception e){
				out.println(e.toString());
			}
		}
	}
    public void initDatabase() {
		int averageAQI = 0;
		int count = 0;
		String beijingAQI;
		String beijingPM25;
		int reqCity;
		int reqStation = 0;
		String USAQI = "";
		String SHAQI = "";
		String SQL = "";
		mysqlService mysql = new mysqlService();

		Calendar rightNow = Calendar.getInstance();
		Date time = rightNow.getTime();
		//System.out.println("start update");
		//System.out.println(time.toString());
		try {
			//获取北京空气信息
			beijingAQI = NetTool.getHtml("http://zx.bjmemc.com.cn/ashx/Data.ashx?Action=GetAQIClose1h", "UTF-8");
			JSONArray jsonObjRecv = new JSONArray(beijingAQI);			
			if(beijingAQI == null){
				SQL = "INSERT INTO airQuality (cityIndex, stationIndex, USAQIVALUE, USAQITIME, averageAQI, AQI, time, station, quality, PM2_5, area) " +
						"VALUES(1, 0, -9999, '-9999', -9999, -9999, '-9999', '-9999', '-9999', -9999, '北京')";
				mysql.executeSQL(SQL);
			} else {
				for(int i = 0; i < jsonObjRecv.length(); i++ ) {
					for(int j = 0; j < beijingStationUnicode.length; j++)
					{
						if(jsonObjRecv.getJSONObject(i).getString("StationName").equals(beijingStationUnicode[j])) {
							reqStation = j;
							break;
						}
					}
					beijingPM25 = 
							NetTool.getHtml("http://zx.bjmemc.com.cn/ashx/Data.ashx?Action=GetChartData_ByStationAndWRWType&StationName="
									+ beijingStation[reqStation] + "&WRWType=pm2.5","UTF-8");
					if(beijingPM25 == null) {
						beijingPM25 = "-9999";
					} else {										
						JSONObject jsonobjRecvPM25 = new JSONObject(beijingPM25);
						int length = jsonobjRecvPM25.getJSONArray("Datas").length();
						//取最近一个存在的pm2.5值
						for(int k = length -1; k >= 0; k--) {
							beijingPM25 = jsonobjRecvPM25.getJSONArray("Datas").getJSONObject(k).get("Value").toString();
							if(!(beijingPM25.equals("") || beijingPM25.equals("-9999")))
								break;
						}
					}
					Integer AQI = TryParseInt(jsonObjRecv.getJSONObject(i).getString("AQIValue"));
					if (AQI == null)
						AQI = -9999;
					float PM2_5;
					try{
						PM2_5 = Float.parseFloat(beijingPM25);
					} catch(NumberFormatException e){
						PM2_5 = -9999;
					} 
					SQL = "INSERT INTO airQuality (cityIndex, stationIndex, USAQIVALUE, USAQITIME,averageAQI, AQI, time, station, quality, PM2_5, area) " +
							"VALUES(1, " + 
							i + ",-9999, '-9999', -9999," +
							AQI + "," + "'" +
							jsonObjRecv.getJSONObject(i).getString("Time").split(" ")[1] + "'" + "," + "'" +
							jsonObjRecv.getJSONObject(i).getString("StationName") + "'" + "," + "'" +
							jsonObjRecv.getJSONObject(i).getString("Quality")  + "'" + "," +
							PM2_5 + "," +
							"'北京')";
					mysql.executeSQL(SQL);
					
				}		
			}
			//获取上海信息
			for (int i = 0; i < SHStationValue.length; i++) {
				SHAQI= NetTool.getSHAQI("GetSiteAQIData",SHStationValue[i]);
				if(SHAQI == null){
					SQL = "INSERT INTO airQuality (cityIndex, stationIndex,averageAQI, AQI, time, station, quality, PM2_5, area) " +
							"VALUES(20, 0 , -9999, '-9999', -9999, -9999, '-9999', '-9999', '-9999', -9999, '上海')";
				}
				else {
					SHAQI = SHAQI.replace("$", " ").replace("#", " ").replace("*"," ");
					String []SHAQIArray = SHAQI.split(" ");
					
					Integer AQI = TryParseInt(SHAQIArray[1]);
					if (AQI == null)
						AQI = -9999;
					float PM2_5;
					try{
						PM2_5 = Float.parseFloat(SHAQIArray[SHAQIArray.length - 6]);
					} catch(NumberFormatException e){
						PM2_5 = -9999;
					} 
										
					SQL = "INSERT INTO airQuality (cityIndex, stationIndex, USAQIVALUE, USAQITIME,averageAQI, AQI, time, station, quality, PM2_5, area) " +
							"VALUES(20, " + 
							i + ",-9999, '-9999', -9999," +
							AQI + "," + "'" +
							SHAQIArray[SHAQIArray.length - 1].toString() + "'" + "," + "'" +
							SHStation[i] + "'" + "," + "'" +
							SHAQIArray[SHAQIArray.length - 3].toString()  + "'" + "," +
							PM2_5 + "," +
							"'上海')";
				}
				mysql.executeSQL(SQL);
			}
			//获取全国信息
			//other cities
			
			for (int i = 0; i < city.length; i++) {
				if(i == 0 || i == 19) {
					//nothing here
				}
				else {
					EnvAQIServeice emc = new EnvAQIServeice();
					IEnvAQIServeice client = emc.getBasicHttpBindingIEnvAQIServeice();
					ArrayOfAQIDataPublishLiveInfo o = client.getAQIDataByCityName(city[i]);
					List<AQIDataPublishLiveInfo> strList = o.getAQIDataPublishLiveInfo();
				      
			
					for(int j = 0; j < strList.size(); j++) {
						Integer temp = TryParseInt(strList.get(j).getAQI().getValue());
						if (temp != null) {
							averageAQI+= Integer.valueOf(temp);
							count++;
						}
					}
		
					for(int j = 0; j < strList.size(); j++) {
						Integer AQI = TryParseInt(strList.get(j).getAQI().getValue());
						if (AQI == null)
							AQI = -9999;
						float PM2_5;
						try{
							PM2_5 = Float.parseFloat(strList.get(j).getPM25().getValue());
						} catch(NumberFormatException e){
							PM2_5 = -9999;
						}
						int temp = i + 1;
						SQL = "INSERT INTO airQuality (cityIndex, stationIndex, USAQIVALUE, USAQITIME, averageAQI, AQI, time, station, quality, PM2_5, area) " +
								"VALUES(" +
								temp + "," +
								j + ",-9999, '-9999'," +
								averageAQI/count + "," +
								AQI + "," + "'" +
								strList.get(j).getTimePoint().toString().split("T")[1] + "'" + "," + "'" +
								strList.get(j).getPositionName().getValue() + "'" + "," + "'" +
								strList.get(j).getQuality().getValue()  + "'" + "," +
								PM2_5 + "," + "'" +
								strList.get(j).getArea().getValue() + "')";
						mysql.executeSQL(SQL);
					}
				}
			}
			rightNow = Calendar.getInstance();
			time = rightNow.getTime();
			//System.out.println("end update");
			//System.out.println(time.toString());
			
			//获取美国大使馆空气信息
			USAQI = NetTool.getHtml("http://www.aqicn.info/?json&key=v5&city=beijing", "UTF-8");
			if(USAQI == null){
				//nothing to do here
			}
			else {
				JSONObject jsonObjUSAQI = new JSONObject(USAQI);
				SQL = "UPDATE airQuality SET USAQIVALUE=" +
						Integer.valueOf(jsonObjUSAQI.getString("aqi")) + ",USAQITIME='" + 
						jsonObjUSAQI.getJSONObject("time").getString("u").split(" ")[1] + "'" + 
						"WHERE area='北京'";
				mysql.executeSQL(SQL);
			}
			USAQI = NetTool.getHtml("http://www.aqicn.info/?json&key=v5&city=shanghai", "UTF-8");
			if(USAQI == null){
				//nothing to do here
			}
			else {
				JSONObject jsonObjUSAQI = new JSONObject(USAQI);
				SQL = "UPDATE airQuality SET USAQIVALUE=" +
						Integer.valueOf(jsonObjUSAQI.getString("aqi")) + ",USAQITIME='" + 
						jsonObjUSAQI.getJSONObject("time").getString("u").split(" ")[1] + "'" + 
						"WHERE area='上海'";
				mysql.executeSQL(SQL);
			}
			USAQI = NetTool.getHtml("http://www.aqicn.info/?json&key=v5&city=guangzhou", "UTF-8");
			if(USAQI == null){
				//nothing to do here
			}
			else {
				JSONObject jsonObjUSAQI = new JSONObject(USAQI);
				SQL = "UPDATE airQuality SET USAQIVALUE=" +
						Integer.valueOf(jsonObjUSAQI.getString("aqi")) + ",USAQITIME='" + 
						jsonObjUSAQI.getJSONObject("time").getString("u").split(" ")[1] + "'" + 
						"WHERE area='广州'";
				mysql.executeSQL(SQL);
			}
			USAQI = NetTool.getHtml("http://www.aqicn.info/?json&key=v5&city=chengdu", "UTF-8");
			if(USAQI == null){
				//nothing to do here
			}
			else {
				JSONObject jsonObjUSAQI = new JSONObject(USAQI);
				SQL = "UPDATE airQuality SET USAQIVALUE=" +
						Integer.valueOf(jsonObjUSAQI.getString("aqi")) + ",USAQITIME='" + 
						jsonObjUSAQI.getJSONObject("time").getString("u").split(" ")[1] + "'" + 
						"WHERE area='成都'";
				mysql.executeSQL(SQL);
			}
			
			
			//获取全国天气信息
	    	ArrayList<String> WEATHER = null;
	    	for(int i = 0; i < cityWeather.length; i++) {
	    		WEATHER = NetTool.getWeatherFromSina(cityWeather[i]);
	    		if(WEATHER == null) {
					SQL = "UPDATE airQuality SET SHISHITEMPRATURE='-9999',AIRCONDITION='-9999',TEMPRATURE='-9999',WIND='-9999'," +
							"WEATHERICON='32', TEMPRATUREUPDATETIME='-9999',  WEATHERFORECASE='-9999' WHERE area='" +
							city[i] + "'";
	    		}
	    		else
	    		{
	    			if(WEATHER.get(3).equals("night")) {
	    				SQL = "UPDATE airQuality SET SHISHITEMPRATURE='" +
								WEATHER.get(1) + "',AIRCONDITION='" +
								WEATHER.get(4) + "',TEMPRATURE='最低 " +
								WEATHER.get(5) + "°" + "',WIND='" +
								WEATHER.get(2) + "',WEATHERICON='" +
								WEATHER.get(6) + "',TEMPRATUREUPDATETIME='" +
								WEATHER.get(0).split(" ")[1] + "',WEATHERFORECASE='" +
								WEATHER + "' WHERE area='" +
								city[i] + "'";
	    			} else {
						SQL = "UPDATE airQuality SET SHISHITEMPRATURE='" +
								WEATHER.get(1) + "',AIRCONDITION='" +
								WEATHER.get(3) + "',TEMPRATURE='" +
								WEATHER.get(5) + "°/" + WEATHER.get(4) + "°" + "',WIND='" +
								WEATHER.get(2) + "',WEATHERICON='" +
								WEATHER.get(6) + "',TEMPRATUREUPDATETIME='" +
								WEATHER.get(0).split(" ")[1] + "',WEATHERFORECASE='" +
								WEATHER + "' WHERE area='" +
								city[i] + "'";
					}
	    		}
	    		mysql.executeSQL(SQL);
	    	}
	    	
		}catch(Exception e){
			System.out.println(e.toString());
		}
    }

    public void updateDatabase() {
		int averageAQI = 0;
		int count = 0;
		String beijingAQI;
		String beijingPM25;
		int reqCity;
		int reqStation = 0;
		String USAQI = "";
		String SHAQI = "";
		String SQL = "";
		mysqlService mysql = new mysqlService();

		Calendar rightNow = Calendar.getInstance();
		Date time = rightNow.getTime();
		//System.out.println("start update");
		//System.out.println(time.toString());
		try {
			//获取北京空气信息
			beijingAQI = NetTool.getHtml("http://zx.bjmemc.com.cn/ashx/Data.ashx?Action=GetAQIClose1h", "UTF-8");
			JSONArray jsonObjRecv = new JSONArray(beijingAQI);			
			if(beijingAQI == null){
//				SQL = "INSERT INTO airQuality (cityIndex, stationIndex, USAQIVALUE, USAQITIME, averageAQI, AQI, time, station, quality, PM2_5, area) " +
//						"VALUES(1, 0, -9999, '-9999', -9999, -9999, '-9999', '-9999', '-9999', -9999, '北京')";
//				mysql.executeSQL(SQL);
			} else {
				for(int i = 0; i < jsonObjRecv.length(); i++ ) {
					for(int j = 0; j < beijingStationUnicode.length; j++)
					{
						if(jsonObjRecv.getJSONObject(i).getString("StationName").equals(beijingStationUnicode[j])) {
							reqStation = j;
							break;
						}
					}
					beijingPM25 = 
							NetTool.getHtml("http://zx.bjmemc.com.cn/ashx/Data.ashx?Action=GetChartData_ByStationAndWRWType&StationName="
									+ beijingStation[reqStation] + "&WRWType=pm2.5","UTF-8");
					if(beijingPM25 == null) {
						beijingPM25 = "-9999";
					} else {										
						JSONObject jsonobjRecvPM25 = new JSONObject(beijingPM25);
						int length = jsonobjRecvPM25.getJSONArray("Datas").length();
						//取最近一个存在的pm2.5值
						for(int k = length -1; k >= 0; k--) {
							beijingPM25 = jsonobjRecvPM25.getJSONArray("Datas").getJSONObject(k).get("Value").toString();
							if(!(beijingPM25.equals("") || beijingPM25.equals("-9999")))
								break;
						}
					}
					Integer AQI = TryParseInt(jsonObjRecv.getJSONObject(i).getString("AQIValue"));
					if (AQI == null)
						AQI = -9999;
					float PM2_5;
					try{
						PM2_5 = Float.parseFloat(beijingPM25);
					} catch(NumberFormatException e){
						PM2_5 = -9999;
					} 
					
					SQL = "UPDATE airQuality SET AQI=" + AQI +
							",time='" + jsonObjRecv.getJSONObject(i).getString("Time").split(" ")[1] + "'" + "," +
							"station='" + jsonObjRecv.getJSONObject(i).getString("StationName") + "'" + "," +
							"quality='" + jsonObjRecv.getJSONObject(i).getString("Quality")  + "'" + "," +
							"PM2_5=" + PM2_5 + " WHERE cityIndex=1 AND stationIndex=" + i;
					mysql.executeSQL(SQL);
					
				}		
			}
			//获取上海信息
			for (int i = 0; i < SHStationValue.length; i++) {
				SHAQI= NetTool.getSHAQI("GetSiteAQIData",SHStationValue[i]);
				if(SHAQI == null){
					//do nothing here
				}
				else {
					SHAQI = SHAQI.replace("$", " ").replace("#", " ").replace("*"," ");
					String []SHAQIArray = SHAQI.split(" ");
					
					Integer AQI = TryParseInt(SHAQIArray[1]);
					if (AQI == null)
						AQI = -9999;
					float PM2_5;
					try{
						PM2_5 = Float.parseFloat(SHAQIArray[SHAQIArray.length - 6]);
					} catch(NumberFormatException e){
						PM2_5 = -9999;
					} 
					
					SQL = "UPDATE airQuality SET AQI=" + AQI +
							",time='" + SHAQIArray[SHAQIArray.length - 1].toString() + "'" + "," +
							"station='" + SHStation[i] + "'" + "," +
							"quality='" + SHAQIArray[SHAQIArray.length - 3].toString()  + "'" + "," +
							"PM2_5=" + PM2_5 + " WHERE cityIndex=20 AND stationIndex=" + i;
				}
				mysql.executeSQL(SQL);
			}
			//获取全国信息
			//other cities
			
			for (int i = 0; i < city.length; i++) {
				if(i == 0 || i == 19) {
					//nothing here
				}
				else {
					EnvAQIServeice emc = new EnvAQIServeice();
					IEnvAQIServeice client = emc.getBasicHttpBindingIEnvAQIServeice();
					ArrayOfAQIDataPublishLiveInfo o = client.getAQIDataByCityName(city[i]);
					List<AQIDataPublishLiveInfo> strList = o.getAQIDataPublishLiveInfo();
				      
			
					for(int j = 0; j < strList.size(); j++) {
						Integer temp = TryParseInt(strList.get(j).getAQI().getValue());
						if (temp != null) {
							averageAQI+= Integer.valueOf(temp);
							count++;
						}
					}
		
					for(int j = 0; j < strList.size(); j++) {
						Integer AQI = TryParseInt(strList.get(j).getAQI().getValue());
						if (AQI == null)
							AQI = -9999;
						float PM2_5;
						try{
							PM2_5 = Float.parseFloat(strList.get(j).getPM25().getValue());
						} catch(NumberFormatException e){
							PM2_5 = -9999;
						}
						int temp = i + 1;
						SQL = "UPDATE airQuality SET averageAQI=" + averageAQI/count + "," +
								"AQI=" + AQI +
								",time='" + strList.get(j).getTimePoint().toString().split("T")[1] + "'" + "," +
								"station='" + strList.get(j).getPositionName().getValue() + "'" + "," +
								"quality='" + strList.get(j).getQuality().getValue()  + "'" + "," +
								"PM2_5=" + PM2_5 + " WHERE cityIndex=" + temp + " AND stationIndex=" + j;
						
						mysql.executeSQL(SQL);
					}
				}
			}
			rightNow = Calendar.getInstance();
			time = rightNow.getTime();
			//System.out.println("end update");
			//System.out.println(time.toString());
			
			//获取美国大使馆空气信息
			USAQI = NetTool.getHtml("http://www.aqicn.info/?json&key=v5&city=beijing", "UTF-8");
			if(USAQI == null){
				//nothing to do here
			}
			else {
				JSONObject jsonObjUSAQI = new JSONObject(USAQI);
				SQL = "UPDATE airQuality SET USAQIVALUE=" +
						Integer.valueOf(jsonObjUSAQI.getString("aqi")) + ",USAQITIME='" + 
						jsonObjUSAQI.getJSONObject("time").getString("u").split(" ")[1] + "'" + 
						"WHERE area='北京'";
				mysql.executeSQL(SQL);
			}
			USAQI = NetTool.getHtml("http://www.aqicn.info/?json&key=v5&city=shanghai", "UTF-8");
			if(USAQI == null){
				//nothing to do here
			}
			else {
				JSONObject jsonObjUSAQI = new JSONObject(USAQI);
				SQL = "UPDATE airQuality SET USAQIVALUE=" +
						Integer.valueOf(jsonObjUSAQI.getString("aqi")) + ",USAQITIME='" + 
						jsonObjUSAQI.getJSONObject("time").getString("u").split(" ")[1] + "'" + 
						"WHERE area='上海'";
				mysql.executeSQL(SQL);
			}
			USAQI = NetTool.getHtml("http://www.aqicn.info/?json&key=v5&city=guangzhou", "UTF-8");
			if(USAQI == null){
				//nothing to do here
			}
			else {
				JSONObject jsonObjUSAQI = new JSONObject(USAQI);
				SQL = "UPDATE airQuality SET USAQIVALUE=" +
						Integer.valueOf(jsonObjUSAQI.getString("aqi")) + ",USAQITIME='" + 
						jsonObjUSAQI.getJSONObject("time").getString("u").split(" ")[1] + "'" + 
						"WHERE area='广州'";
				mysql.executeSQL(SQL);
			}
			USAQI = NetTool.getHtml("http://www.aqicn.info/?json&key=v5&city=chengdu", "UTF-8");
			if(USAQI == null){
				//nothing to do here
			}
			else {
				JSONObject jsonObjUSAQI = new JSONObject(USAQI);
				SQL = "UPDATE airQuality SET USAQIVALUE=" +
						Integer.valueOf(jsonObjUSAQI.getString("aqi")) + ",USAQITIME='" + 
						jsonObjUSAQI.getJSONObject("time").getString("u").split(" ")[1] + "'" + 
						"WHERE area='成都'";
				mysql.executeSQL(SQL);
			}
			
			
			//获取全国天气信息
	    	ArrayList<String> WEATHER = null;
	    	for(int i = 0; i < cityWeather.length; i++) {
	    		WEATHER = NetTool.getWeatherFromSina(cityWeather[i]);
	    		if(WEATHER == null) {
	    			//nothing to do here
	    		}
	    		else
	    		{	
	    			if(WEATHER.get(3).equals("night")) {
						SQL = "UPDATE airQuality SET SHISHITEMPRATURE='" +
								WEATHER.get(1) + "',AIRCONDITION='" +
								WEATHER.get(4) + "',TEMPRATURE='最低 " +
								WEATHER.get(5) + "°" + "',WIND='" +
								WEATHER.get(2) + "',WEATHERICON='" +
								WEATHER.get(6) + "',TEMPRATUREUPDATETIME='" +
								WEATHER.get(0).split(" ")[1] + "',WEATHERFORECASE='" +
								WEATHER + "' WHERE area='" +
								city[i] + "'";
					} else {
						SQL = "UPDATE airQuality SET SHISHITEMPRATURE='" +
								WEATHER.get(1) + "',AIRCONDITION='" +
								WEATHER.get(3) + "',TEMPRATURE='" +
								WEATHER.get(5) + "°/" + WEATHER.get(4) + "°" + "',WIND='" +
								WEATHER.get(2) + "',WEATHERICON='" +
								WEATHER.get(6) + "',TEMPRATUREUPDATETIME='" +
								WEATHER.get(0).split(" ")[1] + "',WEATHERFORECASE='" +
								WEATHER + "' WHERE area='" +
								city[i] + "'";
					}
	    		}
	    		mysql.executeSQL(SQL);
	    	}
	    	
		}catch(Exception e){
			System.out.println(e.toString());
		}
    }

	public void doPost (HttpServletRequest req, HttpServletResponse res)
        throws IOException
	{
		res.getWriter().println(req.getParameterNames());
	
	}
	public void destory() {
		super.destroy();
		if (timer2 != null) {
			timer2.cancel();
		}
	}
	public void init() {
		//System.out.println("启动服务");
		String startTask = getInitParameter("startTask");
		Calendar calendar = Calendar.getInstance();
		Long intervalTime = Long.parseLong(getInitParameter("intervalTime"));
		mysqlService mysql = new mysqlService();
		try {
			//mysql.dropTable();
			//mysql.createTable();
			//initDatabase();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		
		if(startTask.equals("true")) {
			timer2 = new Timer(true);
			datastore = new datastoreTimer();
			timer2.schedule(datastore, calendar.getTime(),intervalTime * 1000);
		}
	}

}
