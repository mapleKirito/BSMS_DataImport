package test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DBConn {
	private static DBConn instance;
	Connection conn = null ;
	Statement st = null ;
	ResultSet rs = null ;
	PreparedStatement ps = null;
	String driver_class = "com.mysql.jdbc.Driver";
	String connection_url = "jdbc:mysql://192.168.1.116/bsms_history?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";
	String user_name = "root";
	String db_password = "1234";
	List<HashMap<String, String>> errorList  ;
	
	private static boolean isLog = false ;
	
	public DBConn() {
		try {
			errorList = new ArrayList<HashMap<String,String>>() ;
			Class.forName(driver_class);
			conn = DriverManager.getConnection(connection_url, user_name, db_password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public DBConn(String driver, String url, String username, String password) {
		try {
			init(driver, url, username, password) ;
			Class.forName(driver_class);
			conn = DriverManager.getConnection(connection_url, user_name, db_password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized DBConn getInstance() {
		if (instance == null) {
			instance = new DBConn();
		}

		return instance;
	}
	
	public void init(String driver, String url, String username, String password) {
		driver_class  = driver ;
		connection_url = url ;
		user_name = username ;
		db_password = password ;
	}
	
	public void closeConn(){
		try{
			if(!conn.isClosed()) {
				conn.close() ;
			}
		}catch(Exception e){}
	}
	
	public void close() {
		try{
			rs.close() ;
		}catch(Exception e){}
		try{
			st.close() ;
		}catch(Exception e){}
		try{
			//conn.close() ;
		}catch(Exception e){}
	}
	
	public int insert(String sql) {
		int key = 0 ;
		try{
			if(isLog){
				System.out.println("insert: "+sql) ;
			}
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ;
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				key = rs.getInt(1);
			}
			
		}catch(Exception e) {
			
			e.printStackTrace() ;
		}finally {
			close() ;
		}
		return key ;
	}
	
	public int insert(String sql, boolean isKey) {
		int key = 0 ;
		try{
			if(isLog){
				System.out.println("insert: "+sql) ;
			}
			st = conn.createStatement() ;
			st.executeUpdate(sql) ;
			
			
		}catch(Exception e) {
			key = -1 ;
			e.printStackTrace() ;
			HashMap map = new HashMap() ;
			map.put("error", e.getMessage()) ;
			map.put("sql", sql) ;
			errorList.add(map) ;
		}finally {
			close() ;
		}
		return key ;
	}
	
	public int insert(HashMap<String, String> map, String table) {
		String sql = "" ;
		String field = "" ;
		String value = "" ;
		Set<Map.Entry<String, String>> set = map.entrySet();
        for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext();) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
            //System.out.println(entry.getKey() + "--->" + entry.getValue());
            field += entry.getKey() + "," ;
            value += "'" + entry.getValue() + "'," ;
        }
        field = field.substring(0, field.length() - 1) ;
        value = value.substring(0, value.length() - 1) ;
        sql = "insert into " + table + "(" + field + ") values (" + value + ")" ;
        System.out.println("插入资源：" + sql);
        if(isLog){
			System.out.println("insert: "+sql) ;
		}
        return insert(sql) ;
	}
	
	public int selectCount(String sql) {
		int index = 0 ;
		try{
			st = conn.createStatement() ;
			rs = st.executeQuery(sql) ;
			if(rs.next()) {
				index = rs.getInt(1) ;
			}
			if(isLog){
				System.out.println("selectCount: "+sql) ;
			}
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally {
			close() ;
		}
		return index ;
	}
	
	public List<HashMap<String, String>> select(String sql) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>() ;
		try{
			st = conn.createStatement() ;
			rs = st.executeQuery(sql) ;
			if(isLog){
				System.out.println("select: "+sql) ;
			}
			ResultSetMetaData rsMeta = rs.getMetaData();
			while(rs.next()) {
				HashMap<String, String> map = new HashMap<String, String>() ;
				for(int i = 0; i < rsMeta.getColumnCount(); ++i){
					String columnName = rsMeta.getColumnName(i+1);
					map.put(columnName, rs.getString(columnName)) ;
				}
				list.add(map) ;
			}
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally {
			close() ;
		}
		return list ;
	}
	
	public HashMap<String, String> selectOne(String sql) {
		HashMap<String, String> map = new HashMap<String, String>() ;
		try{
			st = conn.createStatement() ;
			rs = st.executeQuery(sql) ;
			if(isLog){
				System.out.println("selectOne: "+sql) ;
			}
			ResultSetMetaData rsMeta = rs.getMetaData();
			int index = 0 ;
			while(rs.next()) {
				for(int i = 0; i < rsMeta.getColumnCount(); ++i){
					String columnName = rsMeta.getColumnName(i+1);
					map.put(columnName, rs.getString(columnName)) ;
				}
				index ++ ;
			}
			if(index == 0) {
				return null ;
			}
			
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally {
			close() ;
		}
		return map ;
	}
	
	public int update(String sql) {
		int size = 0 ;
		try{
			st = conn.createStatement() ;
			size = st.executeUpdate(sql) ;
			if(isLog){
				System.out.println("update: "+sql) ;
			}
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally {
			close() ;
		}
		return size ;
	}
	
	public void setError(String sql, String error) {
		HashMap<String, String> map = new HashMap<String, String>() ;
		map.put("sql", sql) ;
		map.put("error", error) ;
		errorList.add(map) ;
	}
	
	public void viewError() {
		for(HashMap<String, String> map : errorList) {
			System.out.println("错误：" + map.get("sql"));
			System.out.println("错误异常：" + map.get("error"));
			System.out.println("--------------------------------------------------------------");
		}
	}
}
