package org.primefaces.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.provider.NullSource;
import org.primefaces.event.timeline.TimelineAddEvent;
import org.primefaces.event.timeline.TimelineModificationEvent;
import org.primefaces.test.util.ParameterizedNameDefaultTest;

@DisplayName("Test View")
class TestViewTest {
	
	private TestView bean;
	
	@BeforeEach
	void setUp() {
		bean = new TestView();
		
		assertNotNull(bean.getTimeline());
		assertNotNull(bean.getStart());
		assertNotNull(bean.getEnd());
	}
	
	@Nested
	@DisplayName("On Add")
	class OnAdd {
		
		@ParameterizedNameDefaultTest
		@NullSource
		@DisplayName("Sem evento.")
		void semEvento(TimelineAddEvent timelineAddEvent) {
			assertDoesNotThrow(() -> bean.onAdd(null));
		}
	}
	
	@Nested
	@DisplayName("On Change")
	class OnChange {
		
		@ParameterizedNameDefaultTest
		@NullSource
		@DisplayName("Sem evento.")
		void semEvento(TimelineModificationEvent timelineModificationEvent) {
			assertDoesNotThrow(() -> bean.onChange(null));
	    }
	}
	
	@Nested
	@DisplayName("On Changed")
	class OnChanged {
		
		@ParameterizedNameDefaultTest
		@NullSource
		@DisplayName("Sem evento.")
	    void semEvento(TimelineModificationEvent timelineModificationEvent) {
			assertDoesNotThrow(() -> bean.onChanged(null));
	    }
	}
	
	@Nested
	@DisplayName("On Edit")
	class OnEdit {
		
		@ParameterizedNameDefaultTest
		@NullSource
		@DisplayName("Sem evento.")
		void semEvento(TimelineModificationEvent timelineModificationEvent) {
			assertDoesNotThrow(() -> bean.onEdit(null));
		}
	}
	
	@Nested
	@DisplayName("On Delete")
	class OnDelete {
		
		@ParameterizedNameDefaultTest
		@NullSource
		@DisplayName("Sem evento.")
		void semEvento(TimelineModificationEvent timelineModificationEvent) {
			assertDoesNotThrow(() -> bean.onDelete(null));
		}
	}
}