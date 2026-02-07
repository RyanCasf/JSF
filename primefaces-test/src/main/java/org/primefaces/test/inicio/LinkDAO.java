package org.primefaces.test.inicio;

import static org.primefaces.test.inicio.MenuGroup.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkDAO {
	
	public static List<LinkDTO> getAll() {
		return new ArrayList<>(Arrays.asList(
				LinkDTO.builder().group(FORM).value("AutoComplete").outcome("/autocomplete").build(),
				LinkDTO.builder().group(FORM).value("Data").outcome("/data").build(),
				LinkDTO.builder().group(FORM).value("Select One Menu").outcome("/selectOneMenu").build(),
				LinkDTO.builder().group(FORM).value("Select One Menu (Lazy)").outcome("/select-one-menu/lazy").build(),
				LinkDTO.builder().group(FORM).value("Select One Menu (Cor)").outcome("/select-one-menu/color").build(),
				LinkDTO.builder().group(SEPARATOR).build(),
				LinkDTO.builder().group(AJAX).value("Ajax").outcome("/ajax_poll").build(),
				LinkDTO.builder().group(SEPARATOR).build(),
				LinkDTO.builder().group(DATA_TABLE).value("Datatable").outcome("/datatable").build(),
				LinkDTO.builder().group(DATA_TABLE).value("Datatable (Tabela - Kai)").outcome("/datatable/table").build(),
				LinkDTO.builder().group(DATA_TABLE).value("Virtual Scrolling").outcome("/datatable/virtual-scrolling").build(),
				LinkDTO.builder().group(DATA_TABLE).value("DataScroller").outcome("/datascroller/scrolling").build(),
				LinkDTO.builder().group(SEPARATOR).build(),
				LinkDTO.builder().group(MULTIMEDIA).value("Media").outcome("/media").build(),
				LinkDTO.builder().group(SEPARATOR).build(),
				LinkDTO.builder().group(DIALOG).value("Dialog").outcome("/dialog").build(),
				LinkDTO.builder().group(DIALOG).value("Dialog (load spinner)").outcome("/dialog/load-spinner").build(),
				LinkDTO.builder().group(SEPARATOR).build(),
				LinkDTO.builder().group(MENU).value("TabMenu").outcome("/menu/tab-menu").build(),
				LinkDTO.builder().group(SEPARATOR).build(),
				LinkDTO.builder().group(SCHEDULE).value("Schedule").outcome("/schedule").build(),
				LinkDTO.builder().group(SEPARATOR).build(),
				LinkDTO.builder().group(TIMELINE).value("Timeline").outcome("/timeline").build(),
				LinkDTO.builder().group(SEPARATOR).build(),
				LinkDTO.builder().group(MISC).value("DefaultCommand").outcome("/defaultcommand/scope").build(),
				LinkDTO.builder().group(SEPARATOR).build(),
				LinkDTO.builder().group(MISC).value("CommandButton").outcome("/commandbutton/icon-animation").build(),
				LinkDTO.builder().group(BUTTON).value("SplitButton").outcome("/splitbutton/menuitem").build()
		));
	}
}