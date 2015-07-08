package org.worldoflearning;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DbUtil {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void initialize() {
		DataSource dataSource = getDataSource();
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			statement
					.executeUpdate("CREATE TABLE Benutzer (ID INTEGER(11), NAME VARCHAR(20), EMAIL VARCHAR(100), PASSWORD VARCHAR(20), ROLE VARCHAR(10), DATE VARCHAR(10))");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}