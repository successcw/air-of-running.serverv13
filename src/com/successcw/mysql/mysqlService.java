package com.successcw.mysql;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysqlService {
  private Connection connect = null;
  private Statement statement = null;
  private ResultSet resultSet = null;

  private String url = "jdbc:mysql://172.30.48.30:3306/";
  private String dbName = "d1fd349dc26d74d0ab4bd8a244cd0973e";
  private String driverName = "com.mysql.jdbc.Driver";
  private String userName = "uU6vikFNjmTIb";
  private String password = "psQTyY1IsJCts";
  

  public void createTable() throws Exception {

	  //System.out.println("Create table!");

	  try{
		  Class.forName(driverName).newInstance();
		  connect = DriverManager.getConnection(url+dbName, userName, password);
		  try{
			  Statement st = connect.createStatement();
			  String table = 
					  "CREATE TABLE airQuality(cityIndex integer," +
					  "stationIndex integer," +
					  "SHISHITEMPRATURE varchar(10)," +
					  "AIRCONDITION varchar(20)," +
					  "TEMPRATURE varchar(20)," +
					  "WIND varchar(40)," +
					  "WEATHERICON varchar(2)," +
					  "TEMPRATUREUPDATETIME varchar(20)," +
					  "WEATHERFORECASE varchar(500)," +
					  "USAQIVALUE integer," +
					  "USAQITIME varchar(20)," +
					  "averageAQI integer," +
					  "AQI integer," +
					  "time varchar(20)," +
					  "station varchar(40)," +
					  "quality varchar(20)," +
					  "PM2_5 float(10,3), " +
					  "area varchar(20)) CHARSET=utf8";
			  st.executeUpdate(table);
			  //System.out.println("Table creation process successfully!");
		  }
		  catch(SQLException s){
			  System.out.println(s.toString());
		  }
		  connect.close();
	  }
	  catch (Exception e){
		  e.printStackTrace();
	  }
  }
  public String[] getFromDatabase(int city, int station) {
	  String [] returnValue = new String[16];
	  try{
		  //System.out.println("getFromDatabase start");
		  Class.forName(driverName).newInstance();
		  connect = DriverManager.getConnection(url+dbName, userName, password);
		  try{
			  //Statement st = connect.createStatement();
			  String SQL = "Select * from airQuality where cityIndex = ? and stationIndex = ?";
			  PreparedStatement prepStmt = connect.prepareStatement(SQL);
			  prepStmt.setInt(1, city);
			  prepStmt.setInt(2, station);
			  resultSet = prepStmt.executeQuery();
			  //System.out.println("getFromDatabase process successfully!");
			  while(resultSet.next()) {
				  returnValue[0] = resultSet.getString("SHISHITEMPRATURE");
				  returnValue[1] = resultSet.getString("AIRCONDITION");
				  returnValue[2] = resultSet.getString("TEMPRATURE");
				  returnValue[3] = resultSet.getString("WIND");
				  returnValue[4] = resultSet.getString("WEATHERICON");
				  returnValue[5] = resultSet.getString("TEMPRATUREUPDATETIME");
				  returnValue[6] = resultSet.getString("WEATHERFORECASE");
				  returnValue[7] = String.valueOf(resultSet.getInt("USAQIVALUE"));
				  returnValue[8] = resultSet.getString("USAQITIME");
				  returnValue[9] = String.valueOf(resultSet.getInt("averageAQI"));
				  returnValue[10] = String.valueOf(resultSet.getInt("AQI"));
				  returnValue[11] = resultSet.getString("time");
				  returnValue[12] = resultSet.getString("station");
				  returnValue[13] = resultSet.getString("quality");      	
				  returnValue[14] = String.valueOf(resultSet.getInt("PM2_5"));
				  returnValue[15] = resultSet.getString("area"); 
			  }
		  }
		  catch(SQLException s){
			  System.out.println(s.toString());
			  return null;
		  }
		  connect.close();
		  return returnValue;
	  }
	  catch (Exception e){
		  e.printStackTrace();
		  return null;
	  }
  }
  public  InputStream getFile() {
	  InputStream is = null;
	  try{
		  //System.out.println("getFromDatabase start");
		  Class.forName(driverName).newInstance();
		  connect = DriverManager.getConnection(url+dbName, userName, password);
		  try{
			  //Statement st = connect.createStatement();
			  String SQL = "Select * from download";
			  PreparedStatement prepStmt = connect.prepareStatement(SQL);
			  resultSet = prepStmt.executeQuery();
			  //System.out.println("getFromDatabase process successfully!");
			  while(resultSet.next()) {
				  is = resultSet.getBinaryStream(1);
			  }
		  }
		  catch(SQLException s){
			  System.out.println(s.toString());
			  return null;
		  }
		  connect.close();
		  return is;
	  }
	  catch (Exception e){
		  e.printStackTrace();
		  return null;
	  }
  }
  public void executeSQL(String SQL) throws Exception {

	  //System.out.print("excute SQL");
	  //System.out.println(SQL);
	  SQL = new String(SQL.getBytes(),"UTF-8");
	  //System.out.println(SQL);
	  
	  try{
		  Class.forName(driverName).newInstance();
		  connect = DriverManager.getConnection(url+dbName, userName, password);
		  try{
			  Statement st = connect.createStatement();
			  st.executeUpdate(SQL);
			  //System.out.println("SQL process successfully!");
		  }
		  catch(SQLException s){
			  System.out.println(s.toString());
		  }
		  connect.close();
	  }
	  catch (Exception e){
		  e.printStackTrace();
	  }
  }
  
  public void dropTable() throws Exception {

	  //System.out.println("drop table!");

	  try{
		  Class.forName(driverName).newInstance();
		  connect = DriverManager.getConnection(url+dbName, userName, password);
		  try{
			  Statement st = connect.createStatement();
			  String table = 
					  "drop table if exists airQuality";
			  st.execute(table);
			  //System.out.println("drop table process successfully!");
		  }
		  catch(SQLException s){
			  System.out.println(s.toString());
		  }
		  connect.close();
	  }
	  catch (Exception e){
		  e.printStackTrace();
	  }
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

} 
