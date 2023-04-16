package thien.fa.com.internet.controller;

import java.util.List;

import javax.validation.Valid;

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

import thien.fa.com.internet.entities.KhachHang;
import thien.fa.com.internet.page.PageAble;
import thien.fa.com.internet.service.KhachHangServiceImpl;
import thien.fa.com.internet.utils.Validation;

@Controller
@RequestMapping("/khachhang")
public class KhachHangController {

  @Autowired
  private KhachHangServiceImpl khachHangServiceImpl;

  @GetMapping("/list")
  public String getAllmayWithPageAble(Model model,
      @RequestParam(defaultValue = "1") Integer page) {
    PageAble pageAble = new PageAble(page);
    List<KhachHang> khachHangs = khachHangServiceImpl
        .findWithPageAble(pageAble);
    model.addAttribute("khachHangs", khachHangs);
    model.addAttribute("totalPages", khachHangServiceImpl.totalPages(pageAble));
    model.addAttribute("currentPage", page);

    return "/khachhang/list";
  }

  @GetMapping("/add")
  public String showAddForm(Model model) {
    model.addAttribute("khachHangForm", new KhachHang());
    return "/khachhang/new";
  }

  @PostMapping("/save")
  public String addNewmay(
      @ModelAttribute(name = "khachHangForm") @Valid KhachHang kh,
      BindingResult result, Model model) {
    
    if (kh.getMaKH().isEmpty() || !Validation.checkValidKHID(kh.getMaKH())) {
      model.addAttribute("MESS", "ID error");

      return "/khachhang/new";
    }
    if (kh.getDiaChiEmail().isEmpty() || !Validation.checkValidKHEmail(kh.getDiaChiEmail())) {
      model.addAttribute("MESS", "Email error");
      
      return "/khachhang/new";
    }
    if (kh.getSoDienThoai().isEmpty() || !Validation.checkValidKHPhone(kh.getSoDienThoai())) {
      model.addAttribute("MESS", "Phone error");
      
      return "/khachhang/new";
    }

    if (result.hasErrors()) {
      return "/khachhang/new";
    }

    khachHangServiceImpl.saveOrUpdate(kh);
    return "redirect:/khachhang/list";
  }

  @GetMapping("/delete")
  public String delete(@RequestParam(name = "id") String mayId) {
    khachHangServiceImpl.delete(mayId);
    return "redirect:/khachhang/list";
  }

  @RequestMapping("/update/{id}")
  public String update(@PathVariable(name = "id") String mayId, Model model) {
    KhachHang khachHang = khachHangServiceImpl.findById(mayId);
    model.addAttribute("khachHangForm", khachHang);
    return "/khachhang/new";
  }

  @GetMapping(value = "/search")
  public String searchKhachHang(Model model, @RequestParam(defaultValue = "1") Integer page,
          @RequestParam(name = "searchKey", defaultValue = "") String searchKey) {
      PageAble pageAble = new PageAble(page);
      List<KhachHang> listKhachHang = khachHangServiceImpl.searchKhachHang(searchKey, pageAble);
      model.addAttribute("listKhachHang", listKhachHang);
      model.addAttribute("maMay", searchKey);
      model.addAttribute("totalPages", khachHangServiceImpl.totalPages(pageAble));
      model.addAttribute("currentPage", page);
      return "khachhang/search";
  }
}
