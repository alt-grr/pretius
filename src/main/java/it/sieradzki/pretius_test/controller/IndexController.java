package it.sieradzki.pretius_test.controller;

import it.sieradzki.pretius_test.model.entity.Employee;
import it.sieradzki.pretius_test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {

		Employee employee = new Employee();
		employee.setFirstName("Jan");
		employee.setLastName("Kowalski");

		employeeService.save(employee);

		System.out.println("Pracownicy obecnie:");
		for (Employee e : employeeService.findAll()) {
			System.out.println(e);
		}

		mav.setViewName("index");
		return mav;
	}
}
