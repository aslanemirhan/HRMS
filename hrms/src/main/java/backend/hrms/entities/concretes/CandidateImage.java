package backend.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidate_images")
@AllArgsConstructor
@NoArgsConstructor

public class CandidateImage {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	
	    @Column(name="id")
	    private int id;

	    @Column(name = "image_url")
	    private String imageUrl;

	    @Column(name="created_at", columnDefinition = "Date default CURRENT_DATE")
	    private LocalDate createdAt= LocalDate.now();

	    @Column(name = "is_active")
	    private boolean isActive;

	    @Column(name="is_deleted", columnDefinition = "boolean default false")
	    private boolean isDeleted=false;

	    @OneToOne(cascade = {CascadeType.ALL})
	    @JoinColumn(name = "candidate_id")
	    @JsonIgnore
	    private Candidate candidate;
}
