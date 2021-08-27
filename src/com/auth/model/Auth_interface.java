package com.auth.model;

import java.util.List;

public interface Auth_interface {

	public void insert(AuthVO authVO);

	public void update(AuthVO authVO);

	public void delete(Integer authNo);

	public void findByPrimaryKey(Integer authNo);

	public List<AuthVO> getAll();
}