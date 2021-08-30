package com.promotion.model;

import java.util.List;

public interface PromotionDAO_interface {

	public void insert(PromotionVO promotionVO);

	public void update(PromotionVO promotionVO);

	public void delete(Integer promno);

	public PromotionVO findByPrimaryKey(Integer promno);
	
	public List<PromotionVO> getAll_byPromName(String promname);

	public List<PromotionVO> getAll();

}
