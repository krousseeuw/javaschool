package oefening2;

import java.util.ArrayList;

import opgave2.oefening2.Docent;

public abstract class EValf {
	protected static EValf instance = null;
	public ArrayList<Message> messageList;
	
	protected EValf() {
		messageList = new ArrayList<Message>();
	}
	
	protected abstract EValf getInstance();
	
	public boolean post(Message m) {
		if(m.getPersoon()instanceof Docent)
			return messageList.add(m);
		else
			return false;
	}
	
	public boolean remove(Message m) {
		return messageList.remove(m);
	}
}
