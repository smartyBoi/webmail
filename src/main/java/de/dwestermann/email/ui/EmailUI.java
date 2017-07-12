package de.dwestermann.email.ui;


import javax.annotation.PostConstruct;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
@SpringUI
@SpringViewDisplay
public class EmailUI extends UI implements ViewDisplay {

	private Panel springViewDisplay;
	
	@Override
	protected void init(VaadinRequest request) {
	
		  final HorizontalLayout root = new HorizontalLayout();
	        root.setSizeFull();
	        setContent(root);
	        SideBar sideBar=new SideBar();
	        root.addComponent(sideBar);
	        root.setExpandRatio(sideBar, 0);
	        
	        VerticalLayout vl=new VerticalLayout();
	        vl.setSizeFull();
	        TopBar topBar=new TopBar();
	        vl.addComponent(topBar);
	        vl.setComponentAlignment(topBar, Alignment.BOTTOM_RIGHT);
	        
	        springViewDisplay = new Panel();
	        springViewDisplay.setSizeFull();
	        vl.addComponent(springViewDisplay);
	        vl.setExpandRatio(springViewDisplay, 1);
	        root.addComponent(vl);
	        root.setExpandRatio(vl, 1);
	       
	        this.setContent(root);
	}
	
	@PostConstruct
	public void setNavigator() {
		Navigator nav=new Navigator(this,springViewDisplay);
        this.setNavigator(nav);
	}
	
	@Override
	public void showView(View view) {
		springViewDisplay.setContent((Component) view);
	}
	
}
