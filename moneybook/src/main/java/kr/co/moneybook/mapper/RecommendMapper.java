package kr.co.moneybook.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.Recommend;

@Mapper
public interface RecommendMapper {

	//추천 등록
	public void recommend_insert(Recommend recommed);
}
