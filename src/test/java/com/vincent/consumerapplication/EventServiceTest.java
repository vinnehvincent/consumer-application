package com.vincent.consumerapplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EventServiceTest {
    EventService eventService = new EventService();
    @Test
    void shouldAddGrantedValueFromMockAPIToEvent() throws JsonProcessingException {
        Event event = new Event("62007075197",188.21,"2022-11-01",
                "VODSWMTTTRBC",false,true);
        Assertions.assertNotNull(eventService.enrichEvent(event).getGranted());
    }
}
