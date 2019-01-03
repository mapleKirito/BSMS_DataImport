package test.db;

import java.beans.PropertyVetoException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBSource {
	private static ComboPooledDataSource ds ;
	
	public static void intitDataSource(){
		ds = new ComboPooledDataSource() ;
		try {
			ds.setDriverClass("oracle.jdbc.driver.OracleDriver") ;
			ds.setJdbcUrl("jdbc:oracle:thin:@172.18.97.185:1521:aics") ;
			ds.setUser("aics") ;
			ds.setPassword("aics") ;
			ds.setInitialPoolSize(3) ;
			ds.setMinPoolSize(2) ;//
			ds.setMaxPoolSize(50) ;
			ds.setMaxIdleTime(600) ;//最大空闲时间,60秒内未使用则连接被丢弃。若为0则永不丢弃。
			ds.setAcquireIncrement(3) ;//当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。Default: 3
			
			//ds.setNumHelperThreads(30) ;c3p0是异步操作的，缓慢的JDBC操作通过帮助进程完成。扩展这些操作可以有效的提升性能通过多线程实现多个操作同时被执行。Default: 3
			ds.setAcquireRetryAttempts(30) ;//定义在从数据库获取新连接失败后重复尝试的次数。Default: 30
			ds.setTestConnectionOnCheckin(true) ;//如果设为true那么在取得连接的同时将校验连接的有效性
			ds.setAutomaticTestTable("c3p0TestTable") ;//c3p0将建一张名为Test的空表，并使用其自带的查询语句进行测试。如果定义了这个参数那么属性preferredTestQuery将被忽略。你不能在这张Test表上进行任何操作，它将只供c3p0测试	使用。Default: null
			ds.setIdleConnectionTestPeriod(900) ;
			ds.setCheckoutTimeout(10000) ;//当连接池用完时客户端调用getConnection()后等待获取新连接的时间，超时后将抛出SQLException,如设为0则无限期等待。单位毫秒。Default: 0
		} catch (PropertyVetoException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		intitDataSource() ;
	}

}
