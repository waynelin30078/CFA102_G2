package com.product.model;

import java.util.List;

public interface ProductDAO_interface {
<<<<<<< HEAD

	public void insert(ProductVO productVO);

	public void update(ProductVO productVO);

	public void delete(Integer pNo);

	public ProductVO findByPrimaryKey(Integer pNo);

	public List<ProductVO> getAll();

=======
	
    public void insert(ProductVO productVO);
    public void update(ProductVO productVO);
    public void delete(Integer pNo);
    public ProductVO findByPrimaryKey(Integer pNo);
    public List<ProductVO> getAll();
    
//  �U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<EmpVO> getAll(Map<String, String[]> map);	
    
>>>>>>> 5e65e2a63fa68753dfd6d99f79f9d1255ce54f0b
}
