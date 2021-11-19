package com.vincent.consumerapplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EventServiceTest {
    EventService eventService = new EventService();
    @Test
    void shouldAddGrantedValueFromMockAPIToEvent() throws JsonProcessingException {
        Event event = new Event("62007075197",188.21,"2022-11-01",
                "VODSWMTTTRBC",false,true);
        Assertions.assertNotNull(eventService.enrichEvent(event).getGranted());
    }
    @Test
    void shouldCheckDecisionForEvent(){
        Event event = new Event("62007075197",188.21,"2022-11-01",
                "VODSWMTTTRBC",false,true);
        event.setGranted(true);
        Rule rule = eventService.checkDecision(event);
        Assertions.assertAll(
                ()-> Assertions.assertEquals(1L,rule.getId()),
                () -> Assertions.assertEquals("negative", rule.getResult()));
    }
}
