package Controller;


import Entity.Content;
import Service.ContentService;
import constant.AppConstant;
import dto.ContentDetailDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ContentController {
    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/content")
    public String showContent(Model model,
                              @RequestParam(required = false, defaultValue = AppConstant.DEFAULT_PAGE_STR) Integer page,
                              @RequestParam(required = false, defaultValue = AppConstant.DEFAULT_PAGE_SIZE_STR) Integer size,
                              @RequestParam(required = false, name = "search") Optional<String> keywordOpt) {
        Specification<Content> spec = (root, query, criteriaBuilder) -> {
            if (keywordOpt.isPresent()) {
                return criteriaBuilder.or(
                        criteriaBuilder.like(root.get("title"), "%" + keywordOpt.get() + "%"),
                        criteriaBuilder.like(root.get("brief"), "%" + keywordOpt.get() + "%")
                );
            } else {
                return criteriaBuilder.conjunction();
            }
        };

        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Content> contentPage = contentService.findAllPaging(spec, pageRequest);
        model.addAttribute("contentPage", contentPage);
        return "Content/View";


    }


    @PostMapping("/content/add")
    public String addContent(@Valid ContentDetailDto contentDetailDto, BindingResult
            bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "Content/Add";
        }
        Content content = new Content();
        BeanUtils.copyProperties(contentDetailDto, content);
        contentService.create(content);
        redirectAttributes.addFlashAttribute("successMessage", "content.create.success");
        return "redirect:/content";

    }

}




