package in.suresh.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import in.suresh.entity.CitizenPlan;

@Component
public class ExcelGenerator {

	public void generate(HttpServletResponse response, List<CitizenPlan> records, File file) throws Exception {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plan_info");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("citizenName");
		headerRow.createCell(2).setCellValue("gender");
		headerRow.createCell(3).setCellValue("planName");
		headerRow.createCell(4).setCellValue("planStatus");
		headerRow.createCell(5).setCellValue("planStratDate");
		headerRow.createCell(6).setCellValue("planEndDate");
		headerRow.createCell(7).setCellValue("benefitAmount");
		headerRow.createCell(8).setCellValue("denialDate");
		headerRow.createCell(9).setCellValue("denialReason");
		headerRow.createCell(10).setCellValue("terminatedDate");
		headerRow.createCell(11).setCellValue("terminationReason");

		int dataRowIndex = 1;

		for (CitizenPlan plan : records) {
			Row dataRow = sheet.createRow(dataRowIndex++);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getGender());
			dataRow.createCell(3).setCellValue(plan.getPlanName());
			dataRow.createCell(4).setCellValue(plan.getPlanStatus());
			if (null != plan.getPlanStratDate()) {

				dataRow.createCell(5).setCellValue(plan.getPlanStratDate() + "");
			} else {
				dataRow.createCell(5).setCellValue("NA");
			}
			if (null != plan.getPlanEndDate()) {

				dataRow.createCell(6).setCellValue(plan.getPlanEndDate() + "");
			} else {
				dataRow.createCell(6).setCellValue("NA");
			}

			if (plan.getBenefitAmount() != null) {

				dataRow.createCell(7).setCellValue(plan.getBenefitAmount());
			} else {
				dataRow.createCell(7).setCellValue("NA");
			}
			if (null != plan.getDenialDate()) {

				dataRow.createCell(8).setCellValue(plan.getDenialDate() + "");
			} else {
				dataRow.createCell(8).setCellValue("NA");
			}
			dataRow.createCell(9).setCellValue(plan.getDenialReason());
			if (null != plan.getTerminatedDate()) {

				dataRow.createCell(10).setCellValue(plan.getTerminatedDate() + "");
			} else {
				dataRow.createCell(10).setCellValue("NA");
			}
			dataRow.createCell(11).setCellValue(plan.getTerminationReason());
		}

		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		workbook.close();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	}
}
