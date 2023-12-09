//package org.pjm.springexam01.dao;
//
//import org.pjm.springexam01.dto.SampleDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class SampleDAO1 {
//    @Autowired
//    DataSource dataSource;
//    Connection connection;
//    public Connection getConnect() throws Exception {
//        connection = dataSource.getConnection();
//        return connection;
//    }
//    public List<SampleDTO> selectList() throws Exception {
//        List<SampleDTO> sampleDTOS = new ArrayList<>();
//        String sql = "select * from tbl_sample";
//
//        PreparedStatement ps = getConnect().prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            SampleDTO dto = new SampleDTO();
//            dto.setIdx(rs.getInt("idx"));
//            dto.setName(rs.getString("name"));
//            dto.setAge(rs.getInt("age"));
//            dto.setPhone(rs.getString("phone"));
//            dto.setPostdate(rs.getDate("postdate"));
//            sampleDTOS.add(dto);
//        }
//        if(rs != null) rs.close();
//        if(ps != null) rs.close();
//        if(connection != null) rs.close();
//        return sampleDTOS;
//    }
//}
