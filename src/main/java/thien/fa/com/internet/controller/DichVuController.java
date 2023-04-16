package thien.fa.com.internet.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thien.fa.com.internet.entities.DichVu;
import thien.fa.com.internet.page.PageAble;
import thien.fa.com.internet.service.DichVuService;

@Controller
@RequestMapping("/dichvu")
public class DichVuController {
  
  @Autowired
  private DichVuService dichVuService;
  
  @GetMapping("/list")
  public String getAllmayWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
    PageAble pageAble = new PageAble(page);
    List<DichVu> dichVus = dichVuService.findWithPageAble(pageAble);
    model.addAttribute("dichVus", dichVus);
    model.addAttribute("totalPages", dichVuService.totalPages(pageAble));
    model.addAttribute("currentPage", page);

    return "/dichvu/list";
  }

  @GetMapping("/add")
  public String showAddForm(Model model) {
    model.addAttribute("dichVuForm", new DichVu());
    return "/dichvu/new";
  }

  @PostMapping("/save")
  public String addNewmay(@ModelAttribute(name = "dichVuForm") @Valid DichVu may, BindingResult result) {
    if (result.hasErrors()) {
      return "/dichvu/new";
    }
    dichVuService.saveOrUpdate(may);
    return "redirect:/dichvu/list";
  }

  @GetMapping("/delete")
  public String delete(@RequestParam(name = "id") String mayId) {
    dichVuService.delete(mayId);
    return "redirect:/dichvu/list";
  }

  @RequestMapping("/update/{id}")
  public String update(@PathVariable(name = "id") String mayId, Model model) {
    DichVu khachHang = dichVuService.findById(mayId);
    model.addAttribute("khachHangForm", khachHang);
    return "/dichvu/new";
  }
  
  @GetMapping(value = "/search")
  public String searchDichVu(Model model, @RequestParam(defaultValue = "1") Integer page,
          @RequestParam(name = "searchKey", defaultValue = "") String searchKey) {
      PageAble pageAble = new PageAble(page);
      List<DichVu> listDichVu = dichVuService.searchDichVu(StringUtils.stripAccents(searchKey), pageAble);
      model.addAttribute("listDichVu", listDichVu);
      model.addAttribute("maMay", searchKey);
      model.addAttribute("totalPages", dichVuService.totalPages(pageAble));
      model.addAttribute("currentPage", page);
      return "dichvu/search";
  }


}
