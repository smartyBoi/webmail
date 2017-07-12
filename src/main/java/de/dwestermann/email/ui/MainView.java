package de.dwestermann.email.ui;

import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.ItemClick;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalSplitPanel;

import de.dwestermann.email.backend.IMessage;
import de.dwestermann.email.backend.MessageService;

@SpringComponent
@Scope("prototype")
@PreserveOnRefresh
@SpringView(name = MainView.NAME)

public class MainView extends Panel implements View {

	public static final String NAME = "";
	private final DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm:ss");
	
	private final VerticalSplitPanel vsplit = new VerticalSplitPanel();
	private final Label messageLabel = new Label();
	private final MessageService service;

	public MainView(MessageService service) {
		this.service = service;

		this.setContent(vsplit);
		vsplit.setSizeFull();
		this.setSizeFull();

		messageLabel.setContentMode(ContentMode.HTML);
		messageLabel.setWidth("100%");
		vsplit.setSecondComponent(messageLabel);
	}

	@PostConstruct
	public void initGui() {

		Grid<IMessage> grid = new Grid<>(IMessage.class);
		
		grid.setSizeFull();
		vsplit.setFirstComponent(grid);
		grid.setItems(service.getMessages());
		grid.removeAllColumns();
		grid.addColumn(IMessage::getSender).setCaption("Sender").setExpandRatio(1);
		grid.addColumn(IMessage::getSubject).setCaption("Subject").setExpandRatio(2);
		grid.addColumn(e->e.getDate().format(dtf)).setCaption("Date").setExpandRatio(1);
		grid.addItemClickListener(e->itemClicked(e));

	}

	private void itemClicked(ItemClick<IMessage> e) {
		messageLabel.setValue(e.getItem().getMessage());
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}



}
