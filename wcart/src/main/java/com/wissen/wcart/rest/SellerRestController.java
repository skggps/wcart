package com.wissen.wcart.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.wcart.entity.Seller;
import com.wissen.wcart.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerRestController {
	
	private SellerService sellerService;

	@Autowired
	public SellerRestController(SellerService sellerService) {
		this.sellerService = sellerService;
	}
	

	// Add a new Seller - POST - "/addSeller"
	@PostMapping("/addSeller")
	public Seller addSeller(@RequestBody Seller newSeller)	{
		// If someone passes an id in JSON, set id to 0. This is to save a new item instead of update
		newSeller.setSellerId(0);
		sellerService.createNewSeller(newSeller);
		return newSeller;
	}
 
	/*
	 * Update existing seller - PUT - "/updateSeller"
	 * While update we need to send seller object with seller id as mandatory, else it will add it as a new entry.
	 */
	@PutMapping("/updateSeller")
	public Seller updateSeller(@RequestBody Seller updatedSeller) {
		sellerService.updateExistingSeller(updatedSeller);
		return updatedSeller;
	}

	// Delete an existing Seller - DELETE - "/deleteSeller/{sellerId}"
	@DeleteMapping("/deleteSeller/{sellerId}")
	public String deleteSeller(@PathVariable int sellerId) {

		Seller tempSeller = sellerService.findBySellerId(sellerId);
		// throw exception if null
		if (tempSeller == null) {
			throw new RuntimeException("Seller id not found - " + sellerId);
		}

		sellerService.deleteExistingSeller(sellerId);
		return "Deleted employee id - " + sellerId;
	}

}
