# 使用下面命令创建github.com代理服务网站的ssl的密钥和公钥
openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout github.com.key -out github.com.crt -config req.cnf -sha256

openssl pkcs12 -export -in github.com.crt -inkey github.com.key -out github.com.pkcs12

keytool -importkeystore -srckeystore github.com.pkcs12 -destkeystore github.com.jks -srcstoretype pkcs12