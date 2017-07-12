package de.dwestermann.email.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dwestermann.email.backend.repo.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	public MessageRepository messageRepo;

	public List<IMessage> getMessages() {
		
		return messageRepo.getMessages();
	}
}
