package com.mingrn.common;

import com.alibaba.fastjson.JSONObject;
import com.mingrn.common.map.LocationUtil;

import java.sql.*;

/**
 * 新版驱动url默认地址为127.0.0.1:3306,所以访问本机mysql数据库地址可以用 /// 表示;
 * eg:
 * jdbc.url=jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC
 * jdbc.url=jdbc:mysql:///test?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC
 * </p>
 * 另外,新版驱动类位置发生了改变:com.mysql.cj.jdbc.Driver
 * eg:
 * Class.forName("com.mysql.jdbc.Driver");
 * Class.forName("com.mysql.cj.jdbc.Driver");
 * </p>
 * <a href = "https://blog.csdn.net/tb_520/article/details/79676543"></a>
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 01/10/2018 19:08
 */
public class ConnectJdbc {

	private static String dbUrl;
	private static String dbUser;
	private static String dbPassword;
	private static String selectSQl;
	private static ResultSet resultSet = null;
	private static Connection connection = null;
	private static Statement updateStatement = null;
	private static Statement selectStatement = null;


	static {
		dbUser = "root";
		dbPassword = "admin";
		selectSQl = "SELECT object_id,location_addr FROM `car_maintenance_station` WHERE deleted = 2";
		dbUrl = "jdbc:mysql:///yilutong?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=UTC";
	}

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			selectStatement = connection.createStatement();
			updateStatement = connection.createStatement();
			ResultSet resultSet = selectStatement.executeQuery(selectSQl);
			while (resultSet.next()) {
				Long objectId = resultSet.getLong(1);
				String locationAddr = resultSet.getString(2);
				JSONObject locationObj = LocationUtil.getLngAndLat(locationAddr);
				if (locationObj == null) {
					continue;
				}
				locationObj = locationObj.getJSONObject("result").getJSONObject("location");
				String up = updateSQL(locationObj.getDouble("lng"), locationObj.getDouble("lat"), objectId);
				System.out.println(up);
				System.out.println(locationAddr + " >>>> " + locationObj.toJSONString());
//				updateStatement.executeUpdate(up);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (updateStatement != null) {
				updateStatement.close();
			}
			if (selectStatement != null) {
				selectStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	/**
	 * 修改 SQL 语句
	 */
	private static String updateSQL(Double lng, Double lat, Long key) {
		return "UPDATE car_maintenance_station SET location_longitude = " + lng + ", location_latitude = " + lat + "WHERE object_id = " + key;
	}
}