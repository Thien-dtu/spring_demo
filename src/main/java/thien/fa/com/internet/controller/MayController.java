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

import thien.fa.com.internet.entities.May;
import thien.fa.com.internet.page.PageAble;
import thien.fa.com.internet.service.MayServiceImpl;

@Controller
@RequestMapping("/may")
public class MayController {

	@Autowired
	private MayServiceImpl mayServiceImpl;

	@GetMapping("/list")
	public String getAllmayWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<May> mays = mayServiceImpl.findWithPageAble(pageAble);
		model.addAttribute("mays", mays);
		model.addAttribute("totalPages", mayServiceImpl.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/may/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("mayForm", new May());
		return "/may/new";
	}

	@PostMapping("/save")
	public String addNewmay(@ModelAttribute(name = "mayForm") @Valid May may, BindingResult result) {
		if (result.hasErrors()) {
			return "/may/new";
		}
		mayServiceImpl.saveOrUpdate(may);
		return "redirect:/may/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id") String mayId, Model model) {
	  if (mayServiceImpl.delete(mayId)) {
	    model.addAttribute("msg", "Delete success");
//	    return "redirect:/may/list";
	    return "/may/list";
    }
	  else {
      model.addAttribute("msg", "ID not found, please reload");
//      return "redirect:/may/list";
      return "/may/list";
    }
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable(name = "id") String mayId, Model model) {
		May may = mayServiceImpl.findById(mayId);
		model.addAttribute("mayForm", may);
		model.addAttribute("previousStatus", may.getTrangThai());
		model.addAttribute("previousLocation", may.getViTri());
		return "/may/update";
	}
	
//	@GetMapping("/search")
//  public String timKiem(Model model, @RequestParam(required = false) String searchkey){
//      List<May> danhSachMay = mayServiceImpl.search(searchkey);
//      model.addAttribute("danhSachMay", danhSachMay);
//      return "may/danh-sach";
//  }
	
	@GetMapping(value = "/search")
  public String searchMay(Model model, @RequestParam(defaultValue = "1") Integer page,
          @RequestParam(name = "searchKey", defaultValue = "") String searchKey) {
	    PageAble pageAble = new PageAble(page);
      List<May> listMay = mayServiceImpl.searchMay(searchKey, pageAble);
      model.addAttribute("listMay", listMay);
      model.addAttribute("maMay", searchKey);
      model.addAttribute("totalPages", mayServiceImpl.totalPages(pageAble));
      model.addAttribute("currentPage", page);
      return "may/search";
  }

}
