package model2.product;

import common.JDBConnect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductDAO extends JDBConnect {

    public ProductDAO() { super(); }

    public int selectCount(Map<String, Object> map) {
        int totalCount = 0;
        String sql = "select count(*) from tbl_product";
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

    public List<ProductDTO> selectPagingList(Map<String, Object> map) {
        List<ProductDTO> bbs = new ArrayList<ProductDTO>();
        String query = "select * from tbl_product";

        if(map.get("searchWord") != null) {
            query += " where " + map.get("searchField")
                    + " like '%" + map.get("searchWord") + "%'";
        }

        query += " order by pcode desc limit ?, ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, Integer.parseInt(map.get("start").toString()));
            pstmt.setInt(2, Integer.parseInt(map.get("pageSize").toString()));
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setPcode(rs.getInt("pcode"));
                dto.setPname(rs.getString("pname"));
                dto.setDescription(rs.getString("description"));
                dto.setPrice(rs.getInt("price"));
                dto.setAmount(rs.getInt("amount"));
                dto.setUser_id(rs.getString("user_id"));
                dto.setVisitcount(rs.getInt("visitcount"));
                bbs.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bbs;
    }

    public int insertWrite(ProductDTO dto) {
        int iResult = -1;

        String sql = "insert into tbl_product(pname, description, price, amount, user_id) values(?,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getPname());
            pstmt.setString(2, dto.getDescription());
            pstmt.setInt(3, dto.getPrice());
            pstmt.setInt(4, dto.getAmount());
            pstmt.setString(5, dto.getUser_id());
            iResult = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return iResult;
    }

    public void updateVisitCount(int pcode) {
        String sql = "update tbl_product set visitcount = visitcount + 1 where pcode = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pcode);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ProductDTO selectView(int pcode) {
        ProductDTO dto = null;
        String sql = "select * from tbl_product where pcode=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pcode);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                dto = new ProductDTO();
                dto.setPcode(pcode);
                dto.setPname(rs.getString("pname"));
                dto.setDescription(rs.getString("description"));
                dto.setPrice(rs.getInt("price"));
                dto.setAmount(rs.getInt("amount"));
                dto.setUser_id(rs.getString("user_id"));
                dto.setVisitcount(rs.getInt("visitcount"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dto;
    }

    public int deletePost(int pcode) {
        int iResult = -1;
        String sql = "delete from tbl_product where pcode=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pcode);
            iResult = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return iResult;
    }

    public int updateEdit(ProductDTO dto) {
        int iResult = -1;
        String sql = "update tbl_product set pname=?, description=?, price=?, amount=? where pcode=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getPname());
            pstmt.setString(2, dto.getDescription());
            pstmt.setInt(3, dto.getPrice());
            pstmt.setInt(4, dto.getAmount());
            pstmt.setInt(5, dto.getPcode());
            iResult = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return iResult;
    }

}
