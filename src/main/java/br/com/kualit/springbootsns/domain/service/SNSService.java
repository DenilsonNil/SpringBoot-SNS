package br.com.kualit.springbootsns.domain.service;

import br.com.kualit.springbootsns.domain.model.NotificationDTO;
import br.com.kualit.springbootsns.domain.model.SubscriptionDTO;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.*;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SNSService {

    @Value("${amazon.topicARN}")
    private String TOPIC_ARN;

    @Autowired
    private AmazonSNSClient snsClient;

    public void addSubscription(SubscriptionDTO subscriptionDTO) {
        val snsRequest = new SubscribeRequest(TOPIC_ARN, subscriptionDTO.protocol(), subscriptionDTO.endpoint());
        snsClient.subscribe(snsRequest);
    }

    public void unSub(String subscriptionArn) {
        val request = new UnsubscribeRequest(subscriptionArn);
        snsClient.unsubscribe(request);
    }

    public List<Subscription> listSNSSubscriptions() {
        val request = new ListSubscriptionsRequest();
        return snsClient.listSubscriptions(request).getSubscriptions();
    }

    public void sendNotification(NotificationDTO notificationDTO) {
        val publishRequest = new PublishRequest(TOPIC_ARN, notificationDTO.messageBody(), notificationDTO.subject());
        snsClient.publish(publishRequest);
    }
}
