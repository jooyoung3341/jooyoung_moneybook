package kr.co.moneybook.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
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

@Controller
public class ExcelController {

	@Autowired
	private ExcelService excelService;

	
	@RequestMapping(value="moneybook/excel")
	public void excel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Asset> asset_list = excelService.asset_excel(request);
		List<Expense> expense_list = excelService.expense_excel(request);
		List<Earnings> earnings_list = excelService.earnings_excel(request);
		
		//워크북 생성
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("가계부");
		Row row = null;
		Row arow = null;
		
		Cell cell = null;
		Cell acell = null;
		int rowNo = 0;
		int arowNo = 1;
		
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
		// 배경은 노란색
		headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// 데이터는 가운데 정렬
		headStyle.setAlignment(HorizontalAlignment.CENTER);
		
		// 데이터용 경계 스타일 테두리만 지정
		CellStyle bodyStyle = workbook.createCellStyle();
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		
		//헤더 생성
		row = sheet.createRow(rowNo++);
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
		
		sheet.addMergedRegion(new CellRangeAddress(0,0,8,9));
		cell = row.createCell(8);
		cell.setCellStyle(headStyle);
		cell.setCellValue("자산");

		
		//지출 데이터 부분 생성
		for (Expense expense : expense_list) {
			row = sheet.createRow(rowNo++);
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
		row = sheet.createRow(rowNo++);
		cell = row.createCell(0);
		cell.setCellValue("합계 : ");
		cell = row.createCell(1);
		cell.setCellValue(expense_max);
		
		rowNo = 1;
		//지출 데이터 부분 생성
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
		cell.setCellValue("합계 : ");
		cell = row.createCell(5);
		cell.setCellValue(earnings_max);
		
		rowNo = 1;
		//자산 데이터 부분 생성
		for (Asset asset : asset_list) {
			row = sheet.getRow(rowNo++); 
			cell = row.createCell(8); cell.setCellStyle(bodyStyle);
			cell.setCellValue(asset.getType()+" : "); cell = row.createCell(9);
			cell.setCellStyle(bodyStyle); cell.setCellValue(asset.getAsset_price());
			asset_max = asset_max + asset.getAsset_price(); 
		}
		row = sheet.getRow(rowNo++);
		cell = row.createCell(8);
		cell.setCellValue("자산 총 합계 : "); 
		cell = row.createCell(9);
		cell.setCellValue(asset_max);
		 
		
		// 컨텐츠 타입과 파일명 지정
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=moneybook.xls");
		
		//엑셀 출력 
		workbook.write(response.getOutputStream());
		workbook.close();
	}
}
