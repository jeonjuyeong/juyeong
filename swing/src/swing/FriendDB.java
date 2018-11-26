package swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;





public class FriendDB {
	String url,user,pwd;
	public FriendDB() {
		 try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         url ="jdbc:oracle:thin:@localhost:1521:xe";
	         user = "scott";
	         pwd = "TIGER";
	         
	      } 
	      catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	      
	}
	public void insert(Friendcon f) {
		  Connection con = null;
	      PreparedStatement ps = null;
	      try {
	         String sql = "insert into friend values(friend_seq.nextval,?,?,?,?)";
	         con = DriverManager.getConnection(url, user, pwd);
	         ps = con.prepareStatement(sql);
	         ps.setString(1, f.getName());
	         ps.setString(2, f.getBirth());
	         ps.setString(3, f.getPhone());
	         ps.setString(4, f.getAddr());
	         ps.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(ps!=null) ps.close();
	            if(con!=null) con.close();
	            
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	}
	public ArrayList<Friendcon> friendView() {
	    Connection con = null;
	      Statement st = null;
	      ResultSet rs = null;
	      ArrayList<Friendcon> arr = new ArrayList<>();
	      try {
	         con = DriverManager.getConnection(url, user, pwd);
	         String sql = "select * from friend";
	         st = con.createStatement();
	         rs = st.executeQuery(sql);
	         while(rs.next()) {
	        	 Friendcon f = new Friendcon();
	            f.setNum(rs.getInt("num"));
	            f.setName(rs.getString("name"));
	            f.setBirth(rs.getString("birth"));
	            f.setPhone(rs.getString("Phone"));
	            f.setAddr(rs.getString("Addr"));
	            arr.add(f);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(rs!=null)rs.close();
	            if(st!=null) st.close();
	            if(con!=null) con.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return arr;
	}
	public ArrayList<Friendcon> friendSearch(String key, String search) {
		 ArrayList<Friendcon> arr = new ArrayList<>();
	      Connection con = null;
	      ResultSet rs = null;
	      Statement st = null;
	      String sql = "select * from friend where "+key+ " like '%"+search+"%'";
	      try {
	         con = DriverManager.getConnection(url, user, pwd);
	         st = con.createStatement();
	         rs = st.executeQuery(sql);
	         while(rs.next()) {
	               Friendcon f = new Friendcon();
	               f.setNum(rs.getInt("num"));
	               f.setName(rs.getString("name"));
	               f.setBirth(rs.getString("birth"));
	               f.setPhone(rs.getString("phone"));
	               f.setAddr(rs.getString("addr"));
	               arr.add(f);
	         }
	      } catch (SQLException e) {
	        
	         e.printStackTrace();
	      }finally {
	         try {
	            if(rs!=null)rs.close();
	            if(st!=null) st.close();
	            if(con!=null) con.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return arr;
	
	}

}
