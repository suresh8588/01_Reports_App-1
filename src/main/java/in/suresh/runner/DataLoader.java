package in.suresh.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.suresh.entity.CitizenPlan;
import in.suresh.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		repo.deleteAll();
		// Cash Plan Data
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("Suresh");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStratDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmount(10000);

		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Ramya");
		c2.setGender("Fe-Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialDate(LocalDate.now().minusDays(5));
		c2.setDenialReason("Already having some other plan");

		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Naresh");
		c3.setGender("Male");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStratDate(LocalDate.now().minusMonths(3));
		c3.setPlanEndDate(LocalDate.now().plusMonths(3));
		c3.setBenefitAmount(6000);
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminationReason("Govt Employed");

		// Food Plan Data
		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("Nandini");
		c4.setGender("Fe-Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStratDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmount(8000);

		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Ashok");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialDate(LocalDate.now().minusDays(5));
		c5.setDenialReason("Already having Food Wallet");

		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Manoj");
		c6.setGender("Male");
		c6.setPlanName("Cash");
		c6.setPlanStatus("Terminated");
		c6.setPlanStratDate(LocalDate.now().minusMonths(3));
		c6.setPlanEndDate(LocalDate.now().plusMonths(3));
		c6.setBenefitAmount(5000);
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminationReason("Govt Employed");

		// Medical Plan Data
		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Raghavendra");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStratDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmount(5000);

		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("Kiran");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setDenialDate(LocalDate.now().minusDays(5));
		c8.setDenialReason("Govt Employee");

		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Alekya");
		c9.setGender("Fe-Male");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStratDate(LocalDate.now().minusMonths(3));
		c9.setPlanEndDate(LocalDate.now().plusMonths(3));
		c9.setBenefitAmount(6000);
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminationReason("Govt Employed");

		// Employment Plan Data
		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("Anil");
		c10.setGender("Male");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Approved");
		c10.setPlanStratDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenefitAmount(10000);

		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("Priya");
		c11.setGender("Fe-Male");
		c11.setPlanName("Employment");
		c11.setPlanStatus("Denied");
		c11.setDenialDate(LocalDate.now().minusDays(5));
		c11.setDenialReason("Govt Job");

		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("Naveen");
		c12.setGender("Male");
		c12.setPlanName("Employment");
		c12.setPlanStatus("Terminated");
		c12.setPlanStratDate(LocalDate.now().minusMonths(3));
		c12.setPlanEndDate(LocalDate.now().plusMonths(3));
		c12.setBenefitAmount(6000);
		c12.setTerminatedDate(LocalDate.now());
		c12.setTerminationReason("Govt Job");

		List<CitizenPlan> citizenList = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);
		repo.saveAll(citizenList);
		System.out.println("records inserted");
	}


}
