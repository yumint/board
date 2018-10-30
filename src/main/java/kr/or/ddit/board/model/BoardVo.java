package kr.or.ddit.board.model;

public class BoardVo {
	
	private String boardId;
	private String boardNm;
	private String useYn;
	private String cUserid;
	private String cDate;
	
	
	// 기본생성자 
	public BoardVo() {
	
	}

	@Override
	public String toString() {
		return "BoardVo [boardId=" + boardId + ", boardNm=" + boardNm
				+ ", useYn=" + useYn + ", cUserid=" + cUserid + ", cDate="
				+ cDate + "]";
	}




	public String getBoardId() {
		return boardId;
	}


	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}


	public String getBoardNm() {
		return boardNm;
	}


	public void setBoardNm(String boardNm) {
		this.boardNm = boardNm;
	}


	public String getUseYn() {
		return useYn;
	}


	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}


	public String getcUserid() {
		return cUserid;
	}


	public void setcUserid(String cUserid) {
		this.cUserid = cUserid;
	}


	public String getcDate() {
		return cDate;
	}


	public void setcDate(String cDate) {
		this.cDate = cDate;
	}


	


}
