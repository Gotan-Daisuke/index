package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoJDBC {
	/**
	 * DBコネクション生成します
	 * @return DBコネクション
	 * @throws ClassNotFoundException クラスロード時の例外
	 * @throws SQLException コネクション生成時の例外
	 */
	public Connection createConnection() throws ClassNotFoundException, SQLException {
			String dbUrl = "jdbc:postgresql://localhost:5432/index";
			String dbUser = "postgres";
			String dbPassword = "password";
			Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	}
}
