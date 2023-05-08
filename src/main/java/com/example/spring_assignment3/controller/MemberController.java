package com.example.spring_assignment3.controller;

import com.example.spring_assignment3.dto.MemberDetailDto;
import com.example.spring_assignment3.entity.Member;
import com.example.spring_assignment3.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class MemberController {
    private final MemberService memberService;


    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member")
    public String showMember(Model model) {
        model.addAttribute("MemberDetailDto", new MemberDetailDto());
        return "member/edit";
    }

    @GetMapping("/member/edit/{id}")
    public String showEditMember(Model model, @PathVariable Long id) {
        Optional<Member> memberOptional = memberService.findById(id);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            MemberDetailDto memberDetailDto = new MemberDetailDto();
            BeanUtils.copyProperties(member, memberDetailDto);
            model.addAttribute("memberDetailDto", memberDetailDto);
            return "member/edit";
        }
        return "redirect:/member";
    }

    @PostMapping("/member/edit/{id}")
    public String editMember(Model model, @PathVariable(name="id") Long id, @Valid MemberDetailDto memberDetailDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "member/edit";
        }
        Optional<Member> memberOptional = memberService.findById(id);
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            BeanUtils.copyProperties(memberDetailDto, member);
            memberService.save(member);
            redirectAttributes.addFlashAttribute("successMessage", "member.update.success");
            return "redirect:/content";
        }
        return "redirect:/member/edit/" + id;
    }


}
