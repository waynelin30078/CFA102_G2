package com.p_order_detail.model;

import java.util.List;

public interface P_order_detailDAO_interface {

	public void insert(P_order_detailVO p_order_detailVO);

	public void update(P_order_detailVO p_order_detailVO);
	
	public void updateQuantity(P_order_detailVO p_order_detailVO);
	
	public void updatePrice(P_order_detailVO p_order_detailVO);
	
	public void updateRatings(P_order_detailVO p_order_detailVO);

	public void delete(Integer pOrderNo,Integer pNo);

	public List<P_order_detailVO> getAll_byOrderNo(Integer pOrderNo);
	
	public List<P_order_detailVO> getAll();

}
