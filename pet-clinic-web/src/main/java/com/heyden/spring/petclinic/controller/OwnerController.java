package com.heyden.spring.petclinic.controller;

import com.heyden.spring.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

	private OwnerService ownerService;

	public OwnerController(final OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@GetMapping({"", "/", "index", "index.html"})
	public String listVets(final Model model) {
		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}

	@GetMapping("/find")
	public String notImplemented() {
		return "notYetImplemented";
	}

}
