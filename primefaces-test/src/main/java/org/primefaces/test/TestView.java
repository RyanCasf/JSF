package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.timeline.TimelineAddEvent;
import org.primefaces.event.timeline.TimelineModificationEvent;
import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class TestView implements Serializable {
	
	private TimelineModel timeline;
	private LocalDateTime start = LocalDateTime.now().minusDays(1L);
	private LocalDateTime end = LocalDateTime.now().plusDays(1L);
	
	public TestView() {
		String[] names = new String[] { "User 1", "User 2", "User 3", "User 4", "User 5", "User 6" };
		timeline = new TimelineModel();
		
		for (String name : names) {
			LocalDateTime endDate = LocalDateTime.now().minusHours(12).withMinute(0).withSecond(0).withNano(0);

			for (int i = 0; i < 5; i++) {
				LocalDateTime startDate = endDate.plusHours(Math.round(Math.random() * 5));
				endDate = startDate.plusHours(4 + Math.round(Math.random() * 5));

				long r = Math.round(Math.random() * 2);
				String availability = disponibilidade(r);

				TimelineEvent event = new TimelineEvent();
				event.setData(availability);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setEditable(true);
				event.setGroup(name);
				event.setStyleClass(availability.toLowerCase());
				
				timeline.add(event);
			}
		}
	}

	private String disponibilidade(long r) {
		if (r == 0) {
			return "Unavailable";
		}
		
		return r == 1 ? "Available" : "Maybe";
	}
	
	public void onAdd(TimelineAddEvent timelineAddEvent) {
		System.out.println("Add: " + timelineAddEvent);
	}
	
	public void onChange(TimelineModificationEvent timelineModificationEvent) {
		System.out.println("Change: " + timelineModificationEvent);
    }

    public void onChanged(TimelineModificationEvent timelineModificationEvent) {
    	System.out.println("Changed: " + timelineModificationEvent);
    }
	
	public void onEdit(TimelineModificationEvent timelineModificationEvent) {
		System.out.println("Edit: " + timelineModificationEvent);
	}
	
	public void onDelete(TimelineModificationEvent timelineModificationEvent) {
		System.out.println("Delete: " + timelineModificationEvent);
	}
}