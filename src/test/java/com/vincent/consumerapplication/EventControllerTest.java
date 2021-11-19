package com.vincent.consumerapplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(controllers = EventController.class)
public class EventControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private EventService eventService;

    @Test
    void shouldCallEventService() throws Exception {
        Event event = new Event("62007075197",188.21,"2022-11-01",
                "VODSWMTTTRBC",false,true);
        Event returnedEvent = new Event("62007075197",188.21,"2022-11-01",
                "VODSWMTTTRBC",false,true);
        returnedEvent.setGranted(false);
        Mockito.when(eventService.enrichEvent(event)).thenReturn(returnedEvent);
        mockMvc.perform(post("/enrich")
                .contentType(APPLICATION_JSON)
                .content(asJsonString(event)))
                .andExpect(status().isOk());
        Mockito.verify(eventService,Mockito.times(1)).enrichEvent(event);
        Mockito.verify(eventService,Mockito.times(1)).checkDecision(returnedEvent);
    }

    private String asJsonString(Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
