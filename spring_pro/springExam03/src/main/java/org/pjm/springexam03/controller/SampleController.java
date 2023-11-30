package org.pjm.springexam03.controller;

import lombok.extern.log4j.Log4j2;
import org.pjm.springexam03.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("write")
    public void write() {
    }
//    @PostMapping("/write")
//    public String writePro(SampleDTO sampleDTO, Model model) {
////        model.addAttribute("sampleDTO", sampleDTO);
//        return "sample/view";
//    }
    @PostMapping("/write")
    public String writePro(@ModelAttribute("sampleDTO") SampleDTO sampleDTO,
    RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("sampleDTO", sampleDTO);
        return "redirect:/sample/view";
    }

    @GetMapping("/view")
    public void view() {

    }
}
