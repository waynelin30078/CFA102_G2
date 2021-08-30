package com.product.model;

import java.util.List;

public interface ProductDAO_interface {


	public void insert(ProductVO productVO);

	public void update(ProductVO productVO);

	public void delete(Integer pNo);

	public ProductVO findByPrimaryKey(Integer pNo);

	public List<ProductVO> getAll();

	public List<ProductVO> getAll_bypName(String pName);

	public List<ProductVO> getAll_byCategoryName(String pName);

}
