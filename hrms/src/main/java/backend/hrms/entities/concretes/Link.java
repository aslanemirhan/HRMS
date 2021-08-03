package backend.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "links")
@AllArgsConstructor
@NoArgsConstructor

public class Link {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		
	    @Column(name="id")
	    private int id;

	    @Column(name = "account_name")
	    private String accountName;

	    @Column(name="link_url")
	    private String linkUrl;

	    @Column(name="created_at", columnDefinition = "Date default CURRENT_DATE")
	    private LocalDate createdAt= LocalDate.now();

	    @Column(name = "is_active")
	    private boolean isActive;

	    @Column(name="is_deleted", columnDefinition = "boolean default false")
	    private boolean isDeleted=false;

	    @ManyToOne(fetch = FetchType.LAZY, optional = true)
	    @JoinColumn(name="candidate_id")
	    private Candidate candidate;
}
