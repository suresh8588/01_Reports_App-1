package in.suresh.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="citizen_plan_table")
public class CitizenPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizenId;
	private String citizenName;
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate planStratDate;
	private LocalDate planEndDate;
	private Integer benefitAmount;
	private LocalDate denialDate;
	private String denialReason;
	private LocalDate terminatedDate;
	private String terminationReason;
}
