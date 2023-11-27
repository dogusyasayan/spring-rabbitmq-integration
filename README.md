### English Description
# Spring RabbitMQ Application

## Core Concepts
- **Producer:** The entity that sends messages to the RabbitMQ queue. In this application, the role of a producer is taken by `RabbitMQProducer`.
- **Consumer:** The entity that receives messages from the RabbitMQ queue. In this application, `RabbitMQConsumer` and `RabbitMQJsonConsumer` take on this role.
- **Exchange:** Mechanism directing messages to consumers. This application uses a `TopicExchange`.
- **Queue:** The place where messages are stored and delivered to consumers. This application has two different queues: one for regular messages (`queue`) and another for JSON-formatted messages (`jsonQueue`).

## Project Structure

- **Configuration (com.springrabbitmq.config):** Contains RabbitMQ configurations. The `RabbitMQConfiguration` class creates queues, exchanges, and bindings, while the `RabbitMQPropertiesConfig` class holds configuration properties.

- **Consumer (com.springrabbitmq.consumer):** Consumer classes listening to messages. `RabbitMQConsumer` and `RabbitMQJsonConsumer` fulfill this role.

- **Controller (com.springrabbitmq.controller):** Controller classes providing HTTP endpoints. `MessageController` and `MessageJsonController` manage message publishing operations.

- **Domain (com.springrabbitmq.domain):** Contains the `User` class carrying JSON messages.

- **Publisher (com.springrabbitmq.publisher):** Publisher classes sending messages to RabbitMQ. `RabbitMQProducer` and `RabbitMQJsonProducer` undertake this task.

# Installation Steps

1. **RabbitMQ Installation:**
    - Ensure that RabbitMQ is installed and running.
    - Adjust RabbitMQ configuration properties if needed in the `application.properties` file.

    ```properties
    # application.properties
    rabbitmq.host=localhost
    rabbitmq.port=5672
    rabbitmq.username=guest
    rabbitmq.password=guest
    ```

    Note: Adjust RabbitMQ configuration properties according to your environment.

   # Spring RabbitMQ Application and Dockerized RabbitMQ Setup

## Dockerized RabbitMQ Installation

### 1. Download RabbitMQ Docker Image:
To use RabbitMQ on Docker, you need to download the RabbitMQ Docker image. Use the following command to download the RabbitMQ image:

```sh
docker pull rabbitmq
```

### 2. Create and Run RabbitMQ Container:
Now let's start the RabbitMQ container. Use the following command to create and run the RabbitMQ container:

```sh
docker run -d --name my-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:latest
```

3. **Run the Project:**
    - To start your project, use the following command:

    ```sh
    ./mvnw spring-boot:run
    ```

    veya

    ```sh
    mvn spring-boot:run
    ```

   Note: Ensure that RabbitMQ configuration details are correct for successful communication when the project starts.

4. **Usage:**
    - After the project starts, you can use it by navigating to localhost:8080.



### Türkçe Açıklama

# Spring RabbitMQ Uygulaması Uygulaması

## Temel Kavramlar
- **Yayıncı (Producer):** Mesajları RabbitMQ kuyruğuna gönderen taraf. Bu uygulamada RabbitMQProducer görevi üstlenir.
- **Tüketici (Consumer):** RabbitMQ kuyruğundan mesajları alan taraf. Bu uygulamada RabbitMQConsumer ve RabbitMQJsonConsumer görevi üstlenir.
- **Exchange:** Tüketiciye ulaştırılacak mesajları yönlendiren mekanizmadır. Bu uygulamada TopicExchange kullanılmıştır.
- **Kuyruk (Queue):** Mesajların depolandığı ve tüketicilere teslim edildiği yer. Bu uygulamada iki farklı kuyruk bulunmaktadır: biri normal mesajlar için (`queue`), diğeri JSON formatındaki mesajlar için (`jsonQueue`).

## Proje Yapısı

- **Yapılandırma (com.springrabbitmq.config):** RabbitMQ yapılandırmalarını içerir. `RabbitMQConfiguration` sınıfı kuyrukları, exchange'i ve bağlamaları oluştururken, `RabbitMQPropertiesConfig` sınıfı yapılandırma özelliklerini içerir.

- **Tüketici (com.springrabbitmq.consumer):** Mesajları dinleyen tüketici sınıflarıdır. `RabbitMQConsumer` ve `RabbitMQJsonConsumer` bu rolü üstlenir.

- **Denetleyici (com.springrabbitmq.controller):** HTTP endpoint'lerini sağlayan denetleyici sınıflarıdır. `MessageController` ve `MessageJsonController` ile mesaj yayınlama işlemlerini yönetirler.

- **Domain (com.springrabbitmq.domain):** JSON mesajlarını taşıyan `User` sınıfını içerir.

- **Yayıncı (com.springrabbitmq.publisher):** Mesajları RabbitMQ'ya ileten yayıncı sınıflarıdır. `RabbitMQProducer` ve `RabbitMQJsonProducer` bu görevi üstlenir.

- # Kurulum Adımları

1. **RabbitMQ Kurulumu:**
    - RabbitMQ'nun kurulu ve çalışır durumda olduğundan emin olun.
    - Gerekirse `application.properties` içindeki RabbitMQ yapılandırma özelliklerini ayarlayın.

    ```properties
    # application.properties
    rabbitmq.host=localhost
    rabbitmq.port=5672
    rabbitmq.username=guest
    rabbitmq.password=guest
    ```

    Not: RabbitMQ yapılandırma özelliklerini kendi ortamınıza uygun şekilde düzenleyin.

   # Spring RabbitMQ Uygulaması ve Docker İle RabbitMQ Kurulumu

## Docker ile RabbitMQ Kurulumu

### 1. RabbitMQ Docker Image İndirme:
Docker üzerinde RabbitMQ kullanmak için öncelikle RabbitMQ Docker imajını indirmeniz gerekmektedir. Aşağıdaki komutu kullanarak RabbitMQ imajını indirebilirsiniz:

```sh
docker pull rabbitmq
```

### 2. RabbitMQ Konteyneri Oluşturma ve Çalıştırma:
Şimdi RabbitMQ konteynerini ayağa kaldıralım. Aşağıdaki komut ile RabbitMQ konteynerini oluşturabilir ve çalıştırabilirsiniz:

```sh
docker run -d --name my-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:latest
```

3. **Proje Başlatma:**
    - Projenizi başlatmak için aşağıdaki komutu kullanabilirsiniz:

    ```sh
    ./mvnw spring-boot:run
    ```

    veya

    ```sh
    mvn spring-boot:run
    ```

    Not: Proje başladığında, RabbitMQ ile başarılı bir şekilde iletişim kurabilmek için RabbitMQ yapılandırma bilgilerinin doğru olduğundan emin olun.

4. **Kullanım:**
    - Proje başladıktan sonra, localhost:8080 adresine giderek uygulamayı kullanabilirsiniz.
