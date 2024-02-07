package br.com.kualit.springbootsns.api.controller;

import br.com.kualit.springbootsns.domain.model.NotificationDTO;
import br.com.kualit.springbootsns.domain.model.SubscriptionDTO;
import br.com.kualit.springbootsns.domain.service.SNSService;
import com.amazonaws.services.sns.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SNSAppController {

    @Autowired
    private SNSService snsService;

    @PostMapping("/subscribe")
    public ResponseEntity<?> subscribe(@RequestBody SubscriptionDTO subscriptionDTO) {
        snsService.addSubscription(subscriptionDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/unsubscribe/{subscriptionARN}")
    public ResponseEntity<?> listSubscriptions(@PathVariable String subscriptionARN) {
        snsService.unSub(subscriptionARN);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/subscriptions")
    public ResponseEntity<List<Subscription>> listSubscriptions() {
        return ResponseEntity.ok(snsService.listSNSSubscriptions());
    }
}
