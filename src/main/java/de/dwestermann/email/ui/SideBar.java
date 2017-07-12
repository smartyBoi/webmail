package de.dwestermann.email.ui;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Resource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class SideBar extends VerticalLayout {

	
	public SideBar() {
		
		this.setWidth("100px");
		this.setHeight("100%");
		this.setMargin(false);
		
		Button bCompose=createButton("Compose",VaadinIcons.EDIT,e->composeSelected(e));
		this.addComponent(bCompose);
		this.setComponentAlignment(bCompose, Alignment.TOP_LEFT);
		this.setExpandRatio(bCompose, 0);
		
		Button bInbox=createButton("Inbox",VaadinIcons.INBOX,e->inboxSelected(e));
		this.addComponent(bInbox);
		this.setComponentAlignment(bInbox, Alignment.TOP_LEFT);
		this.setExpandRatio(bInbox, 0);
		
		Button bSent=createButton("Sent",VaadinIcons.PAPERPLANE,e->sentSelected(e));
		this.addComponent(bSent);
		this.setComponentAlignment(bSent, Alignment.TOP_LEFT);
		this.setExpandRatio(bSent, 0);
		
		Button bTrash=createButton("Trash",VaadinIcons.TRASH,e->trashSelected(e));
		this.addComponent(bTrash);
		this.setComponentAlignment(bTrash, Alignment.TOP_LEFT);
		this.setExpandRatio(bTrash, 0);
		
		HorizontalLayout hl=new HorizontalLayout();
		hl.addComponent(createButton("", VaadinIcons.PLUS, e->plusClicked(e)));
		hl.addComponent(createButton("", VaadinIcons.MINUS, e->minusClicked(e)));
		this.addComponent(hl);
		this.setComponentAlignment(hl, Alignment.BOTTOM_LEFT);
		this.setExpandRatio(hl, 1);
	}
			
	private Object minusClicked(ClickEvent e) {
		return null;
	}

	private Object plusClicked(ClickEvent e) {
		return null;
	}

	private Button createButton(String caption, Resource icon, ClickListener click ) {
		
		Button b=new Button(caption, click);
		b.setIcon(icon);
		b.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		b.setSizeUndefined();
		return b;
	}
		
	private Object inboxSelected(ClickEvent e) {
		return null;
	}


	private Object trashSelected(ClickEvent e) {
		return null;
	}

	private Object sentSelected(ClickEvent e) {
		return null;
	}
	
	private Object composeSelected(ClickEvent e) {
		return null;
	}
}
