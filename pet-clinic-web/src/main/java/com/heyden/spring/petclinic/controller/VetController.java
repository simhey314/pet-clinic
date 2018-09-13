package com.heyden.spring.petclinic.controller;

import com.heyden.spring.petclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/vets", "/vets.html"})
public class VetController {

	private VetService vetService;

	public VetController(final VetService vetService) {
		this.vetService = vetService;
	}

	@GetMapping({"", "/", "index", "index.html"})
	public String listVets(final Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
}
