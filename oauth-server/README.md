https://www.jframe.cn/a/9e63426916354efd915bdc8f7db84190
https://docs.spring.io/spring-security-oauth2-boot/docs/current/reference/htmlsingle/
https://projects.spring.io/spring-security-oauth/docs/oauth2.html


1. curl -s acme:acmesecret@localhost:8882/oauth/token  -d grant_type=password -d client_id=acme -d scope=webshop -d username=admin -d password=123456
you will get the token
2. curl 'http://localhost:8882/bar'  -H  "Authorization: Bearer ${TOKEN}"