package kr.co.moneybook.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.moneybook.domain.Asset;
import kr.co.moneybook.domain.Earnings;
import kr.co.moneybook.domain.Expense;
import kr.co.moneybook.service.AssetService;
import kr.co.moneybook.service.EarningsService;
import kr.co.moneybook.service.ExcelService;
import kr.co.moneybook.service.ExpenseService;

/*
 * 가계부 엑셀파일 다운로드
*/

@Controller
public class ExcelController {

	@Autowired
	private ExcelService excelService;

	//가계부 엑셀로 다운로드
	@RequestMapping(value="moneybook/excel")
	public void excel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//자산 리스트 가져오기
		List<Asset> asset_list = excelService.asset_excel(request);
		//지출 리스트 가져오기
		List<Expense> expense_list = excelService.expense_excel(request);
		//수입 리스트 가져오기
		List<Earnings> earnings_list = excelService.earnings_excel(request);
		//row create 하기 위해 리스트 중 가장 큰 리스트를 찾아서 생성
		int listMax;
		//가장 큰 리스트 찾기
		if(asset_list.size() >= earnings_list.size() && asset_list.size() >= expense_list.size()) {
			listMax = asset_list.size();
		}else if(earnings_list.size() > expense_list.size() && earnings_list.size() >= asset_list.size()) {
			listMax = earnings_list.size();
		}else {
			listMax = expense_list.size();
		}
		//워크북 생성
		Workbook workbook = new HSSFWorkbook();
		//시트 제목
		Sheet sheet = workbook.createSheet("가계부");
		//열
		Row row = null;

		Cell cell = null;

		int rowNo = 0;

		for (int i = 0; i < listMax + 2; i++) {
			row = sheet.createRow(i);
		}
		
		//각 합계를 저장할 변수 
		int expense_max = 0;
		int earnings_max = 0;
		int asset_max = 0;
		
		// 테이블 헤더용 스타일
		CellStyle headStyle = workbook.createCellStyle();
		// 가는 경계선을 가짐
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		// 배경색 지정
		headStyle.setFillForegroundColor(HSSFColorPredefined.PALE_BLUE.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// 데이터는 가운데 정렬
		headStyle.setAlignment(HorizontalAlignment.CENTER);
		
		// 데이터용 경계 스타일
		CellStyle bodyStyle = workbook.createCellStyle();
		//테두리 지정
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		//콤마찍기
		bodyStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));
		
		//합계 용 스타일
		CellStyle footStyle = workbook.createCellStyle();
		//테두리 지정
		footStyle.setBorderTop(BorderStyle.THIN);
		footStyle.setBorderBottom(BorderStyle.THIN);
		footStyle.setBorderLeft(BorderStyle.THIN);
		footStyle.setBorderRight(BorderStyle.THIN);
		//콤마찍기
		footStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));
		
		//헤더 생성
		row = sheet.getRow(rowNo++);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,2));
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("지출");
		
		sheet.addMergedRegion(new CellRangeAddress(0,0,4,6));
		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("수입");
		//셸 병합
		sheet.addMergedRegion(new CellRangeAddress(0,0,8,9));
		cell = row.createCell(8);
		cell.setCellStyle(headStyle);
		cell.setCellValue("자산");

		row = sheet.getRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("날짜");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("금액");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("사용 내역");
		
		cell = row.createCell(4);
		cell.setCellStyle(headStyle);
		cell.setCellValue("날짜");
		cell = row.createCell(5);
		cell.setCellStyle(headStyle);
		cell.setCellValue("금액");
		cell = row.createCell(6);
		cell.setCellStyle(headStyle);
		cell.setCellValue("사용 내역");
		

		
		//지출 데이터 부분 생성
		for (Expense expense : expense_list) {
			row = sheet.getRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(expense.getInsert_date());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(expense.getPrice());
			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(expense.getCartegory());
			expense_max = expense_max + expense.getPrice();
		}
		row = sheet.getRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellStyle(footStyle);
		cell.setCellValue("합계 : ");
		cell = row.createCell(1);
		cell.setCellStyle(footStyle);
		cell.setCellValue(expense_max);
		
		rowNo = 2;
		//수입 데이터 부분 생성
		for (Earnings earnings : earnings_list) {
			row = sheet.getRow(rowNo++);
			cell = row.createCell(4);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(earnings.getInsert_date());
			cell = row.createCell(5);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(earnings.getPrice());
			cell = row.createCell(6);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(earnings.getCartegory());
			earnings_max = earnings_max + earnings.getPrice();
		}
		row = sheet.getRow(rowNo++);
		cell = row.createCell(4);
		cell.setCellStyle(footStyle);
		cell.setCellValue("합계 : ");
		cell = row.createCell(5);
		cell.setCellStyle(footStyle);
		cell.setCellValue(earnings_max);
		
		rowNo = 1;
		//자산 데이터 부분 생성
		for (Asset asset : asset_list) {
			row = sheet.getRow(rowNo++);
			cell = row.createCell(8);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(asset.getType()+" : "); cell = row.createCell(9);
			cell.setCellStyle(bodyStyle); cell.setCellValue(asset.getAsset_price());
			asset_max = asset_max + asset.getAsset_price(); 
		}
		row = sheet.getRow(rowNo++);
		cell = row.createCell(8);
		cell.setCellStyle(footStyle);
		cell.setCellValue("자산 총 합계 : "); 
		cell = row.createCell(9);
		cell.setCellStyle(footStyle);
		cell.setCellValue(asset_max);
		 
		
		// 컨텐츠 타입과 파일명 지정
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=moneybook.xls");
		
		//엑셀 출력 
		workbook.write(response.getOutputStream());
		workbook.close();
	}
}
