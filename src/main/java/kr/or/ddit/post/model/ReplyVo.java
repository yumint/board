package kr.or.ddit.post.model;

import java.util.Date;

public class ReplyVo {
	
	private String comment_id;
	private String post_no;
	private String comment_cnt;
	private String c_userid;
	private Date c_date;
	
	// rownum이용하기 
	private int rownum;
	

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}





	public ReplyVo() {
	}
	
	



	@Override
	public String toString() {
		return "ReplyVo [comment_id=" + comment_id + ", post_no=" + post_no
				+ ", comment_cnt=" + comment_cnt + ", c_userid=" + c_userid
				+ ", c_date=" + c_date + "]";
	}





	public String getComment_id() {
		return comment_id;
	}



	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}



	public String getPost_no() {
		return post_no;
	}



	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}



	public String getComment_cnt() {
		return comment_cnt;
	}



	public void setComment_cnt(String comment_cnt) {
		this.comment_cnt = comment_cnt;
	}



	public String getC_userid() {
		return c_userid;
	}



	public void setC_userid(String c_userid) {
		this.c_userid = c_userid;
	}



	public Date getC_date() {
		return c_date;
	}



	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	
	
	
}
