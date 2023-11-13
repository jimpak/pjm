package model1.member;

import common.JDBConnect;
import jakarta.servlet.ServletContext;

public class MemberDAO extends JDBConnect {

    // 명시한 데이터베이스로의 연결이 완료딘 MemberDAO 객체를 생성.
    public MemberDAO(){}

    public MemberDAO(String drv, String url, String id, String pw) {
        super(drv, url, id, pw);
    }

    // 명시한 아이디/패스워드와 일치하는 회원 정보를 반환.
    public MemberDTO getMemberDTO(String uid, String upass) {
        MemberDTO dto = new MemberDTO();
        String query = "SELECT * FROM member WHERE id=? AND pass=?";

        try {
            pstmt = conn.prepareStatement(query); // 동적 쿼리문 준비
            pstmt.setString(1, uid); // 쿼리문의 첫 번째 인파라미터에 값 설정
            pstmt.setString(2, upass); // 쿼리문의 두 번째 인파라미터에 값 설정
            rs = pstmt.executeQuery(); // 쿼리문 실행

            if(rs.next()) {
                // 쿼리 결가로 얻은 회원 정보를 DTO에 저장
                dto.setId(rs.getString("id"));
                dto.setPass(rs.getString("pass"));
                dto.setName(rs.getString("name"));
                dto.setRegidate(rs.getDate("regidate"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }
}