package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
	private static final String VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	private static final String WELCOME_VIEW = "welcome";
	private final RecoveryRoomService rrs;
	@Autowired
	public RecoveryRoomController(RecoveryRoomService rrs) {
		super();
		this.rrs = rrs;
	}
	
	@ModelAttribute("roomType")
	public List<RecoveryRoomType> populatePetTypes() {
		return this.rrs.getAllRecoveryRoomTypes();
	}
	
	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(ModelMap model) {
		RecoveryRoom recoveryRoom = new RecoveryRoom();
		model.put("recoveryRoom", recoveryRoom);
		return VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.put("recoveryRoom", recoveryRoom);
			return VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.rrs.save(recoveryRoom);

			return WELCOME_VIEW;
		}
	}
		
	
    
}
