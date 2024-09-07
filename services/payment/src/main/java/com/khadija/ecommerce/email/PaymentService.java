package com.khadija.ecommerce.email;

import com.khadija.ecommerce.dto.PaymentMapper;
import com.khadija.ecommerce.dto.PaymentRequest;
import com.khadija.ecommerce.kafka.NotificationProducer;
import com.khadija.ecommerce.kafka.PaymentNotificationRequest;
import com.khadija.ecommerce.model.Payment;
import com.khadija.ecommerce.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public PaymentService(PaymentRepository repository, PaymentMapper mapper, NotificationProducer notificationProducer) {
        this.repository = repository;
        this.mapper = mapper;
        this.notificationProducer = notificationProducer;
    }

    public Integer createPayment(PaymentRequest request) {
        Payment payment = repository.save(mapper.toPayment(request));
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }
}
