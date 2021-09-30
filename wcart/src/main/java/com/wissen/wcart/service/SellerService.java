package com.wissen.wcart.service;

import com.wissen.wcart.entity.Seller;

public interface SellerService {
	
	public void createNewSeller(Seller newSeller);

	public void deleteExistingSeller(int sellerId);

	public void updateExistingSeller(Seller updatedSeller);

	public Seller findBySellerId(int sellerId);

}
