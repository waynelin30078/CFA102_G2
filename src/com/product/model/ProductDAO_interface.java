package com.product.model;

import java.util.List;

public interface ProductDAO_interface {
    public void insert(ProductVO prodVO);
    public void update(ProductVO prodVO);
    public void delete(Integer pNo);
    public ProductVO findByPrimaryKey(Integer pNo);
    public List<ProductVO> getAll();
    //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
