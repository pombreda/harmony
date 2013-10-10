package fr.labri.harmony.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
/**
 * An author performs events.
 *
 */
@Entity
public class Author extends SourceElement {
	
	@Basic
	private String name;
	
	@ManyToMany(mappedBy="authors")
	private List<Event> events;

	public Author() {
		events = new ArrayList<>();
	}
	
	public Author(Source source, String nativeId, String name) {
		this.source = source;
		this.nativeId = nativeId;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	
}
