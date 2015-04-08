package com.smarttv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		return "playlist";
	}

    @RequestMapping(value = "/playList")
    public String test( ModelMap model, HttpServletRequest request) {
        System.out.println(request.getParameter("name"));

        System.out.println(request.getRequestURI());
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        model.addAttribute("list", list);
        return "categories";
    }

    /*@RequestMapping(value = "getPlayList/{name}", method = RequestMethod.GET)
    public String getAllPlayLists(@PathVariable("name") String name, ModelMap model, HttpServletRequest request) {
        System.out.println("get all");
        System.out.println("name = " + name);
        System.out.println(request.getRequestURI());
        return "index";
    }*/

    /*@RequestMapping(value = "/test}")
    public String test( ModelMap model, HttpServletRequest request) {
        System.out.println("get all");

        System.out.println(request.getRequestURI());
        return "hello";
    }*/
    /*@RequestMapping(value = "/getIcons", method = RequestMethod.GET)
    public String getIcon(ModelMap model) {
        System.out.println("get icons");

        return "index";
    }*/
}