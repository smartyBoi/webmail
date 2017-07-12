package de.dwestermann.email.backend.repo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import de.dwestermann.email.backend.IMessage;

@Repository
public class MessageRepository {

	public List<IMessage> getMessages() {
		return fakeMessages();
	}
	
	
	private List<IMessage> fakeMessages(){
		
		List<IMessage> list=new ArrayList<>();
		
		list.add(new Message("gjls@com","Hallo Mister",LocalDateTime.now(), "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."));
		list.add(new Message("gdfgdgs@com","Die Verwandlung Franz Kafka",LocalDateTime.now(), "<html><h1>One morning, when Gregor Samsa woke from troubled \r\n" + 
				"dreams.</h1>\r\n" + 
				"<p>One morning, when Gregor Samsa woke from troubled \r\n" + 
				"dreams, he found himself transformed in his bed into \r\n" + 
				"a horrible vermin. He lay on his armour-like back, \r\n" + 
				"and if he lifted his head a little he could see his \r\n" + 
				"brown belly, slightly domed and divided by arches into \r\n" + 
				"stiff sections. The bedding was hardly able to cover \r\n" + 
				"<strong>strong</strong> it and seemed ready to slide \r\n" + 
				"off any moment. His many legs, pitifully thin \r\n" + 
				"compared with the size of the rest of him, \r\n" + 
				"<a class=\"external ext\" href=\"#\">link</a> waved about \r\n" + 
				"helplessly as he looked. \"What's happened to me? \" he \r\n" + 
				"thought. It wasn't a dream. His room, a proper human \r\n" + 
				"room although a little too small, lay peacefully \r\n" + 
				"between its four familiar walls.</p>\r\n</html>"));
		
		
		return list;
		
	}

}
