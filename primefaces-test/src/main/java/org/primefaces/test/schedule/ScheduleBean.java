package org.primefaces.test.schedule;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.timeline.TimelineModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class ScheduleBean implements Serializable {
	
	private ScheduleModel schedule;
	private TimelineModel timeline;
	
	public ScheduleBean() {
		timeline = new TimelineModel();
		schedule = new LazyScheduleModel() {
			
			@Override
			public void loadEvents(LocalDateTime start, LocalDateTime end) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				
				System.out.println("Início: " + sdf.format(start));
				System.out.println("Fim: " + sdf.format(end));
				
				addEvent(DefaultScheduleEvent.builder()
						.id("0")
						.startDate(LocalDateTime.now())
						.endDate(LocalDateTime.now().plusDays(1L))
						.description("Item 0")
						.build());
				
				addEvent(DefaultScheduleEvent.builder()
						.id("1")
						.startDate(LocalDateTime.now().minusDays(1L))
						.endDate(LocalDateTime.now().plusDays(1L))
						.description("Item 0")
						.build());
			}
		};
	}
}