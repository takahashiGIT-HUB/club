package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/club";
	private final String DB_USER = "postgres";
	private final String DB_PASS = "root";
	
	private  Connection conn = null;
	
	public CustomerDAO() {
		//JDBCドライバーを読み込む
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバーを読み込めませんでした");
		}
		//データベース接続
		try {
			 conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Customer> findByUserId (int userId) {
		List<Customer> list = new ArrayList<>();
		
		//SELECT文を準備
		String spl = "SELECT * FROM customers WHERE user_id = ? ORDER BY id DESC";

		//データーベースへ接続
		try(PreparedStatement Stmt = conn.prepareStatement(spl)) {
			
			
			Stmt.setInt(1,userId);
			
			
			//SELECT文を実行し、結果表を取得
			ResultSet rs = Stmt.executeQuery();
			
			while(rs.next()) {
				//ユーザーが存在したらデータを取得
				Customer customer = mapResultSetToCustomer(rs);
				list.add(customer);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return list;
	}
	
	//名前で検索
	public List<Customer> searchByUserIdAndKeyword(int userId, String keyword){
		List<Customer> list = new ArrayList<>();
		//SELECT文を準備
		String sql= "SELECT * FROM customers WHERE user_id = ? and name iLike ? ORDER BY id DESC";
		
		//データベース接続
		try (PreparedStatement stmt = conn.prepareStatement(sql);){
			stmt.setInt(1,userId);
			stmt.setString(2, "%" + keyword + "%");
			
			//SELECT文を実行し、結果表を取得
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Customer customer = mapResultSetToCustomer(rs);
				list.add(customer);
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return list;
	}
	
	public Customer mapResultSetToCustomer(ResultSet rs) throws SQLException {
		Customer c = new Customer();
		
		c.setId(rs.getInt("id"));
        c.setUserId(rs.getInt("user_id"));
        c.setCompanyName(rs.getString("company_name"));
        c.setName(rs.getString("name"));
        c.setBirthday(rs.getDate("birthday"));
        c.setLineId(rs.getString("line_id"));
        c.setKeepBottle(rs.getString("keep_bottle"));
        c.setLikesGolf(rs.getBoolean("likes_golf"));
        c.setMemo(rs.getString("memo"));
        c.setCreatedAt(rs.getTimestamp("created_at"));
        
        return c;
		
	}
	
	public void insert(Customer customer) {
		String sql = 
				"INSERT INTO customers (user_id, company_name, name, birthday, line_id, keep_bottle, likes_golf, memo, created_at) " +
		                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW())";
		
		
		//データベース接続
		try (PreparedStatement stmt = conn.prepareStatement(sql);){
			
			
			stmt.setInt(1, customer.getUserId());
		    stmt.setString(2, customer.getCompanyName());
		    stmt.setString(3, customer.getName());
		    stmt.setDate(4, customer.getBirthday());
		    stmt.setString(5, customer.getLineId());
		    stmt.setString(6, customer.getKeepBottle());
		    stmt.setBoolean(7, customer.isLikesGolf());
		    stmt.setString(8, customer.getMemo());

		    stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
