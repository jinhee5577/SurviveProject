package problemDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import questionDTO.QuestionDTO;

public class ProblemDAO {
	// 데이터를 접근해서 가져오자.
	private Connection conn; // 이안에서만 접근 가능.
	private PreparedStatement psmt; // 이안에서만 접근 가능.
	private ResultSet rs; // 이안에서만 접근 가능.

	// Connect 메소드
	private void getConn() { // DB연결 메소드, 외부에서 접근 못하게 숨겨버리자.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 어떤 db를 사용할것인지.

			String user = "mp_21K_bigdata22_p1_1";
			String pw = "smhrd1";
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";

			conn = DriverManager.getConnection(url, user, pw); // 이메서드를 통해서 연결이됨.
			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// close하는 메서드
	private void allClose() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) { // close()에서 SQLException에러가 발생할수 있어서 요기 catch문에서 에러 받아준다.
			e.printStackTrace();
		}
	}

	
	
	// 선택 문제 가져오는 기능 메서드
	public QuestionDTO searchProblem(String level, int n) {
		// 각메소드 마다 db연결 해주자.
		getConn();

		try {
			// sql통과 통로
			String sql = "select * from QNA_TB where Q_LEVEL = ? AND Q_NUM = ?";
			psmt = conn.prepareStatement(sql); // psmt 문 열었고

			// sql문 psmt통로 넘겨 주기전에 ?채우기 - ?가 없으면 생략.
			psmt.setString(1, level);
			psmt.setInt(2, n);

			rs = psmt.executeQuery(); // 여긴 sql - select문이 executeQuery()를 써야함.

			if (rs.next()) {
				String problem = rs.getString("QUESTION");
				int num = rs.getInt("Q_NUM");
				String answer = rs.getString("ANSWER");
				
				QuestionDTO qdto = new QuestionDTO(problem, num, answer); // obj에 담아서 뱉어줄거야.
				return qdto;
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// 이메소드에서 할일 끝났으니 문닫자.
			allClose();
		}
	}

	
	


}
