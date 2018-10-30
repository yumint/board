package kr.or.ddit.post.model;

import java.util.Date;

public class PostVo {
	
	// post에
	private String post_no;
	private String board_id;
	private String title;
	private String cnt;
	private Date c_date;
	private String d_yn;           
	private String parent_no;      
	private String userid;
	


	// 기본생성자
	public PostVo() {
	
	}

	

	@Override
	public String toString() {
		return "PostVo [post_no=" + post_no + ", board_id=" + board_id
				+ ", title=" + title + ", cnt=" + cnt + ", c_date=" + c_date
				+ ", d_yn=" + d_yn + ", parent_no=" + parent_no + ", userid="
				+ userid + "]";
	}



	public String getBoard_id() {
		return board_id;
	}



	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	



	public String getPost_no() {
		return post_no;
	}
	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	public String getD_yn() {
		return d_yn;
	}
	public void setD_yn(String d_yn) {
		this.d_yn = d_yn;
	}
	public String getParent_no() {
		return parent_no;
	}
	public void setParent_no(String parent_no) {
		this.parent_no = parent_no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	

	
	

}
