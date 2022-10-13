package in.ashokit.rest;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.CitizensBindingApp;
import in.ashokit.service.ICitizensAppService;

@RestController
public class CitizensAppRestController {
	@Autowired
	private ICitizensAppService service;

	@PostMapping("/get")
	public ResponseEntity<String> createApp(@RequestBody CitizensBindingApp app) {
		Integer id = service.createApplication(app);
		if (id > 0) {
             return new ResponseEntity<String>("Application is saved with"+id, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Invalid ssn number ",HttpStatus.BAD_REQUEST);
		}
		
	}
}
