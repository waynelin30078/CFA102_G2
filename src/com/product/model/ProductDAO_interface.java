package com.product.model;

import java.util.List;

public interface ProductDAO_interface {
	
    public void insert(ProductVO productVO);
    public void update(ProductVO productVO);
    public void delete(Integer pNo);
    public ProductVO findByPrimaryKey(Integer pNo);
    public List<ProductVO> getAll();
    
//  �U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<EmpVO> getAll(Map<String, String[]> map);	
    
}
