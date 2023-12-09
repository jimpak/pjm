package org.pjm.springexam03.controller;

import lombok.extern.log4j.Log4j2;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.pjm.springexam03.dto.SampleDTO;
import org.pjm.springexam03.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    private SampleService sampleService;

    @GetMapping("/ex02")
    public void ex02() {
        int i = Integer.parseInt("aaa");
    }

    @GetMapping("/write")
    public void write() {
    }

    @PostMapping("/write")
    public String writePro(@ModelAttribute("sample") SampleDTO sample){
        sampleService.insert(sample);
        return "redirect:/sample/list";
    }


    @GetMapping("/list")
    public void list(Model model) {
        List<SampleDTO> sampleDTOS = sampleService.getList();
        model.addAttribute("sampleList", sampleDTOS);
    }

//    //  SampleDTO sampleDTO로 설정 시 model객체 필요 X
//    @PostMapping("/write")
//    public String writePro(SampleDTO sample) {
//        return "sample/view";
//    }

//    // SampleDTO 객체명을 다르게 사용하고 싶다면 model객체를 활용해서 사용.
//    @PostMapping("/write")
//    public String writePro(SampleDTO sample, Model model) {
//        model.addAttribute("sample", sample);
//        return "sample/view";
//    }

//    @PostMapping("/write")
//    public String writePro(@ModelAttribute("sample") SampleDTO sample){
//        return "sample/view";
//    }


    @GetMapping({"/view","/update"})
    public void view(@RequestParam("idx") int idx, Model model){
        SampleDTO dto=sampleService.getDTO(idx);
        model.addAttribute("sample",dto);
    }
    @PostMapping("/update")
    public String update(SampleDTO sampleDTO){
        sampleService.modify(sampleDTO);
        return "redirect:/sample/view?idx="+sampleDTO.getIdx();
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("idx") int idx){
        sampleService.remove(idx);
        return "redirect:/sample/list";
    }


//    @GetMapping("/ex01")
//    public String ex01(RedirectAttributes attributes) {
//        attributes.addAttribute("name", "홍길동");
//        attributes.addFlashAttribute("age", "20"); // 페이지 열릴때 한번만 값을 가져옴.
//        return "redirect:ex02";
//    }
//
//    @GetMapping("ex02")
//    public void ex02(){}
}
