package kr.co.moneybook.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.Recommend;

@Mapper
public interface RecommendMapper {

	//추천
	public void recommend(Recommend recommed);
	
	//추천 취소
	public void recommend_cancel(int reno);
	
	//게시글에 해당하는 추천이 있는지 조회 확인 
	public Recommend recommend_select(Map<String, Object> hashRecommend);
	
	//추천 확인
	public Recommend recommendStatus(Map<String, Object> hashRecommend);
}
