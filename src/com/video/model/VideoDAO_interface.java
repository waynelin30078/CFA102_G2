package com.video.model;

import java.util.List;

public interface VideoDAO_interface {
	void insert();
	void update();
	void delete();
	VideoVO getOne();
	List <VideoVO> gelAll();
}
