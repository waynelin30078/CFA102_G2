package com.p_order.model;

import java.util.List;

public interface P_orderDAO_interface {

	public void insert(P_orderVO p_orderVO);

	public void update(P_orderVO p_orderVO);
	
	public void update_orderState(P_orderVO p_orderVO);

	public void delete(Integer pOrderNo);

	public P_orderVO findByPrimaryKey(Integer pOrderNo);

	public List<P_orderVO> getAll();

}
