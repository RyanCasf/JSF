package br.com.ryan.home;

import java.io.Serializable;

import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

import org.primefaces.component.dashboard.Dashboard;
import org.primefaces.component.panel.Panel;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

@ManagedBean @ViewScoped
public class ManagedBeanHome implements Serializable {
	private final String title = "Gerente";
	private final String subtitle = "Ger�ncia geral";

	private Dashboard dashboard;

	public ManagedBeanHome() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Application application = fc.getApplication();

		dashboard = (Dashboard) application.createComponent(fc, "org.primefaces.component.Dashboard", "org.primefaces.component.DashboardRenderer");
		dashboard.setId("dashboard");

		DashboardModel model = new DefaultDashboardModel();
		for( int i = 0, n = 4; i < n; i++ ) {
			DashboardColumn column = new DefaultDashboardColumn();
			model.addColumn(column);
		}
		dashboard.setModel(model);

		for( int i = 0, n = 4; i < n; i++ ) {
			Panel panel = (Panel) application.createComponent(fc, "org.primefaces.component.Panel", "org.primefaces.component.PanelRenderer");
			panel.setId("measure_" + i);
			panel.setHeader("Dashboard Component " + i);
			panel.setClosable(true);
			panel.setToggleable(true);

			getDashboard().getChildren().add(panel);
			DashboardColumn column = model.getColumn(i%4);
			column.addWidget(panel.getId());
			HtmlOutputText text = new HtmlOutputText();
			text.setValue("Dashboard widget bits!" );

			panel.getChildren().add(text);
		}
	}
	
	public void handleReorder(DashboardReorderEvent event) {
		JOptionPane.showMessageDialog(null, event);
	}

	public String getTitle() {
		return this.title;
	}

	public String getSubtitle() {
		return this.subtitle;
	}

	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}
}