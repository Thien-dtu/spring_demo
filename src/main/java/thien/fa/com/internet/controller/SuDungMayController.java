package thien.fa.com.internet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thien.fa.com.internet.entities.KhachHang;
import thien.fa.com.internet.entities.May;
import thien.fa.com.internet.entities.SuDungMay;
import thien.fa.com.internet.entities.SuDungMayId;
import thien.fa.com.internet.page.PageAble;
import thien.fa.com.internet.service.KhachHangServiceImpl;
import thien.fa.com.internet.service.MayServiceImpl;
import thien.fa.com.internet.service.SuDungMayServiceImpl;

@Controller
@RequestMapping("/sudungmay")
public class SuDungMayController {

  @Autowired
  private SuDungMayServiceImpl suDungMayServiceImpl;

  @Autowired
  private MayServiceImpl mayServiceImpl;

  @Autowired
  private KhachHangServiceImpl khachHangServiceImpl;

  @GetMapping("/list")
  public String getAllSuDungMayWithPageAble(Model model,
      @RequestParam(defaultValue = "1") Integer page) {
    PageAble pageAble = new PageAble(page);
    List<SuDungMay> suDungMays = suDungMayServiceImpl
        .findWithPageAble(pageAble);
    model.addAttribute("suDungMays", suDungMays);
    model.addAttribute("totalPages", suDungMayServiceImpl.totalPages(pageAble));
    model.addAttribute("currentPage", page);

    return "/sudungmay/list";
  }

  @GetMapping("/add")
  public String showAddForm(Model model) {
    model.addAttribute("suDungMayForm", new SuDungMay());
    return "/sudungmay/new";
  }

  @PostMapping("/save")
  public String addNewSuDungMay(
      @ModelAttribute(name = "suDungMayForm") SuDungMay suDungMay,
      BindingResult result) {
    System.out.println(suDungMay);
    KhachHang khachHang = khachHangServiceImpl
        .findById(suDungMay.getId().getMaKH());
    suDungMay.setKhachHang(khachHang);
    May may = mayServiceImpl.findById(suDungMay.getId().getMaMay());
    suDungMay.setMay(may);
    if (result.hasErrors()) {
      return "/sudungmay/new";
    }
    suDungMayServiceImpl.saveOrUpdate(suDungMay);
    return "redirect:/sudungmay/list";
  }

  @GetMapping("/delete")
  public String delete(SuDungMayId suDungMayId) {
    System.out.println(" id = " + suDungMayId);
    suDungMayServiceImpl.delete(suDungMayId);
    return "redirect:/sudungmay/list";
  }

  @GetMapping("/update")
  public String update(SuDungMayId suDungMayId, Model model) {
    System.out.println(" id = " + suDungMayId);
    SuDungMay suDungMay = suDungMayServiceImpl.findById(suDungMayId);
    model.addAttribute("suDungMayForm", suDungMay);
    return "/sudungmay/update";
  }

  @PostMapping("/update")
  public String updateSuDungMay(
      @ModelAttribute(name = "SuDungMayForm") @Valid SuDungMay SuDungMay,
      BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "/sudungmay/update";
    }
    suDungMayServiceImpl.saveOrUpdate(SuDungMay);
    model.addAttribute("msgUpdate", "Update SuDungMay success");
    return "/sudungmay/update";
  }

  @ModelAttribute("mays")
  public List<May> initMays() {
    return mayServiceImpl.findAll();
  }

  @ModelAttribute("khachHangs")
  public List<KhachHang> initKhachHangs() {
    return khachHangServiceImpl.findAll();
  }

  @GetMapping("/search")
  public String searchSuDungMay(Model model,
      @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(name = "searchKey", defaultValue = "") String searchKey) {
    PageAble pageAble = new PageAble(page);
    List<SuDungMay> suDungMays = suDungMayServiceImpl.search(searchKey,
        pageAble);
    model.addAttribute("suDungMays", suDungMays);
    model.addAttribute("searchKey", searchKey);
    model.addAttribute("totalPages", mayServiceImpl.totalPages(pageAble));
    model.addAttribute("currentPage", page);
    return "/sudungmay/list";
  }
}
