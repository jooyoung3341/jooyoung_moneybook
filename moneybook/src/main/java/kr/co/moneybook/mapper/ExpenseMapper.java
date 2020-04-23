package kr.co.moneybook.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.moneybook.domain.Expense;

@Mapper
public interface ExpenseMapper {

	//지출내역 삽입
	public void expense_insert(Expense expense);
	
	//지출내역 목록
	public List<Expense> expense_select(Map<String, Object> hashExpense);
	

	//지출내역 목록
	public List<Expense> expense_select_sort(Map<String, String> hashExpense1);
	
	public List<Expense> expense_select1(String moneybook_name);
	
	//지출내역 삭제
	public void expense_delete(@Param("eno") int eno);
	
	//지축내열 수정 폼 입력값 가져오기
	public Expense expense_updateform(int eno);
	
	//지출내역 수정
	public void expense_update(Expense expense);
}
