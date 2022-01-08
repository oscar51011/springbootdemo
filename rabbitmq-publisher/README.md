# Goal

建立發布者的服務 , 提供 restful 將訊息推向 rabbitmq

- 需要安裝對應的 rabbitmq 服務 ( 可在本地 VM 安裝 docker 服務 )

```
# docker pull image

docker pull rabbitmq:management

# docker run rabbitmq service ( 15672 : console port , 5672 : service port )

docker run -d -p 5672:5672 -p 15672:15672 --name rabbitmq rabbitmq:management

```

- application.yml 調整對應的服務位置 ( docker 啟動之服務預設port: 5672 )

本地啟動swagger路徑: [http://localhost:8080/swagger-ui.html#/](http://localhost:8080/swagger-ui.html#/)
