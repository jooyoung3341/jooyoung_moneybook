package kr.co.moneybook.domain;

//검색을 해도 페이지 수가 많아 질 수 있으므로 페이징처리를 위한 Criteria 상속
public class SearchCriteria extends Criteria {
	//검색어를 저장할 변수
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchCriteria [keyword=" + keyword + "]";
	}
}
