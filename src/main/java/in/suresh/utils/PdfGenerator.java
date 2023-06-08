package in.suresh.utils;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.suresh.entity.CitizenPlan;

@Component
public class PdfGenerator {

	
	public void generate(HttpServletResponse response, List<CitizenPlan> records, File file) throws Exception{
		
		
		Document document = new Document(PageSize.A4.rotate());
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));
		
		document.open();
		Paragraph paragraph = new Paragraph("Citizen Plan Info");
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);

		PdfPTable table = new PdfPTable(12);
		table.setSpacingBefore(8);

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Citizen Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Gender", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Plan Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Plan Status", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Plan StratDate", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Plan EndDate", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Benefit Amount", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Denial Date", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Denial Reason", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Termination Date", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Termination Reason", font));
		table.addCell(cell);


		for (CitizenPlan plan : records) {

			table.setSpacingBefore(10);
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getGender());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStratDate() + "");
			table.addCell(plan.getPlanEndDate() + "");
			table.addCell(String.valueOf(plan.getBenefitAmount()));
			table.addCell(plan.getDenialDate() + "");
			table.addCell(plan.getDenialReason());
			table.addCell(plan.getTerminatedDate() + "");
			table.addCell(plan.getTerminationReason());

		}
		document.add(table);
		document.close();
		
		
	}
}
