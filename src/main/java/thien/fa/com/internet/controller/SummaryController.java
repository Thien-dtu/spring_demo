package thien.fa.com.internet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thien.fa.com.internet.entities.Summary;
import thien.fa.com.internet.service.SuDungMayJpaServiceImpl;

@Controller
@RequestMapping("/summary")
public class SummaryController {
  @Autowired
  SuDungMayJpaServiceImpl service;
  
  @GetMapping("/summary")
  public String findListSummary(Model model,
      @RequestParam(defaultValue = "0", name = "page") int number) {
    int size = 3;
    List<Summary> list = service.findListSummary((number) * size, size);

    int totalPage = (int) Math.ceil(service.findListAll().size() / size);
    model.addAttribute("size", size);
    model.addAttribute("number", number);
    model.addAttribute("useService", list);
    model.addAttribute("totalPages", totalPage);
    return "summary/summary";
  }

}
