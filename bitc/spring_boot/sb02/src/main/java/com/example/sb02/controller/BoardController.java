package com.example.sb02.controller;

import com.example.sb02.dto.BoardDTO;
import com.example.sb02.dto.BoardListReplyCountDTO;
import com.example.sb02.dto.PageRequestDTO;
import com.example.sb02.dto.PageResponseDTO;
import com.example.sb02.model.Board;
import com.example.sb02.service.BoardService;
import com.example.sb02.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final UploadFileService uploadFileService;

    @GetMapping("/register")
    public void register() {

    }

    @PostMapping("/register")
    public String register(BoardDTO boardDTO) {
//        if(){
//
//        }
        Long bno = boardService.register(boardDTO);
        if (bno != null) {
            log.info(bno);
            return "redirect:/board/list";
        }
        return "redirect:/board/register";
    }

    @GetMapping({"/view", "modify"})
    public void view(Long bno, Model model, PageRequestDTO pageRequestDTO) {
        model.addAttribute("fileList",uploadFileService.getList(bno));
        model.addAttribute("dto", boardService.getBoard(bno));
    }

    @PostMapping("/modify")
    public String modify(BoardDTO boardDTO) {
        Long bno = boardService.modify(boardDTO);
        if (bno != null) {
            return "redirect:/board/view?bno=" + bno;
        }
        return "redirect:/board/modify?bno=" + bno;
    }

    @GetMapping("/remove")
    public String remove(Long bno) {

        uploadFileService.remove(bno);
        boardService.remove(bno);
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        log.info(pageRequestDTO);
//        PageResponseDTO<BoardDTO> responseDTO = boardService.listDsl(pageRequestDTO);
        PageResponseDTO<BoardListReplyCountDTO> responseDTO = boardService.listWithReplyCount(pageRequestDTO);
        log.info(responseDTO);
        model.addAttribute("responseDTO", responseDTO);
    }


//    @GetMapping("/list")
//    public void list(Model model, @PageableDefault(size=5,sort="bno",
//    direction = Sort.Direction.DESC)Pageable pageable){
//        model.addAttribute("msg","list page");
//        List<BoardDTO> boardList=boardService.getList(pageable);
//        model.addAttribute("totalCount",boardService.totalCount());
//        model.addAttribute("boardList",boardList);
//    }

//    @GetMapping("/writer/{writer}")
//    @ResponseBody
//    public List<BoardDTO> getWriter(@PathVariable("writer") String writer){
//        List<BoardDTO> boardList=boardService.getByWriter(writer);
//        return boardList;
//    }
//
//    @GetMapping("/content/{keyword}")
//    @ResponseBody
//    public List<Board> getKeyword(@PathVariable("keyword") String keyword){
//        List<Board> boardList=boardService.getByContent(keyword);
//        return boardList;
//    }
}