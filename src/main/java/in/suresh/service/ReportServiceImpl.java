package in.suresh.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.suresh.entity.CitizenPlan;
import in.suresh.repo.CitizenPlanRepository;
import in.suresh.request.SearchRequest;
import in.suresh.utils.EmailUtils;
import in.suresh.utils.ExcelGenerator;
import in.suresh.utils.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository planRepo;

	@Autowired
	private ExcelGenerator excelGenerator;

	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public List<String> getplanNames() {

		return planRepo.getPlanName();
	}

	@Override
	public List<String> getPlanStatuses() {

		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {

		CitizenPlan entity = new CitizenPlan();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {

			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// convert String to LocalDate
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setPlanStratDate(localDate);
		}
		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate = request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// convert String to LocalDate
			LocalDate localDate = LocalDate.parse(endDate, formatter);
			entity.setPlanEndDate(localDate);
		}
		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {

		File file= new File("Plan_Info.xls");
		List<CitizenPlan> records = planRepo.findAll();
		excelGenerator.generate(response, records, file);
		
		String to="sureshjava330@gmail.com";
		String subject="Test email";
		String body="<h1> Excel Report Generated </h1>";
		emailUtils.sendEmail(to, subject, body, file);
		file.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {

		File file= new File("Plan_Info.pdf");
		List<CitizenPlan> reocrds = planRepo.findAll();
		pdfGenerator.generate(response, reocrds, file);
		
		String to="sureshjava330@gmail.com";
		String subject="Test email";
		String body="<h1> PDF Report Generated </h1>";
		emailUtils.sendEmail(to, subject, body, file);
		file.delete();
		return true;
	}

}
