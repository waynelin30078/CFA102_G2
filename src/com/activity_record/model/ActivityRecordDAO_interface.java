package com.activity_record.model;

import java.util.List;



public interface ActivityRecordDAO_interface {

	void insert(ActivityRecordVO actRecord);   //新增運動紀錄  會員前台
	void delete(ActivityRecordVO actRecord); 	//刪除運動紀錄  會員前台
	ActivityRecordVO findByPrimaryKey(int diaryNo, int actNo);
	List<ActivityRecordVO> findByDiaryNo(int diaryNo);
}
