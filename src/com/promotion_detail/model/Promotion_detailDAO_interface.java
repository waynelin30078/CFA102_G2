package com.promotion_detail.model;

import java.util.List;

public interface Promotion_detailDAO_interface {

	public void insert(Promotion_detailVO promotion_detailVO);

	public void update(Promotion_detailVO promotion_detailVO);

	public void delete(Integer promNo, Integer pNo);

	public List<Promotion_detailVO> findByPrimaryKey(Integer promNo);

	public List<Promotion_detailVO> getAll();

}
