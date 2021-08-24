package com.admin.model;

import java.util.*;

public interface AdminDAO_interface {

	public void insert(AdminVO adminVO); 
	public void update(AdminVO adminVO);
	public void delete(Integer aNo);
	public void findByPrimaryKey(Integer aNo);
	public List<AdminVO> getAll();
}