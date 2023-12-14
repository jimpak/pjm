package com.example.sp_jpa01.controller;

import com.example.sp_jpa01.model.Board;
import com.example.sp_jpa01.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public void list(Model model) {
        List<Board> boardList = boardService.getList();
        model.addAttribute("boardList", boardList);
    }

    @GetMapping("/register")
    public void registerGet() {

    }

    @PostMapping("/register")
    public String registerPost(Board board) {
        board = boardService.register(board);
        if (board == null && board.equals(null)) {
            return "redirect:/board/register";
        }
        return "redirect:/board/list";
    }


//    @GetMapping("/remove")
//    public String remove(@RequestParam("bno") int bno){
//        int result=boardService.remove(bno);
//        if(result==1){
//            return "redirect:/board/list";
//        }
//        return "redirect:/board/view?bno="+bno;
//    }
//
//    @PostMapping("/modify")
//    public String modify(Board board) {
//        Board result=boardService.modify(board);
//        if(result==1){
//            return "redirect:/board/view?bno="+dto.getBno();
//        }
//        return "redirect:/board/modify?bno="+dto.getBno();
//    }
//
//    @GetMapping({"/view", "/modify"})
//    public void get(@RequestParam("bno") int bno, Model model) {
//        model.addAttribute("board", boardService.getBoard(bno));
//    }

}
