package com.vincent.consumerapplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/enrich")
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping
    public ResponseEntity<Payload> enrichEvent(@RequestBody Event event) throws JsonProcessingException {
        Event enrichedEvent = eventService.enrichEvent(event);
        Rule rule = eventService.checkDecision(enrichedEvent);
        Payload payload = new Payload(event.getAccountNumber(),event.getTransactionAmount(),
                                    event.getTransactionEffectiveDate(),event.getTransactionTraceIdentifier(),
                                    event.isMarketingConsent(),event.isKycIndicator());
        payload.setRuleId(rule.getId());
        payload.setRuleResult(rule.getResult());
        return ResponseEntity.ok(payload);
    }
}
