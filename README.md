1) Created a REST API to Send Message to Kafka Producer Topic: 
Objective: Enabled external systems (e.g., frontend, other microservices) to produce messages to Kafka via HTTP.

Implementation:

Built a REST controller using @RestController.

Created an endpoint (e.g., /api/messages) to accept incoming requests.

Injected KafkaTemplate<String, String> to publish string messages to a configured Kafka topic.

Technical Insight: This design abstracts Kafka complexity from external clients, adhering to separation of concerns and providing a clean RESTful interface.

2) Created Kafka Consumer to Receive Messages from Kafka Topic:
Objective: Set up a Kafka listener to asynchronously receive and process messages.

Implementation:

Used @KafkaListener(topics = "...", groupId = "...") to subscribe to the desired Kafka topic.

Implemented message handling logic inside the listener method.

Professional Note: Ensured that message acknowledgment, exception handling, and logging were handled efficiently to prevent message loss and aid in debugging.

3) Implemented Spring Kafka – JSON Serializer and Deserializer: 
Objective: Enable structured data exchange in JSON format between producer and consumer.

Implementation:

Configured Kafka producer to use JsonSerializer.

Configured Kafka consumer to use JsonDeserializer with target class type.

Registered custom ConsumerFactory and KafkaListenerContainerFactory.

Engineering Reasoning: Using JSON allows transmission of domain objects (POJOs), which is more scalable and maintainable than plain strings.

4) Created Kafka Producer to Produce JSON Message: 
Objective: Extend the producer to send complex domain objects as JSON instead of plain strings.

Implementation:

Defined a POJO (e.g., UserEvent, OrderEvent) with proper structure.

Used KafkaTemplate<String, Object> for producing typed messages.

Converted the REST endpoint to accept the JSON payload and publish it.

Benefit: Improved data expressiveness and aligned with enterprise integration practices using structured messages.

5) Created Kafka Consumer to Consume JSON Message: 
Objective: Enable type-safe message consumption for downstream processing.

Implementation:

Modified @KafkaListener to deserialize JSON to specific POJO.

Injected business logic to handle the deserialized object, such as saving to DB or triggering events.

Advantage: Reduced manual parsing logic, improved maintainability, and enhanced type safety during message processing.

6) Refactored Code to Externalize Kafka Topic Name (Removed Hardcoded Values): 
Objective: Improve configuration flexibility and environment adaptability.

Implementation:

Moved topic names to application.yml or application.properties.

Injected topic name using @Value("${kafka.topic.name}").

Justification:

Facilitates easy reconfiguration between environments (dev, QA, prod).

Aligns with 12-factor app principles and centralized configuration practices.
