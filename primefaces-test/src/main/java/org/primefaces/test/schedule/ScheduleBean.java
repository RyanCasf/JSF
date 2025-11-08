package org.primefaces.test.schedule;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.timeline.TimelineModel;
import org.primefaces.util.CalendarioUtil;

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
			public void loadEvents(Date inicio, Date fim) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				System.out.println("Início: " + sdf.format(inicio));
				System.out.println("Fim: " + sdf.format(fim));
				
				DefaultScheduleEvent item0 = new DefaultScheduleEvent("0", new Date(), CalendarioUtil.dataAmanha());
				item0.setDescription("Item 0");
				addEvent(item0);
				
				DefaultScheduleEvent item1 = new DefaultScheduleEvent("1", CalendarioUtil.dataOntem(), CalendarioUtil.dataAmanha());
				item1.setDescription("Item 1");
				addEvent(item1);
			}
		};
	}
}