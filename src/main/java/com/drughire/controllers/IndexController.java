package com.drughire.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
	@RequestMapping("/index")
	public String index(){
		return "index";
	}

}
