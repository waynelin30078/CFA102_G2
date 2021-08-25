package com.p_favorite.model;

import java.util.List;

public interface P_favoriteDAO_interface {

	public void insert(P_favoriteVO p_favoriteVO);

	public void delete(P_favoriteVO p_favoriteVO);

	public List<P_favoriteVO> getAll_favorite(Integer mNo);

	public List<P_favoriteVO> getAll();

}
