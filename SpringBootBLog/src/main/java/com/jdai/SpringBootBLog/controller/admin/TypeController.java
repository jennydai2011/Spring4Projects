package com.jdai.SpringBootBLog.controller.admin;

import com.jdai.SpringBootBLog.po.Type;
import com.jdai.SpringBootBLog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                        Model model){
        model.addAttribute("page",  typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type", new Type());
        return "admin/type-input";
    }

    @GetMapping("/types/{id}")
    public String editInput(@PathVariable("id") Long id, Model model){
        model.addAttribute("type", typeService.getType(id));
        return "admin/type-input";
    }
    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result,  RedirectAttributes attributes){
        if(typeService.getTypeByName(type.getName()) !=null){
            result.rejectValue("name", "nameError：", "不能添加重复分类");
        }
        if(result.hasErrors()){
            return "admin/type-input";
        }
        Type t = typeService.saveType(type);
        if( t== null){
            //UI message
            attributes.addFlashAttribute("message", "添加失败");
        }else{
            attributes.addFlashAttribute("message" , "添加成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attributes){
       typeService.deleteType(id);

        Type t = typeService.getType(id);
        if( t== null){
            //UI message
            attributes.addFlashAttribute("message", "删除失败");
        }else{
            attributes.addFlashAttribute("message" , "删除成功");
        }

        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, BindingResult result, @PathVariable Long id,
                           RedirectAttributes attributes){
        if(typeService.getTypeByName(type.getName()) !=null){
            result.rejectValue("name", "nameError：", "不能添加重复分类");
        }
        if(result.hasErrors()){
            return "admin/type-input";
        }
        Type t = typeService.updateType(id, type);
        if( t== null){
            //UI message
            attributes.addFlashAttribute("message", "更新失败");
        }else{
            attributes.addFlashAttribute("message" , "更新成功");
        }
        return "redirect:/admin/types";
    }

}
