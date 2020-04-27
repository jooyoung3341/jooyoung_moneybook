package kr.co.moneybook.domain;


/*
 *현재 페이지 번호, 페이지 당 출력할 데이터 개수, 페이지에 출력될 데이터의 시작 번호를 저장하는 클래스 
*/
public class Criteria {

	//현재 출력 중 인 페이지 번호
	private int page;
	
	//페이지에 출력할 데이터 개수
	private int perPageNum;
	
	//현재 페이지에 출력될 데이터의 시작 번호
	private int pageStart;
	
	//정렬
	private String sort;
	/*
	 *생성자 - 객체를 만들 때 처음 호출되는 메소드 
	 *기본 페이지 시작 = 1, 보여줄 페이지 수 = 10 (기본적으로 설정)
	*/
	public Criteria() {
		page = 1;
		perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	//특정 페이지의 게시글 시작 번호, 게시글 시작 행 번호
	public int getPageStart() {
		//11, 21, 31 로 시작 하게끔??
		pageStart = (page - 1) * perPageNum;
		return pageStart;
	}

	//정렬
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
