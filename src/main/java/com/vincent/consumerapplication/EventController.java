package com.vincent.consumerapplication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/enrich")
public class EventController {
    @PostMapping
    public ResponseEntity<Payload> enrichEvent(@RequestBody Event event){
        Payload payload = new Payload(event.getAccountNumber(),event.getTransactionAmount(),
                                    event.getTransactionEffectiveDate(),event.getTransactionTraceIdentifier(),
                                    event.isMarketingConsent(),event.isKycIndicator());
        payload.setRuleId(1L);
        payload.setRuleResult("negative");
        return ResponseEntity.ok(payload);
    }
}
