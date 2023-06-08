package in.suresh.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.suresh.entity.CitizenPlan;
import in.suresh.request.SearchRequest;

public interface ReportService {

	public List<String> getplanNames();

	public List<String> getPlanStatuses();

	public List<CitizenPlan> search(SearchRequest request);

	public boolean exportExcel(HttpServletResponse response) throws Exception;

	public boolean exportPdf(HttpServletResponse response) throws Exception;
}
