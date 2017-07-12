package de.dwestermann.email.backend;

import java.time.LocalDateTime;

public interface IMessage {

	public String getSender();
	public String getSubject();
	public LocalDateTime getDate();
	public String getMessage();
	
}
