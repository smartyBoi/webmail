package de.dwestermann.email.ui;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.themes.ValoTheme;

public class TopBar extends HorizontalLayout {
	
	public enum Sortings {SUBJECT("Subject"),DATE("Date"), SENDER("Sender"), RECIVER("Receiver");
		String name;
		
		Sortings(String s){
			name=s;
		}
		@Override
		public String toString() {
			return name;
		}
	
	};

	public TopBar() {
		
		this.setWidth("100%");
		Label lSort=new Label("Sort by");
		lSort.setSizeUndefined();
		this.addComponent(lSort);
		this.setExpandRatio(lSort, 0);
		this.setComponentAlignment(lSort, Alignment.BOTTOM_LEFT);
		
		ComboBox<Sortings> cb=new ComboBox<>();
		cb.setItems(Sortings.values());
		cb.setTextInputAllowed(false);
		cb.setSelectedItem(Sortings.DATE);
		cb.setEmptySelectionAllowed(false);
		cb.addStyleName(ValoTheme.COMBOBOX_SMALL);
		this.addComponent(cb);
		this.setComponentAlignment(cb, Alignment.BOTTOM_LEFT);
		this.setExpandRatio(cb, 0);
		
		
		MenuBar menu =new MenuBar();
		menu.addItem("",VaadinIcons.CLOSE_SMALL, e->trashCommand());
		menu.addItem("",VaadinIcons.ARROW_BACKWARD, e->backCommand());
		menu.addItem("",VaadinIcons.ARROW_FORWARD, e->forwardCommand());
		menu.addStyleName(ValoTheme.MENUBAR_SMALL);
		
		this.addComponent(menu);
		this.setComponentAlignment(menu, Alignment.BOTTOM_RIGHT);
		this.setExpandRatio(menu, 1);
		
	}
	
private Object forwardCommand() {
		return null;
	}

private Object backCommand() {
		return null;
	}

private Object trashCommand() {
		return null;
	}


}
