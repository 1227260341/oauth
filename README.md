获取token 
http://localhost:1002/oauth/token?username=user_1&password=123456&grant_type=password&scope=select&client_id=client_2&client_secret=123456

test：
http://localhost:1002/order/demo
post 方式 headers 添加 Authorization:Bearer 62da32d4-4fef-4916-ad0f-a22b7bcc183e(具体的获取到的token 的值)