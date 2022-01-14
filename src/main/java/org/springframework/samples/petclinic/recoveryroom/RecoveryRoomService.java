package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecoveryRoomService {
	private RecoveryRoomRepository rrr;
	
	@Transactional(readOnly = true)
    public List<RecoveryRoom> getAll(){
        return rrr.findAll();
    }
	
	@Autowired
    public RecoveryRoomService(RecoveryRoomRepository rrr) {
		super();
		this.rrr = rrr;
	}
	
	@Transactional(readOnly = true)
    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return rrr.getRecoveryRoomType(typeName);
    }
	
	public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }

	@Transactional(readOnly = true)
    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return rrr.findBySizeMoreThan(size);
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return null;       
    }

    
}
