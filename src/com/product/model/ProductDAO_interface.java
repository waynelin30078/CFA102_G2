package com.product.model;
import java.util.List;

public interface ProductDAO_interface {
<<<<<<< HEAD

	public void insert(ProductVO productVO);

	public void update(ProductVO productVO);

	public void delete(Integer pno);

	public ProductVO findByPrimaryKey(Integer pno);

	public List<ProductVO> getAll();

	public List<ProductVO> getAll_bypName(String pname);

	public List<ProductVO> getAll_byCategoryName(String pname);

=======
    public void insert(ProductVO prodVO);
    public void update(ProductVO prodVO);
    public void delete(Integer pNo);
    public ProductVO findByPrimaryKey(Integer pNo);
    public List<ProductVO> getAll();
    //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
>>>>>>> COURSE
}
