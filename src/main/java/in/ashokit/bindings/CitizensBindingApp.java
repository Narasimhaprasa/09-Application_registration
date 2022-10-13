package in.ashokit.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizensBindingApp {
	private String fullName;
	private String email;
	private Long mobileNum;
	private String gender;
	private LocalDate dob;
	private Long ssn;
}
