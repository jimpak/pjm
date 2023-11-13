package model1.board;

import common.JDBConnect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardDAO extends JDBConnect {
    public BoardDAO() {
        super();
    }

    public int selectCount(Map<String, Object> map) {
        int totalCount = 0;
        String sql = "select count(*) from board";
        if(map.get("searchWord") != null) {
            sql += " where " + map.get("searchField") + " ";
            sql += " like '%" + map.get("searchWord") + "%'";
        }

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                totalCount = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalCount;
    }

    public List<BoardDTO> selectList(Map<String, Object> map) {

        List<BoardDTO> bbs = new ArrayList<BoardDTO>();
        String sql = "select * from board";
        if(map.get("searchWord") != null) {
            sql += " where " + map.get("searchField") + " ";
            sql += " like '%" + map.get("searchWord") + "%'";
        }
        sql += " order by num DESC";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                BoardDTO dto = new BoardDTO();
                dto.setNum(rs.getInt("num"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setId(rs.getString("id"));
                dto.setPostdate(rs.getDate("postdate"));
                dto.setVisitcount(rs.getInt("visitcount"));
                bbs.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bbs;
    }

}
