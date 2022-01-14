package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{
	
	private final RecoveryRoomService rrs;
	
	@Autowired
    public RecoveryRoomTypeFormatter(RecoveryRoomService rrs) {
		super();
		this.rrs = rrs;
	}

	@Override
    public String print(RecoveryRoomType object, Locale locale) {
		return object.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
    	RecoveryRoomType rrt = rrs.getRecoveryRoomType(text);
        if(rrt!=null) {
        	return rrt;
        }
        throw new ParseException("type not found: " + text, 0);
    }
    
}
