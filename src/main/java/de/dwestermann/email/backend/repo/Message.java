package de.dwestermann.email.backend.repo;

import java.time.LocalDateTime;

import de.dwestermann.email.backend.IMessage;

public class Message implements IMessage {

	private String sender;
	private String subject;
	private LocalDateTime date;
	private String message;

	public Message(String sender, String subject, LocalDateTime date, String message) {
		this.sender=sender;
		this.subject=subject;
		this.date=date;
		this.message=message;
	}
	
	@Override
	public String getSender() {
		return sender;
	}

	@Override
	public String getSubject() {
		return subject;
	}

	@Override
	public LocalDateTime getDate() {
		return date;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
