package com.product.model;
import java.util.List;

public interface ProductDAO_interface {

	public void insert(ProductVO productVO);

	public void update(ProductVO productVO);

	public void delete(Integer pno);

	public ProductVO findByPrimaryKey(Integer pno);

	public List<ProductVO> getAll();

	public List<ProductVO> getAll_bypName(String pname);

	public List<ProductVO> getAll_byCategoryName(String pname);

}
