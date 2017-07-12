package de.dwestermann.email.ui;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import de.dwestermann.email.backend.IMessage;

public class MessageComponent extends VerticalLayout {

	private final DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm:ss");
	private IMessage message;
	private List<IMessageClick> listeners=new ArrayList<>();

	public MessageComponent(IMessage message) {
		
		this.message=message;
		
		initGui();
	}

	private void initGui() {
		
		this.setMargin(false);
		this.setSizeUndefined();
		Label lSender=new Label(message.getSender()+ " "+ message.getDate().format(dtf));
		lSender.addStyleName(ValoTheme.LABEL_BOLD);
		this.addComponent(lSender);
		this.setExpandRatio(lSender, 0);

		Label lSubject=new Label(message.getSubject());
		this.addComponent(lSubject);
		this.setExpandRatio(lSubject, 0);
		
//		Label lMessage=new Label(message.getMessage());
//		lMessage.setContentMode(ContentMode.HTML);
//		lMessage.setWidth("100%");
//		this.addComponent(lMessage);
//		this.setExpandRatio(lMessage, 1);
		
		this.addLayoutClickListener(e->clicked());
		
	}
	
	private void clicked() {
		listeners.stream().forEach(e->e.setMessage(message.getMessage()));
	}

	public void addMessageClickListener(IMessageClick mc) {
		this.listeners.add(mc);
	}

	public String getMessage() {
		return message.getMessage();
	}
}
