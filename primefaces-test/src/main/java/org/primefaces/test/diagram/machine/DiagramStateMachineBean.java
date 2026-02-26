package org.primefaces.test.diagram.machine;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Named
@ViewScoped
public class DiagramStateMachineBean implements Serializable {
	
	private DefaultDiagramModel model;
	
	public DiagramStateMachineBean() {
		model = new DefaultDiagramModel();
		
		Element aguardando = new Element("Aguardando", "0em", "16em");
		aguardando.addEndPoint(new DotEndPoint(EndPointAnchor.RIGHT));
		model.addElement(aguardando);
		
		Element aprovado = new Element("Aprovado", "25em", "10em");
		aprovado.addEndPoint(new DotEndPoint(EndPointAnchor.LEFT));
		model.addElement(aprovado);
		
		Element reprovado = new Element("Reprovado", "25em", "20em");
		reprovado.addEndPoint(new DotEndPoint(EndPointAnchor.LEFT));
		model.addElement(reprovado);
		
		StraightConnector connector = new StraightConnector();
		connector.setPaintStyle("{stroke:'#980000', strokeWidth:3}");
		model.setDefaultConnector(connector);
		
		model.connect(new Connection(aguardando.getEndPoints().get(0), aprovado.getEndPoints().get(0)));
		model.connect(new Connection(aguardando.getEndPoints().get(0), reprovado.getEndPoints().get(0)));
	}
}