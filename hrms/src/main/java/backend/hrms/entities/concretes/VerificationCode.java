package backend.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="verification_codes")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor

public class VerificationCode {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name="verification_code")
    private String verificationCode;

    @Column(name="is_verified", columnDefinition = "boolean default true")
    private boolean isVerified = true;

    @Column(name="expression_date")
    private LocalDate expressionDate = LocalDate.now();

    @Column(name = "confirm_date")
    private LocalDate confirmDate;

    @Column(name="is_deleted", columnDefinition = "boolean default true")
    private boolean isDeleted=false;

    public VerificationCode(int userId, String verificationCode, boolean isVerified, boolean isDeleted) {
        this.userId = userId;
        this.verificationCode = verificationCode;
        this.isVerified = isVerified;
        this.isDeleted = isDeleted;
    }
	
}
