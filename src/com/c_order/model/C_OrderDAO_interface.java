package com.c_order.model;

import java.util.List;

public interface C_OrderDAO_interface {
	void insert(C_OrderVO c_order);

	void updateOrderState(C_OrderVO c_order);

	void updateCprogress(C_OrderVO c_order);
	void updatePayment(C_OrderVO c_order); 

	C_OrderVO getOne(Integer cOrderno);

	List<C_OrderVO> getAll();

	List<C_OrderVO> getAll(Integer mNo);

}
