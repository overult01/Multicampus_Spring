package memberservice_teacher;
//crud�޼ҵ� -> create + read(Ư��id + ���id) + update + delete 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO { 
	
	public int deleteMember(String id) {
		Connection conn = null;
		int rows= 0;
		try {
		// jdbc driver �޸�  �ε�
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db ����
		conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");

/*		Context initContext = new InitialContext();//context.xml ���� ���� ��ü
			//<Resource �±׵� ���� ���� ��ü
		Context envContext = (Context)initContext.lookup("java:/comp/env"); 
			//< jdbc/mydb ���� ��ü
		DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");	
		conn = ds.getConnection();	*/
		System.out.println("mysql db���Ἲ��");
		
		String sql = "delete from member_table where id=?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, id);
		rows = pt.executeUpdate();
		System.out.println(rows);
		
		//conn.close();
		System.out.println(" mysql db������������");
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
		// jdbc driver �޸�  �ε�
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db ����
		conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db���Ἲ��");
		
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
		System.out.println(" mysql db������������");
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
		// jdbc driver �޸�  �ε�
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db ����
		conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db���Ἲ��");
		
		String sql = "select * from member_table where id=? and password=?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, id);
		pt.setString(2, pw);
		ResultSet rs = pt.executeQuery();
		if(rs.next()) { //1��
			dto = new MemberDTO(rs.getString("id") , rs.getString("password"),
					rs.getString("name") , rs.getString("phone"),
					rs.getString("email") , rs.getString("address")
					);
		}
		
		//conn.close();
		System.out.println(" mysql db������������");
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
		// jdbc driver �޸�  �ε�
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db ����
		conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db���Ἲ��");
		
		String sql = "select count(*) from member_table";
		PreparedStatement pt = conn.prepareStatement(sql);
		ResultSet rs = pt.executeQuery();
		rs.next() ;//1���� ����( 0, 10��)
		total = rs.getInt("count(*)");	
		
		//conn.close();
		System.out.println(" mysql db������������");
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
		// jdbc driver �޸�  �ε�
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db ����
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db���Ἲ��");
		
		String sql = "select * from member_table limit ?,?";
		// 1 ������ �Է� (page-1)*userPerPage=0
		// 2�������Է�(2-1)*3=3
		//3 (3-1)*3 = 6
		PreparedStatement pt = conn.prepareStatement(sql);
		/*1�������� 3�� ȸ���� ����Ʈ 
selectMember(1, 3)
1������ ���� ���� - ���� 1������ 0���ε������� 3�� ���� ����Ʈ ���
2������ ���� ���� - ���� 2������ 3���ε������� 3��
3������ ���� ���� - ���� 3������ 6���ε������� 3��
4������ ���� ���� - 9���ε������� 3��*/
		pt.setInt(1, (page-1)*userPerPage);
		pt.setInt(2, userPerPage);
		ResultSet rs = pt.executeQuery();//rs �హ�� 0 �Ǵ� n
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

		
		conn.close();//rs ��ȸ ���̻� �Ұ�
		System.out.println("mysql db������������");	
	}catch(Exception e) {
		e.printStackTrace();
	}
		return list;
	}
	
	public ArrayList<MemberDTO> selectMember() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
		// jdbc driver �޸�  �ε�
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db ����
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db���Ἲ��");
		
		String sql = "select * from member_table";
		PreparedStatement pt = conn.prepareStatement(sql);
		ResultSet rs = pt.executeQuery();//rs �హ�� 0 �Ǵ� n
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

		
		conn.close();//rs ��ȸ ���̻� �Ұ�
		System.out.println("mysql db������������");	
	}catch(Exception e) {
		e.printStackTrace();
	}
		return list;
	}
	
	public int selectMember(String id, String pw) {
		int result = 0;
		try {
		// jdbc driver �޸�  �ε�
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db ����
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db���Ἲ��");
		
		String sql = "select * from member_table where id=?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1 , id);
		ResultSet rs = pt.executeQuery();//rs �హ�� 0 �Ǵ� 1
		if(rs.next() == true) {
			String pwdb = rs.getString("password");
			if(pwdb.equals(pw)) {//��ȣ �����ϸ�
				result = 0;
			}
			else { //��ȣ �������� ������
				result = 1;
			}
		}
		else {//�హ�� 0 = id �������� �ʴ´�
			result = 2;
			
		}
		/*id member_table�� �����ϴ��� Ȯ��
�����Ѵٸ�
�ش�id�� db��ȣ�� pw��ȣ
������ ��
���� return 0
���� �ʴ� return 1
id �������� �ʴ´ٸ� return 2
*/
		
		conn.close();
		System.out.println("mysql db������������");	
	}catch(Exception e) {
		e.printStackTrace();
	}
		return result;
	}

	public void insertMember(MemberDTO dto) {
		
		try {
/*			//1. context = dynamic web project
			 //servlettest ���ü��� ���� 
			 Context initContext = new InitialContext();
			//2. context.xml : ���� �о�Ͷ�.
			 Context envContext = (Context)initContext.lookup("java:/comp/env"); 
			//3. name=jdbc/myoracle ���� ��ü �о�Ͷ�
			 //ds = connectionpool ��ü 
			 DataSource ds = (DataSource)envContext.lookup("jdbc/mydb"); 
			 
			//4. connectionpool ��ü con �����Ͷ�
			 Connection conn = ds.getConnection();
			 System.out.println("��Ǯ �̿�");
			 */
		// jdbc driver �޸�  �ε�
		Class.forName("com.mysql.cj.jdbc.Driver");
		// db ����
		Connection conn = DriverManager.getConnection
		("jdbc:mysql://127.0.0.1:3306/employeesdb", "emp", "emp");
		System.out.println(" mysql db���Ἲ��");
		
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
		System.out.println("mysql db������������");	
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}//CLASS END
