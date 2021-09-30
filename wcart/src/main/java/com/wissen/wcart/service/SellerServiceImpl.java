package com.wissen.wcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wissen.wcart.dao.SellerDAO;
import com.wissen.wcart.entity.Seller;

@Service
public class SellerServiceImpl implements SellerService {
	
	private SellerDAO sellerDAO;
	
	@Autowired
	public SellerServiceImpl(SellerDAO sellerDAO) {
		super();
		this.sellerDAO = sellerDAO;
	}

	@Override
	@Transactional
	public void createNewSeller(Seller newSeller) {
		sellerDAO.createNewSeller(newSeller);
	}

	@Override
	@Transactional
	public void deleteExistingSeller(int sellerId) {
		sellerDAO.deleteExistingSeller(sellerId);
	}

	@Override
	@Transactional
	public void updateExistingSeller(Seller updatedSeller) {
		sellerDAO.updateExistingSeller(updatedSeller);
	}

	@Override
	@Transactional
	public Seller findBySellerId(int sellerId) {
		return sellerDAO.findBySellerId(sellerId);
	}

}
