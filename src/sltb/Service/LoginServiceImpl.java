package sltb.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import sltb.Model.UserModel;
import sltb.Utill.DBConnectionUtil;

public class LoginServiceImpl implements LoginService {
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	@Override
	public boolean validateUser(UserModel user) {
	//declare query
		System.out.println("Methanata awa");
		boolean flag = false;
		String sql = "SELECT * FROM `user` WHERE `user`.`email` = ? and `user`.`password` = ?";
		try {
			connection = DBConnectionUtil.createConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				System.out.println("have badu");
				return true;
			}
			else return false;
			
			
		} catch (SQLException ex1)  {
			//log.log(Level.SEVERE, ex1.getMessage());
		} finally {
			//close connection and preparedstatement
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
				//log.log(Level.SEVERE, ex.getMessage());
			}
		}
		return false;
	}

}
