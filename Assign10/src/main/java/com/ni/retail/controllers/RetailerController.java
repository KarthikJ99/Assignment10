package com.ni.retail.controllers;

import java.util.List;

import javax.validation.Valid;

import com.ni.retail.Retailer;
import com.ni.retail.services.RetailerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("jpa")
public class RetailerController {

    @Autowired
    RetailerService retailerService;

    @GetMapping("/retailer/list")
    @ResponseBody
    public List<Retailer> allRetailers(){      
        return retailerService.getAllRetailers();
    }  
    
    @PostMapping("retailers/add")
    @ResponseBody
    public RedirectView addFarmer(@Valid Retailer retailer){   
        // Save the retailer in the DB
        Retailer resultFarmer = retailerService.addRetailer(retailer);
        System.out.format("Added retailer with id ", retailer.getRetailerId());
        
        RedirectView redirectView = new RedirectView("/jpa/retailer/list"); 
        return redirectView;
    } 
    
    // 48A Can you implement delete a farmer functionality
    // given his id value
    @PostMapping("retailers/delete")
	@ResponseBody
	public RedirectView deleteFarmer(int retailerId) 
    {
        retailerService.deleteretailer(retailerId);
      		
		RedirectView redirectView = new RedirectView("/jpa/retailer/list");
		return redirectView;
	}

    // 48B How about deleting a farmer, given his name??
    @PostMapping("retailers/delete-by-name")
	@ResponseBody
	public RedirectView deleteRetailerByName(@RequestParam String name) 
    {
        retailerService.deleteRetailerByName(name);
      		
		RedirectView redirectView = new RedirectView("/jpa/retailer/list");
		return redirectView;
	}

    @PostMapping("retailers/delete-by-age")
	@ResponseBody
	public RedirectView deleteRetailerByAge(@RequestParam int age) 
    {
        retailerService.deleteRetailerByAge(age);
      		
		RedirectView redirectView = new RedirectView("/jpa/retailer/list");
		return redirectView;
	}

    

    
}
