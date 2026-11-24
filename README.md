### Mail sending program
User specifies:
- To
- Subject
- Message/content

Mail server authentication with username and password.
TLS encryption via port 587.

### Run program:
For Google Mail server use gmail.com as arg[0] = smtp.gmail.com

- String host = args[0];       // smtp.gmail.com
- String port = args[1];       // 587 (TLS)
- String username = args[2];   // from
- String password = args[3];   // Google app password (https://support.google.com/accounts/answer/185833?visit_id=638687467349409867-3639313399)
- String recipient = args[4];  // to
- String subject = args[5];    // subject
- String content = args[6];    // content

### Compile
In project directory:
javac -cp "lib/javax.mail.jar:lib/activation.jar" src/Mail.java

## run with args:
<span style="color:lightgreen">If javax.mail.jar and activation.jar in /lib/:</span><br>
🟢 From root (3.2.1) run:<br>
```java -cp "src:lib/javax.mail.jar:lib/activation.jar" Mail <host> <port> <username> <password> <recipient> <subject> <message>```
<br><br>


mail.java:
```java Mail.java <host> <port> <username> <password> <recipient> <subject> <message>```

.jar:
```java -jar Mail.jar <host> <port> <username> <password> <recipient> <subject> <message>```


### Dependencies
🟢 javax.mail.jar (/lib/javax.mail.jar)<br>
Java mail API - the API to create, send and read email.

🟢 activation.jar (/lib/activationn.jar)
JAF (JavaBeans Activation Framework) contains a library JavaMail
uses to handle MIME data and different data/content types
in messages/mail like text, HTML, images, attachment, …


### misc
SMPT - Simple Mail Transfer Protocol:
Used as link between two different servers for sending email.
Google's SMTP server is used to send emails.