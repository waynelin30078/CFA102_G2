package com.apt_order.model;

import java.util.List;

public interface Apt_orderDAO_interface {
	public void insert(Apt_orderVO apt_orderVO);
	public void update(Apt_orderVO apt_orderVO);
	public void delete(Integer aptOrderNo);
	public Apt_orderVO findByPrimaryKey(Integer aptOrderNo);
    public List<Apt_orderVO> getAll();
}
