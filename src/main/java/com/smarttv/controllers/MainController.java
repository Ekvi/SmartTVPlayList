package com.smarttv.controllers;

import com.smarttv.models.Category;
import com.smarttv.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		return "playlist";
	}

    @RequestMapping(value = "/playList")
    public String getCategories( ModelMap model, HttpServletRequest request) {
        List<Category> categories = categoryService.getCategories(request.getParameter("name"));

        model.addAttribute("categories", categories);

        return "categoryPlayList";
    }
}