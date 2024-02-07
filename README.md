### ABOUT THIS PROJECT
This project implements a Amazon SNS Service. 
You can

- Subscribe in a Topic
- Unsubscribe
- List all subscriptions of a specific topic
- Send message notification
  

### HOW TO USE IT
Open the file application.yml
Provide values for the environment variables below:

- AMAZON_CONFIG_ACCESS_KEY
- AMAZON_CONFIG_SECRET_KEY
- AMAZON_CONFIG_REGION
- AMAZON_TOPIC_ARN

Run the application

### CURL

## Subscribe in a specific topic 

```curl
curl --location 'localhost:8080/api/v1/subscribe' \
--header 'Content-Type: application/json' \
--data-raw '{
    "protocol": "email",
    "endpoint": "admin@kualit.com.br"
}'
```

## Unsubscribe
```curl
curl --location 'localhost:8080/api/v1/unsubscribe/SUBSCRIPTION_ARN'
```

## List all subscriptions
```curl
curl --location 'localhost:8080/api/v1/subscriptions'
```

## Send a message notification
```curl
curl --location 'localhost:8080/api/v1/notify' \
--header 'Content-Type: application/json' \
--data '{
    "subject": "TEST",
    "messageBody": "OK"
}'
```

