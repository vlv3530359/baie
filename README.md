Run with the order:
0. If you didn't use real h2, you need to run the initial.sql to initialize db tables.
1. ConfigServerApplication 8888
2. EurekaApplication 8881
3. GatewayApplication 8880
4. ProductApplication 8084//if you use h2, first startup productapplication before userapplication, becasue share a memory db from productapplication to other services
5. UserApplication 8085
6. MessageApplication 8081
7. SearchApplication 8082//test by http://localhost:8084/product/save post 