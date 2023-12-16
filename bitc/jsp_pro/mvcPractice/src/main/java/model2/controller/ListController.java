package model2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model2.product.ProductDAO;
import model2.product.ProductDTO;
import utils.ProductPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/product/list.do")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        Map<String, Object> map = new HashMap<>();

        String searchField = req.getParameter("searchField");
        String searchWord = req.getParameter("searchWord");

        if(searchWord != null) {
            map.put("searchField", searchField);
            map.put("searchWord", searchWord);
        } else {
            searchField = "";
            searchWord = "";
        }

        int pageSize = 10;
        int blockSize = 5;
        int pageNum = 1;

        String pageTemp = req.getParameter("pageNum");
        if(pageTemp != null && !pageTemp.equals("")) {
            pageNum = Integer.parseInt(pageTemp);
        }

        int start = (pageNum - 1) * pageSize;
//        오라클 페이징
//        int start = (pageNum - 1) * pageSize + 1;
//        int end = pageNum * pageSize;

        map.put("start", start);
        map.put("pageSize", pageSize);

        int totalcount = dao.selectCount(map);
        List<ProductDTO> productList = dao.selectList(map);
        dao.close();

        String pagingImg = ProductPage.pagingStr(totalcount, pageSize, blockSize, pageNum, searchField, searchWord, "/product/list.do");

        map.put("pageImg", pagingImg);
        map.put("pageSize", pageSize);
        map.put("pageNum", pageNum);

        req.setAttribute("map", map);
        req.setAttribute("totalCount", totalcount);
        req.setAttribute("productList", productList);

        req.getRequestDispatcher("/product/list.jsp").forward(req, resp);
    }
}
