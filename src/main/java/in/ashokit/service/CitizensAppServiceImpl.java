package in.ashokit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.bindings.CitizensBindingApp;
import in.ashokit.entity.CitizensApp;
import in.ashokit.repo.CitizensAppRepo;
import in.ashokit.service.ICitizensAppService;

@Service
public class CitizensAppServiceImpl implements ICitizensAppService {
	@Autowired
	private CitizensAppRepo repo;

	@Override
	public Integer createApplication(CitizensBindingApp data) {
		String endPointUrl = "https://ssa-web-api.herokuapp.com/ssn/{ssn}";
		// to create RestTemple for http call
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> info = rt.getForEntity(endPointUrl, String.class, data.getSsn());
		String stateName = info.getBody();
		if (stateName.equals("New Jersey")) {
			CitizensApp entity = new CitizensApp();
			BeanUtils.copyProperties(data, entity);
			entity.setStateName(stateName);
			CitizensApp save = repo.save(entity);
			Integer id = save.getApp_Id();

			return id;
		}
		return 0;
	}

}
