package backend.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")

public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
    private int id;

    @Column(name="school_name")
    private String schoolName;

    @Column(name="department_name")
    private String departmentName;

    @Column(name="begin_of_date")
    private LocalDate beginOfDate;

    @Column(name="date_of_graduation")
    private LocalDate dateOfGraduation;

    @Column(name="created_at", columnDefinition = "Date default CURRENT_DATE")
    private LocalDate createdAt= LocalDate.now();

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted=false;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    
}
