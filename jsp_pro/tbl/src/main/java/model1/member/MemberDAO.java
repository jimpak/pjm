package model1.member;

import common.JDBConnect;

public class MemberDAO extends JDBConnect {

    public MemberDAO(){}

    public MemberDAO(String driver, String url, String id, String pwd) {
        super(driver, url, id, pwd);
    }

    public MemberDTO getMemberDTO(String uid, String upass) {
        MemberDTO dto = new MemberDTO();
        String query = "SELECT * FROM tbl_member WHERE user_id=? AND user_pass=?";

        try {
            pstmt = conn.prepareStatement(query); // 동적 쿼리문 준비
            pstmt.setString(1, uid); // 쿼리문의 첫 번째 인파라미터에 값 설정
            pstmt.setString(2, upass); // 쿼리문의 두 번째 인파라미터에 값 설정
            rs = pstmt.executeQuery(); // 쿼리문 실행

            if(rs.next()) {
                // 쿼리 결가로 얻은 회원 정보를 DTO에 저장
                dto.setUser_id(rs.getString("user_id"));
                dto.setUser_pass(rs.getString("user_pass"));
                dto.setUser_name(rs.getString("user_name"));
                dto.setRegidate(rs.getDate("regidate"));
                dto.setMilage(rs.getInt("milage"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

}
