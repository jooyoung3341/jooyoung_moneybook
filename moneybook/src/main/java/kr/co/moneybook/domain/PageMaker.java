package kr.co.moneybook.domain;

public class PageMaker {

	//전체 게시물
	private int totalCount;
	
	//시작페이지와 마지막페이지 번호설정
	private int startPage;
	private int endPage;
	
	//이전과 다음 링크 여부
	private boolean prev;
	private boolean next;
	
	//페이지 번호 출력 개수 (화면에 보여줄 페이지 번호 수)
	private int displayPageNum = 5;
	
	//이전에 설정된 옵션 값을 저장하기 위한 변수
	private Criteria criteria;
	
	//접근자 메소드
	public int getTotalCount() {
		return totalCount;
	}
	
	
	/*
	 * 전체 데이터 개수를 알고 현재 페이지번호(criteria.page)와
	 * 출력할 페이지 개수(displayPageNum)를 알면 나머지를 전부 계산 할 수 있다.
	*/
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//Math.ceil 함수는 올림함수
		//											현재 페이지 번호          한번에 보여질 페이지 번호
		endPage = (int)(Math.ceil(criteria.getPage()/(double)displayPageNum)) * displayPageNum;
		//시작 페이지 번호
		startPage = endPage - displayPageNum + 1;
		//이전 페이지 링크 여부 시작페이지가 1이면 false 아니면 true
		prev = startPage == 1 ? false : true;
		
		//전체 데이터의 페이지 개수로 설정
		int pagesu = (int)(Math.ceil(totalCount/(double)criteria.getPerPageNum()));
		//마지막페이지 번호가 전체 데이터의 페이지 개수보다 크면
		if(endPage > pagesu) {
			endPage = pagesu;
		}
		
		//마지막 페이지 번호와 페이지 개수가 같으면 다음은 나올 필요 없음
		next = endPage == pagesu ? false : true;
	}
	

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}


	
}
