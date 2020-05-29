package com.hwig.shop;

import java.util.ArrayList;

public interface CustomerMapper {
	public ArrayList<NoticeVO> getNoticeList();
	public NoticeVO getNoticeArticle(int notice_id);
	public int noticeHitUp(int notice_id);
	public ArrayList<FaqVO> getFaqList();
}
