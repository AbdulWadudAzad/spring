package com.coderbd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/idb/role") // This means URL's start with /demo (after Application path)
public class RoleController {
	// This means to get the bean called userRepository
	@Autowired // Which is auto-generated by Spring, we will use it to handle the data
	private RoleRepository roleRepository;

	@GetMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewRole(@RequestParam String roleName) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Role r = new Role();
		r.setRoleName(roleName);
		roleRepository.save(r);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Role> getAllRoles() {
		// This returns a JSON or XML with the users
		return roleRepository.findAll();
	}

}