package sltb.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import sltb.Model.BusModel;
import sltb.Utill.DBConnectionUtil;

public class BusServiceImpl implements BusService {
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static PreparedStatement prearedStatement = null;
	private static List<BusModel> list = null;
	private BusModel busMOdel = null;
	@Override
	public boolean addBus(BusModel bus) {
		boolean flag = false;

		try {

			//declare query
			String sql = "INSERT INTO `bus` (`ticketPrice`, `seatAval`, `rout`, `timeAval`, `type`, `id`) VALUES ('"+bus.getTickPrice()+"', '"+bus.getSeatAval()+"', '"+bus.getRoute()+"', '"+bus.getTimeAval()+"', '"+bus.getType()+"', NULL)";
			
			
			
			connection = DBConnectionUtil.createConnection();//open connection

			prearedStatement = connection.prepareStatement(sql);

//			System.out.println(s.getAccNum());

			prearedStatement.execute();
			flag = true;

		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			//close the connection and preparedstatement
			 
			 
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}

		return flag;
	}
	@Override
	public List<BusModel> allBus() {
		list = new ArrayList<BusModel>();
		try {
				//declare query
			String sql = "SELECT * FROM `bus`";

			connection = DBConnectionUtil.createConnection(); //open connection

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql); //excecute query

			while (resultSet.next()) {
				busMOdel = new BusModel();

				busMOdel.setTickPrice(resultSet.getFloat("ticketPrice"));
				busMOdel.setSeatAval(resultSet.getInt("seatAval"));
				busMOdel.setRoute(resultSet.getString("rout"));
				busMOdel.setTimeAval(resultSet.getString("timeAval"));
				busMOdel.setType(resultSet.getString("type"));
				busMOdel.setId(resultSet.getInt("id"));
				list.add(busMOdel);
			}
		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			//close the connection and preparedstatement
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}
		return list;
	}
	@Override
	public boolean deleteBus(int id) {
		boolean flag = false;
		//declare query
		String sql = "DELETE FROM `bus` WHERE `bus`.`id` ="+id;

		try {
			connection = DBConnectionUtil.createConnection();//open connection
			prearedStatement = connection.prepareStatement(sql);
			prearedStatement.executeUpdate();

			flag = true;
		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			//close the connection and preparedstatement
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}

		return flag;
	}
	@Override
	public BusModel getSinglebus(int id) {
		busMOdel = new BusModel();
		//declare query
		String sql = "SELECT * FROM `bus` WHERE `bus`.`id` ="+id;

		try {
			connection = DBConnectionUtil.createConnection();//open connection

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				busMOdel.setTickPrice(resultSet.getFloat("ticketPrice"));
				busMOdel.setSeatAval(resultSet.getInt("seatAval"));
				busMOdel.setRoute(resultSet.getString("rout"));
				busMOdel.setTimeAval(resultSet.getString("timeAval"));
				busMOdel.setType(resultSet.getString("type"));
				busMOdel.setId(id);

			}

		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			//close the connection and preparedstatement
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}

		return busMOdel;

	}
	@Override
	public boolean updateBus(BusModel bus) {
		boolean flag = false;

		//declare query

		System.out.println(bus.getTickPrice());
		System.out.println(bus.getSeatAval());
		System.out.println(bus.getRoute());
		System.out.println(bus.getTimeAval());
		System.out.println(bus.getType());
		System.out.println(bus.getType());
		
		String sql = "UPDATE `bus` SET `ticketPrice` = '"+bus.getTickPrice()+"', `seatAval` = '"+bus.getSeatAval()+"', `rout` = '"+bus.getRoute()+"', `timeAval` = '"+bus.getTimeAval()+"', `type` = '"+bus.getType()+"' WHERE `bus`.`id` ="+bus.getId();

		try {
			connection = DBConnectionUtil.createConnection();//open connection

			prearedStatement = connection.prepareStatement(sql);


			prearedStatement.executeUpdate();

			flag = true;
		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			//close the connection and preparedstatement
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}
		return flag;
	}

}
