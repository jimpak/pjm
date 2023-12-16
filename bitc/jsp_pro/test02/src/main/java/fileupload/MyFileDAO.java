package fileupload;

import common.MySQLConnectPool;

import java.util.ArrayList;
import java.util.List;

public class MyFileDAO extends MySQLConnectPool {

    public MyFileDAO() {
        super();
    }

    public int insertFile(MyFileDTO dto) {
        int result = 0;
        String sql = "insert into myfile(title, cate, ofile, sfile) value(?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getCate());
            pstmt.setString(3, dto.getOfile());
            pstmt.setString(4, dto.getSfile());
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<MyFileDTO> selectFileList() {
        List<MyFileDTO> fileList = new ArrayList<MyFileDTO>();
        String sql = "select * from myfile";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                MyFileDTO dto = new MyFileDTO();
                dto.setIdx(rs.getInt("idx"));
                dto.setTitle(rs.getString("title"));
                dto.setCate(rs.getString("cate"));
                dto.setOfile(rs.getString("ofile"));
                dto.setSfile(rs.getString("sfile"));
                dto.setPostdate(rs.getDate("postdate"));
                fileList.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileList;
    }

}
