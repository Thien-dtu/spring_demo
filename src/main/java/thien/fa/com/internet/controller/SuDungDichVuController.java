package thien.fa.com.internet.controller;

import java.util.ArrayList;
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

import thien.fa.com.internet.entities.DichVu;
import thien.fa.com.internet.entities.KhachHang;
import thien.fa.com.internet.entities.SuDungDichVu;
import thien.fa.com.internet.entities.SuDungDichVuId;
import thien.fa.com.internet.page.PageAble;
import thien.fa.com.internet.service.DichVuService;
import thien.fa.com.internet.service.KhachHangServiceImpl;
import thien.fa.com.internet.service.SuDungDichVuServiceImpl;

@Controller
@RequestMapping("/sudungdichvu")
public class SuDungDichVuController {
  
  @Autowired
  private SuDungDichVuServiceImpl suDungDichVuServiceImpl;

  @Autowired
  private DichVuService dichVuServiceImpl;

  @Autowired
  private KhachHangServiceImpl khachHangServiceImpl;
  
  @GetMapping("/list")
  public String getAllSuDungDichVuWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
    PageAble pageAble = new PageAble(page);
    List<SuDungDichVu> suDungDichVus = suDungDichVuServiceImpl.findWithPageAble(pageAble);
    
    List<SuDungDichVu> arr = new ArrayList<SuDungDichVu>();
    for(int i = 0; i < suDungDichVus.toArray().length; i++) {
      arr.add(suDungDichVus.get(i));
    }
    
    
    
    model.addAttribute("totalService", arr);
    model.addAttribute("suDungDichVus", suDungDichVus);
    model.addAttribute("totalPages", suDungDichVuServiceImpl.totalPages(pageAble));
    model.addAttribute("currentPage", page);

    return "/sudungdichvu/list";
  }
  
  @GetMapping("/add")
  public String showAddForm(Model model) {
    model.addAttribute("suDungDichVuForm", new SuDungDichVu());
    return "/sudungdichvu/new";
  }

  @PostMapping("/save")
  public String addNewSuDungDichVu(@ModelAttribute(name = "suDungDichVuForm") SuDungDichVu suDungDichVu, BindingResult result) {
    KhachHang khachHang = khachHangServiceImpl.findById(suDungDichVu.getId().getMaKH());
    suDungDichVu.setKhachHang(khachHang);
    DichVu dichVu = dichVuServiceImpl.findById(suDungDichVu.getId().getMaDV());
    suDungDichVu.setDichVu(dichVu);
    if (result.hasErrors()) {
      return "/sudungdichvu/new";
    }
    suDungDichVuServiceImpl.saveOrUpdate(suDungDichVu);
    return "redirect:/sudungdichvu/list";
  }

  @GetMapping("/delete")
  public String delete(SuDungDichVuId suDungDichVuId) {
    suDungDichVuServiceImpl.delete(suDungDichVuId);
    return "redirect:/sudungdichvu/list";
  }

  @GetMapping("/update")
  public String update(SuDungDichVuId suDungDichVuId, Model model) {
    SuDungDichVu suDungDichVu = suDungDichVuServiceImpl.findById(suDungDichVuId);
    model.addAttribute("SuDungDichVuForm", suDungDichVu);
    return "/sudungdichvu/update";
  }

  @PostMapping("/update")
  public String updateSuDungDichVu(@ModelAttribute(name = "suDungDichVuForm") @Valid SuDungDichVu SuDungDichVu,
      BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "/sudungdichvu/update";
    }
    suDungDichVuServiceImpl.saveOrUpdate(SuDungDichVu);
    model.addAttribute("msgUpdate", "Update SuDungDichVu success");
    return "/sudungdichvu/update";
  }

  @ModelAttribute("dichVus")
  public List<DichVu> initDichVus() {
    return dichVuServiceImpl.findAll();
  }

  @ModelAttribute("khachHangs")
  public List<KhachHang> initKhachHangs() {
    return khachHangServiceImpl.findAll();
  }

}
