package com.wissen.wcart.dao;

import com.wissen.wcart.entity.Seller;

public interface SellerDAO {
	
	public void createNewSeller(Seller newSeller);
	
	public void deleteExistingSeller(int sellerId);
	
	public void updateExistingSeller(Seller updatedSeller);

	public Seller findBySellerId(int sellerId);
	
}
