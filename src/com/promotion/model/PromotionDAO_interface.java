package com.promotion.model;

import java.util.List;

public interface PromotionDAO_interface {

	public void insert(PromotionVO promotionVO);

	public void update(PromotionVO promotionVO);

	public void delete(Integer promNo);

	public PromotionVO findByPrimaryKey(Integer promNo);

	public List<PromotionVO> getAll();

}
