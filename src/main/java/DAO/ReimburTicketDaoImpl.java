package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionService;
import Models.ReimbursementTicket;
import Models.UserMeta;

public class ReimburTicketDaoImpl implements ReimburTicketDao {

	@Override
	public void insertTicket(ReimbursementTicket ticket) {
		String sqlString = "INSERT INTO reimbursement_ticket(user_id, reimburse_amount, current_ticket_type, current_ticket_status) VALUES(?,?,CAST(? AS ticket_type),CAST(? AS ticket_status))";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqlString)) {
			pStatement.setInt(1, ticket.getUserID());
			pStatement.setInt(2, ticket.getReimburseAmount());
			pStatement.setString(3, ticket.getTicketType());
			pStatement.setString(4, ticket.getTicketStatus());
			pStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ReimbursementTicket selectByTicketID(int ticketID) {
		String sqString = "SELECT * FROM reimbursement_ticket WHERE id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqString)){
			pStatement.setInt(1, ticketID);
			ResultSet rSet = pStatement.executeQuery();
			while(rSet.next()) {
				return new ReimbursementTicket(rSet.getInt("id"), 
						rSet.getInt("user_id"),
						rSet.getInt("reimburse_amount"),
						rSet.getString("current_ticket_type"),
						rSet.getString("current_ticket_status"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ReimbursementTicket> selectByUserID(int userID) {
		String sqString = "SELECT * FROM reimbursement_ticket WHERE user_id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		List<ReimbursementTicket> ticketList = new ArrayList<>();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqString)){
			pStatement.setInt(1, userID);
			ResultSet rSet = pStatement.executeQuery();
			while(rSet.next()) {
				ReimbursementTicket ticket = new ReimbursementTicket(rSet.getInt("id"), 
						rSet.getInt("user_id"),
						rSet.getInt("reimburse_amount"),
						rSet.getString("current_ticket_type"),
						rSet.getString("current_ticket_status"));
				
				ticketList.add(ticket);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}

	@Override
	public List<ReimbursementTicket> selectByTicketType(String ticketType) {
		String sqString = "SELECT * FROM reimbursement_ticket WHERE current_ticket_type=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		List<ReimbursementTicket> ticketList = new ArrayList<>();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqString)){
			pStatement.setString(1, ticketType);
			ResultSet rSet = pStatement.executeQuery();
			
			while(rSet.next()) {
				ReimbursementTicket ticket = new ReimbursementTicket(rSet.getInt("id"), 
						rSet.getInt("user_id"),
						rSet.getInt("reimburse_amount"),
						rSet.getString("current_ticket_type"),
						rSet.getString("current_ticket_status"));
				
				ticketList.add(ticket);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}

	@Override
	public List<ReimbursementTicket> selectByTicketStatus(String ticketStatus) {
		String sqString = "SELECT * FROM reimbursement_ticket WHERE current_ticket_status=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		List<ReimbursementTicket> ticketList = new ArrayList<>();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqString)){
			pStatement.setString(1, ticketStatus);
			ResultSet rSet = pStatement.executeQuery();
			
			while(rSet.next()) {
				ReimbursementTicket ticket = new ReimbursementTicket(rSet.getInt("id"), 
						rSet.getInt("user_id"),
						rSet.getInt("reimburse_amount"),
						rSet.getString("current_ticket_type"),
						rSet.getString("current_ticket_status"));
				
				ticketList.add(ticket);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}

	@Override
	public List<ReimbursementTicket> selectAllTickets() {
		String sqString = "SELECT * FROM reimbursement_ticket";
		
		Connection connection = ConnectionService.ReturnConnection();
		List<ReimbursementTicket> ticketList = new ArrayList<>();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqString)){
			ResultSet rSet = pStatement.executeQuery();
			
			while(rSet.next()) {
				ReimbursementTicket ticket = new ReimbursementTicket(rSet.getInt("id"), 
						rSet.getInt("user_id"),
						rSet.getInt("reimburse_amount"),
						rSet.getString("current_ticket_type"),
						rSet.getString("current_ticket_status"));
				
				ticketList.add(ticket);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketList;
	}

	@Override
	public void updateReimburseAmount(ReimbursementTicket ticket, int amount) {
		String sqlString = "UPDATE reimbursement_ticket SET reimburse_amount=? WHERE user_id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqlString)) {
			pStatement.setInt(1, amount);
			pStatement.setInt(2, ticket.getUserID());

			pStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateTicketType(ReimbursementTicket ticket, String ticketType) {
		String sqlString = "UPDATE reimbursement_ticket SET current_ticket_type=? WHERE user_id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqlString)) {
			pStatement.setString(1, ticketType);
			pStatement.setInt(2, ticket.getUserID());

			pStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateTicketStatus(ReimbursementTicket ticket, String ticketStatus) {
		String sqlString = "UPDATE reimbursement_ticket SET current_ticket_status=? WHERE user_id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqlString)) {
			pStatement.setString(1, ticketStatus);
			pStatement.setInt(2, ticket.getUserID());

			pStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTicket(ReimbursementTicket ticket) {
		String sqlString = "DELETE FROM reimbursement_ticket WHERE user_id=?";
		
		Connection connection = ConnectionService.ReturnConnection();
		
		try(PreparedStatement pStatement = connection.prepareStatement(sqlString)) {
			pStatement.setInt(1, ticket.getUserID());

			pStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
