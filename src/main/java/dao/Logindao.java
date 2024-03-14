package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.LoginEntity;

public class Logindao extends DaoJDBC{
	
	/**
	 * DBWork を全件取得します
	 */
	public List<LoginEntity> findAll(String formId, String formPassword){
		// DBコネクション生成
		try (Connection connection = createConnection()) {
			// SQL実行オブジェクト生成
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT* FROM login Where userid='"+formId+"',userpassword='"+formPassword+"';");
			// SQL実行
			ResultSet rs = pstmt.executeQuery();
			// SQL実行結果からデータを取得
			List<LoginEntity> list = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String userid = rs.getString("userid");
				String userpassword = rs.getString("userpassword");
				String username = rs.getString("username");
				list.add(new LoginEntity(id, userid, userpassword, username));
			}
			return list;
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
