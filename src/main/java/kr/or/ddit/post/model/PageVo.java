package kr.or.ddit.post.model;

public class PageVo extends PostVo  {
	
	// 페이징 처리
	private int rnum;
	
	private int page;
	private int pageSize;
	private String board_id;
	

	public PageVo() {
		
	}
	
	
	
	

	public int getRnum() {
		return rnum;
	}





	public void setRnum(int rnum) {
		this.rnum = rnum;
	}





	@Override
	public String toString() {
		return "PageVo [page=" + page + ", pageSize=" + pageSize
				+ ", board_id=" + board_id + "]";
	}



	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public String getBoard_id() {
		return board_id;
	}


	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}
	
	
	
	

}
