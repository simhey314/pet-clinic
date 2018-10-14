package com.heyden.spring.petclinic.controller;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

	private OwnerService ownerService;

	public OwnerController(final OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@InitBinder
	public void setAllowFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping("/find")
	public String findOwner(Model model) {
		model.addAttribute("owner", new Owner());
		return "owners/find";
	}

	@GetMapping({"", "/", "index", "index.html"})
	public String processFindOwner(Owner searchOwner, BindingResult bindingResult, Model model) {
		// show all owners for just a simple get request without parameters
		if (searchOwner.getLastName() == null) {
			searchOwner.setLastName("");
		}

		// get the search result
		List<Owner> results = ownerService.findAllByLastNameLike(searchOwner.getLastName());

		String view = "owners/find";
		if (results.isEmpty()) {
			bindingResult.rejectValue("lastName", "notFound", "not found");
		} else if (results.size() == 1) {
			view = "redirect:/owners/" + results.iterator().next().getId();
		} else {
			model.addAttribute("owners", results);
			view = "owners/list";
		}
		return view;
	}

	@GetMapping("/{id}")
	public String detailOwner(@PathVariable Long id, Model model) {
		model.addAttribute("owner", ownerService.findById(id));
		return "owners/details";
	}

	@GetMapping("/{id}/delete")
	public String deleteOwner(@PathVariable Long id) {
		ownerService.deleteById(id);
		return "redirect:/owners/";
	}

	@GetMapping("/{id}/edit")
	public String editOwner(@PathVariable Long id, Model model) {
		model.addAttribute("owner", ownerService.findById(id));
		return "owners/edit";
	}

	@PostMapping("/{id}/edit")
	public String saveEditOwner(@Valid Owner unsavedOwner, BindingResult bindingResult, @PathVariable Long id) {
		unsavedOwner.setId(id);
		return saveOwner(unsavedOwner, bindingResult.hasErrors());
	}

	@GetMapping("/new")
	public String newOwner(Model model) {
		model.addAttribute("owner", new Owner());
		return "owners/edit";
	}

	@PostMapping("/new")
	public String saveNewOwner(@Valid Owner newOwner, BindingResult bindingResult) {
		newOwner.setId(0L);
		return saveOwner(newOwner, bindingResult.hasErrors());
	}

	private String saveOwner(final @Valid Owner unsavedOwner, final boolean hasErrors) {
		String view;
		if (hasErrors) {
			view = "owners/edit";
		} else {
			Owner saveResult = ownerService.save(unsavedOwner);
			view = "redirect:/owners/" + saveResult.getId();
		}
		return view;
	}
}
