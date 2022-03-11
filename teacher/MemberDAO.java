package dao;
//crud메소드 -> create + read(특정id + 모든id) + update + delete 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.MemberDTO;

public class MemberDAO { 
	public int deleteMember(String id) {
		Connection conn = null;
		int rows= 0;
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");

/*		Context initContext = new InitialContext();//context.xml 파일 내용 객체
			//<Resource 태그들 설정 내용 객체
		Context envContext = (Context)initContext.lookup("java:/comp/env"); 
			//< jdbc/mydb 설정 객체
		DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");	
		conn = ds.getConnection();	*/
		System.out.println("mysql db연결성공");
		
		String sql = "delete from member_table where id=?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, id);
		rows = pt.executeUpdate();
		System.out.println(rows);
		
		//conn.close();
		System.out.println(" mysql db연결해제성공");
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		}catch(SQLException e) {}
	}
		return rows;
	}

	public void updateMember(MemberDTO dto) {//password name address
		Connection conn = null;
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db연결성공");
		
		String sql = "update member_table set password=?, name=?, address=?"
				+ " where id=?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, dto.getPassword());
		pt.setString(2, dto.getName());
		pt.setString(3, dto.getAddress());
		pt.setString(4, dto.getId());//login id 		
		int rows = pt.executeUpdate();
		System.out.println(rows);
		
		//conn.close();
		System.out.println(" mysql db연결해제성공");
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		}catch(SQLException e) {}
	}
	}
	
	public MemberDTO updateFormMember(String id, String pw) {
		Connection conn = null;
		MemberDTO dto = null;
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db연결성공");
		
		String sql = "select * from member_table where id=? and password=?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, id);
		pt.setString(2, pw);
		ResultSet rs = pt.executeQuery();
		if(rs.next()) { //1개
			dto = new MemberDTO(rs.getString("id") , rs.getString("password"),
					rs.getString("name") , rs.getString("phone"),
					rs.getString("email") , rs.getString("address")
					);
		}
		
		//conn.close();
		System.out.println(" mysql db연결해제성공");
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		}catch(SQLException e) {}
	}
		return dto;	
	}
	
	public int getTotalCount() {
		Connection conn = null;
		int total = 0;
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db연결성공");
		
		String sql = "select count(*) from member_table";
		PreparedStatement pt = conn.prepareStatement(sql);
		ResultSet rs = pt.executeQuery();
		rs.next() ;//1개행 리턴( 0, 10값)
		total = rs.getInt("count(*)");	
		
		//conn.close();
		System.out.println(" mysql db연결해제성공");
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		}catch(SQLException e) {}
	}
		return total;	
	}//getTotalCount 
	
	public ArrayList<MemberDTO> selectMember(int page, int userPerPage) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db연결성공");
		
		String sql = "select * from member_table limit ?,?";
		// 1 페이지 입력 (page-1)*userPerPage=0
		// 2페이지입력(2-1)*3=3
		//3 (3-1)*3 = 6
		PreparedStatement pt = conn.prepareStatement(sql);
		/*1페이지당 3명 회원들 리스트 
selectMember(1, 3)
1페이지 선택 전달 - 서블릿 1페이지 0번인덱스부터 3개 정보 리스트 출력
2페이지 선택 전달 - 서블릿 2페이지 3번인덱스부터 3개
3페이지 선택 전달 - 서블릿 3페이지 6번인덱스부터 3개
4페이지 선택 전달 - 9번인덱스부터 3개*/
		pt.setInt(1, (page-1)*userPerPage);
		pt.setInt(2, userPerPage);
		ResultSet rs = pt.executeQuery();//rs 행갯수 0 또는 n
		while(rs.next() == true) {
			MemberDTO dto = new MemberDTO(
					rs.getString("id"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("phone"),
					rs.getString("email"),
					rs.getString("address")
					);
			list.add(dto);
		}//while end

		
		conn.close();//rs 조회 더이상 불가
		System.out.println("mysql db연결해제성공");	
	}catch(Exception e) {
		e.printStackTrace();
	}
		return list;
	}
	
	public ArrayList<MemberDTO> selectMember() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db연결성공");
		
		String sql = "select * from member_table";
		PreparedStatement pt = conn.prepareStatement(sql);
		ResultSet rs = pt.executeQuery();//rs 행갯수 0 또는 n
		while(rs.next() == true) {
			MemberDTO dto = new MemberDTO(
					rs.getString("id"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("phone"),
					rs.getString("email"),
					rs.getString("address")
					);
			list.add(dto);
		}//while end

		
		conn.close();//rs 조회 더이상 불가
		System.out.println("mysql db연결해제성공");	
	}catch(Exception e) {
		e.printStackTrace();
	}
		return list;
	}
	
	public int selectMember(String id, String pw) {
		int result = 0;
		try {
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db연결성공");
		
		String sql = "select * from member_table where id=?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1 , id);
		ResultSet rs = pt.executeQuery();//rs 행갯수 0 또는 1
		if(rs.next() == true) {
			String pwdb = rs.getString("password");
			if(pwdb.equals(pw)) {//암호 동일하면
				result = 0;
			}
			else { //암호 동일하지 않으면
				result = 1;
			}
		}
		else {//행갯수 0 = id 존재하지 않는다
			result = 2;
			
		}
		/*id member_table에 존재하는지 확인
존재한다면
해당id의 db암호와 pw암호
같은지 비교
같다 return 0
같지 않다 return 1
id 존재하지 않는다면 return 2
*/
		
		conn.close();
		System.out.println("mysql db연결해제성공");	
	}catch(Exception e) {
		e.printStackTrace();
	}
		return result;
	}

	public void insertMember(MemberDTO dto) {
		
		try {
/*			//1. context = dynamic web project
			 //servlettest 관련설정 가능 
			 Context initContext = new InitialContext();
			//2. context.xml : 설정 읽어와라.
			 Context envContext = (Context)initContext.lookup("java:/comp/env"); 
			//3. name=jdbc/myoracle 설정 객체 읽어와라
			 //ds = connectionpool 객체 
			 DataSource ds = (DataSource)envContext.lookup("jdbc/mydb"); 
			 
			//4. connectionpool 객체 con 빌려와라
			 Connection conn = ds.getConnection();
			 System.out.println("컨풀 이용");
			 */
		// jdbc driver 메모리  로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db 연결
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db연결성공");
		
		String sql = "insert into member_table values(?,?,?,?,?,?)";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setNString(1 , dto.getId());
		pt.setNString(2 , dto.getPassword());
		pt.setNString(3 , dto.getName());
		pt.setNString(4 , dto.getPhone());
		pt.setNString(5 , dto.getEmail());
		pt.setNString(6 , dto.getAddress());

		pt.executeLargeUpdate();
		conn.close();
		System.out.println("mysql db연결해제성공");	
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}//CLASS END
