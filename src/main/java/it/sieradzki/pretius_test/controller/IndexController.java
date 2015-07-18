package it.sieradzki.pretius_test.controller;

import it.sieradzki.pretius_test.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@Autowired
	private ReportService reportService;

	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {

		mav.addObject("reportRows", reportService.getReport());
		mav.setViewName("index");

		return mav;
	}
}
