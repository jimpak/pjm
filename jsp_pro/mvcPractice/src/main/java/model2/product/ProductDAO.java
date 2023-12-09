package model2.product;

import common.MySQLConPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductDAO extends MySQLConPool {

    public ProductDAO() { super(); }

    public int selectCount(Map<String, Object> map) {
        int totalCount = 0;
        String sql = "select count(*) from tbl_product";
        if(map.get("searchWord") != null && !map.get("searchWord").equals("")) {
            sql += " where " + map.get("searchField")
                    + " like '%" + map.get("searchWord") + "%'";
        }

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                totalCount = rs.getInt(1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return totalCount;
    }

    public List<ProductDTO> selectList(Map<String, Object> map) {
        List<ProductDTO> products = new ArrayList<ProductDTO>();
        String sql = "select * from tbl_product";
        if(map.get("searchWord") != null && !map.get("searchWord").equals("")) {
            sql += " where " + map.get("searchField")
                    + " like '%" + map.get("searchWord") + "%'";
        }
        sql += " order by pcode desc limit ?, ?";

        try {
            pstmt = conn.prepareStatement(sql);
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
                dto.setPostdate(rs.getDate("postdate"));
                dto.setVisitcount(rs.getInt("visitcount"));
                dto.setOfile(rs.getString("ofile"));
                dto.setSfile(rs.getString("sfile"));
                dto.setDowncount(rs.getInt("downcount"));
                dto.setReplycount(rs.getInt("replycount"));
                products.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public int insertProduct(ProductDTO dto) {
        int result = 0;
        String sql = "insert into tbl_product(pname, description, price, amount, user_id, ofile, sfile) " +
                " values(?,?,?,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getPname());
            pstmt.setString(2, dto.getDescription());
            pstmt.setInt(3, dto.getPrice());
            pstmt.setInt(4, dto.getAmount());
            pstmt.setString(5, dto.getUser_id());
            pstmt.setString(6, dto.getOfile());
            pstmt.setString(7, dto.getSfile());
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
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
        ProductDTO product = null;
        String sql = "select * from tbl_product where pcode = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pcode);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                product = new ProductDTO();
                product.setPcode(pcode);
                product.setPname(rs.getString("pname"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                product.setAmount(rs.getInt("amount"));
                product.setUser_id(rs.getString("user_id"));
                product.setPostdate(rs.getDate("postdate"));
                product.setVisitcount(rs.getInt("visitcount"));
                product.setOfile(rs.getString("ofile"));
                product.setSfile(rs.getString("sfile"));
                product.setDowncount(rs.getInt("downcount"));
                product.setReplycount(rs.getInt("replycount"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<ReplyDTO> selectListReply(int pcode) {
        List<ReplyDTO> replyDTOList = new ArrayList<>();
        String sql = "select * from tbl_reply where pcode=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, pcode);
            rs=pstmt.executeQuery();
            while (rs.next()) {
                ReplyDTO dto = new ReplyDTO();
                dto.setRnum(rs.getInt("rnum"));
                dto.setPcode(pcode);
                dto.setUser_id(rs.getString("user_id"));
                dto.setContent(rs.getString("content"));
                dto.setPostdate(rs.getDate("postdate"));
                replyDTOList.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  replyDTOList;
    }

    public void downCountPlus(int idx) {
        String sql = "update tbl_product set downcount = downcount + 1 where idx = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idx);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insertReply(ReplyDTO dto) {
        int result = 0;
        String sql = "insert tbl_reply(pcode, user_id, content) values(?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getPcode());
            pstmt.setString(2, dto.getUser_id());
            pstmt.setString(3, dto.getContent());
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public int replyDelete(int rnum) {
        int result = 0;
        String sql = "delete from tbl_reply where rnum=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, rnum);
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("delete실행");
        return result;
    }

    public int update(ProductDTO dto) {
        int result = 0;
        String sql = "update tbl_product set pname=?, description=?, price=?, amount=?, ofile=?, sfile=? where pcode=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getPname());
            pstmt.setString(2, dto.getDescription());
            pstmt.setInt(3, dto.getPrice());
            pstmt.setInt(4, dto.getAmount());
            pstmt.setString(5, dto.getOfile());
            pstmt.setString(6, dto.getSfile());
            pstmt.setInt(7, dto.getPcode());
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
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
}
