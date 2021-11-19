package com.vincent.consumerapplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vincent.consumerapplication.apimodel.APIResponse;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    public Event enrichEvent(Event event) throws JsonProcessingException {
        APIResponse apiResponse = getAPIResponse();
        boolean granted = apiResponse.getData().get(0).getGoodReplyRecord().get(0).isGranted();
        event.setGranted(granted);
        return event;
    }

    private APIResponse getAPIResponse() throws JsonProcessingException {
        /*
            Decided to use a hardcoded response from API. A RestTemplate can be used to do a call to a live API
            and map the response in a similar manner.
         */
        final ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String json = "{ \n" +
                "    \"data\": \n" +
                "    [ \n" +
                "        { \n" +
                "            \"badReplyRecord\": null, \n" +
                "            \"goodReplyRecord\": \n" +
                "            [ \n" +
                "                { \n" +
                "                    \"ucn\": 12345, \n" +
                "                    \"granted\": true \n" +
                "                } \n" +
                "            ] \n" +
                "        } \n" +
                "    ], \n" +
                "    \"errors\": null \n" +
                "} ";
        return mapper.readValue(json,APIResponse.class);
    }
}
