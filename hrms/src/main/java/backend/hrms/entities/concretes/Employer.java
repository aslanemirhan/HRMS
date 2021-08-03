package backend.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAnnouncements"})
@EqualsAndHashCode(callSuper = false)

public class Employer extends User{ 

	@Column(name = "company_name")
	private String companyName;
	@Column(name = "web_address")
	private String webAddress;
	@Column(name = "phone_number")
	private String phoneNumber;
}
