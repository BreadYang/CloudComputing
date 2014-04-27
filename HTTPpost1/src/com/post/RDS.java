package com.post;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

import org.aspectj.weaver.ast.Test;

public class RDS {
	public Connection connect = null;
	public Statement statement = null;
	public ResultSet resultSet = null;
	public String DB_END_POINT = "mydbinstance.crowgjuaiaiz.us-east-1.rds.amazonaws.com";
	public final String DB_USER_NAME = "liguifan";
	public final String DB_PWD = "liguifan";
	public final String DB_NAME = "mydb";
	public final int DB_PORT = 3306;
	
	public void createConnectionAndStatement()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			connect = DriverManager.getConnection("jdbc:mysql://"+DB_END_POINT+":"+DB_PORT+"/"+DB_NAME,DB_USER_NAME,DB_PWD);
			statement = connect.createStatement();
			System.out.println("success created connection");
		} catch (Exception e) {
			e.printStackTrace();
//			close();
		}
	}

	public void insertTable(String Tablename,String name, String link) throws SQLException{
		String insert="insert into "+Tablename+" values(\""+name+"\",\""+link+"\")";
		System.out.println(insert);
		createConnectionAndStatement();
		statement.executeUpdate(insert);
	}
	
	public void register_ID(String ID,String name,String age,String photo, String movies, String a,String b, String c,String d) throws SQLException{
		String insert="insert into "+"REGISTER"+" values(\""+ID+"\",\""+name+"\",\""+age+"\",\""+photo+"\",\""+movies+"\",\""+a+"\",\""+b+"\",\""+c+"\",\""+d+"\")";
		//System.out.println(insert);
		//createConnectionAndStatement();
//		String insert2="insert into REGISTER values(\"a\",\"a\",\"a\",\"a\",\"a\",\"a\",\"a\",\"a\",\"a\")";
//		String in="insert into FRIEND_LIST values(11,11)";
		statement.executeUpdate(insert);
	}
	
	
	public void deleteTable(String tableName) throws SQLException{
		createConnectionAndStatement();
		String delete="drop table "+tableName;
		System.out.println(delete);
		statement.executeUpdate(delete);
	}
	
	public void create_UserTable(String Tablename)
	{
		try {
			createConnectionAndStatement();
			String createTableSql = "CREATE TABLE "
			+Tablename+" (userid VARCHAR(255) not NULL, gender VARCHAR(255), "
			+ "name VARCHAR(255), age int, password int, url VARCHAR(255) ) ";
			statement.executeUpdate(createTableSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//close();
		}

	}
	
	public void create_PhotoTable(String Tablename)
	{
		try {
			createConnectionAndStatement();
			String createTableSql = "CREATE TABLE "+Tablename+" (userid VARCHAR(255) not NULL, photo_name VARCHAR(255), photo_url VARCHAR(255)) ";
			statement.executeUpdate(createTableSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//close();
		}

	}
	
	public void create_Blur_PhoteTable(String Tablename)
	{
		try {
			createConnectionAndStatement();
			String createTableSql = "CREATE TABLE "+Tablename+" (photo_name VARCHAR(255) not NULL, blur_photo_name VARCHAR(255), blur_photo_url VARCHAR(255)) ";
			statement.executeUpdate(createTableSql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//close();
		}

	}
	
	public void create_HearbeatTable(String Tablename)
	{
		
	}
	
	public void create_FriendlistTable(String Tablename)
	{
		
	}
	
	public void create_GameStageTable(String Tablename)
	{
		
	}
	
public static void main(String args[]) throws SQLException{
		
		//String road="insert into VIDEO_INFO values(\"Music2\",\"dddd\")";
		//String road1="insert into VIDEO_INFO values(\"Music3\",\"dddd1\")";
				//t.create_bucket_upload("/Users/Rich/Desktop/Rich.jpg");
		RDS r=new RDS();
		r.createConnectionAndStatement();
		String name1="Music21fadf1eeedfe";
		String name2="Music3";
		String link1="dddd";
		String link2="dddd1";
		//r.deleteTable("VIDEO_INFO");
		String tablename="USER_ORIGINAL";
//		r.deleteTable(tablename);
//		r.create_UserTable(tablename);
//
		r.register_ID(name1,name1,name1,name1,name1,name1,name1,name1,name1);
//		r.insertTable(tablename,name2,link2);
//		System.out.println(r.queryTable(tablename));
		
	
		
	}
	
}
