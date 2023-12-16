package model2.member;

import common.MySQLConPool;

public class MemberDAO extends MySQLConPool {

    public MemberDAO(){ super(); }


    public MemberDTO getMemberDTO(String uid, String upass) {
        MemberDTO dto = new MemberDTO();
        String query = "SELECT * FROM tbl_member WHERE id=? AND pass=?";

        try {
            pstmt = conn.prepareStatement(query); // 동적 쿼리문 준비
            pstmt.setString(1, uid); // 쿼리문의 첫 번째 인파라미터에 값 설정
            pstmt.setString(2, upass); // 쿼리문의 두 번째 인파라미터에 값 설정
            rs = pstmt.executeQuery(); // 쿼리문 실행

            if(rs.next()) {
                // 쿼리 결가로 얻은 회원 정보를 DTO에 저장
                dto.setId(rs.getString("id"));
                dto.setPass(rs.getString("pass"));
                dto.setUser_name(rs.getString("user_name"));
                dto.setRegidate(rs.getDate("regidate"));
                dto.setMileage(rs.getInt("mileage"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    public int insertRegister(MemberDTO dto) {
        int iResult = -1;

        String sql = "insert into tbl_member(id, pass, user_name) values(?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPass());
            pstmt.setString(3, dto.getUser_name());
            iResult = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return iResult;
    }

    public MemberDTO selectInfo(String userId) {
        MemberDTO dto = null;
        String sql = "select * from tbl_member where id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                dto = new MemberDTO();
                dto.setId(userId);
                dto.setPass(rs.getString("pass"));
                dto.setUser_name(rs.getString("user_name"));
                dto.setRegidate(rs.getDate("regidate"));
                dto.setMileage(rs.getInt("mileage"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dto;
    }

    public void mileageUpWrite(String id) {
        String sql = "update tbl_member set mileage = mileage + 10 where id = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mileageUpReply(String id) {
        String sql = "update tbl_member set mileage = mileage + 5 where id = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
