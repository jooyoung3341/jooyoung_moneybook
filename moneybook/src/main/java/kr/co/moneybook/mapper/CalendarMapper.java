package kr.co.moneybook.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.Calendar;

@Mapper
public interface CalendarMapper {
	
	//달력 월 데이터 가져오기
	public List<Calendar> calendar_select(Map<String, Object> hashCalendar);

}
