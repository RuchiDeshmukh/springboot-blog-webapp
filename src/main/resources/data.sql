
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_GUEST'); 
 
INSERT INTO `users`(EMAIL,NAME,PASSWORD) VALUES ('admin@gmail.com','admin','$2a$10$sMNKl6WVVxo8poJ8x8fB5ehV8oURq1BcZ0l4iKOUuf6D376hTYGCS'); 
INSERT INTO `users`(EMAIL,NAME,PASSWORD) VALUES ('rd@gmail.com','rd','$2a$10$sMNKl6WVVxo8poJ8x8fB5ehV8oURq1BcZ0l4iKOUuf6D376hTYGCS'); 
INSERT INTO `users`(EMAIL,NAME,PASSWORD) VALUES ('sam@gmail.com','sam','$2a$10$sMNKl6WVVxo8poJ8x8fB5ehV8oURq1BcZ0l4iKOUuf6D376hTYGCS'); 


 
INSERT INTO `users_roles`(USER_ID,ROLE_ID) VALUES (1,1);
INSERT INTO `users_roles`(USER_ID,ROLE_ID) VALUES (2,2);
INSERT INTO `users_roles`(USER_ID,ROLE_ID) VALUES (3,2);

INSERT INTO `posts` (CONTENT,CREATED_ON, SHORT_DESCRIPTION,TITLE,UPDATED_ON,URL,created_by) VALUES 
(' Content goes here','2022-07-18 10:45:18.617432','In this blog post, you will important OOPS concepts in Java with examples','OOPS Concepts in Java','2022-07-18 10:45:18.617561','oops-concepts-in-java',2),
(' Content goes here','2022-07-18 10:45:18.630278','In this blog post, you will learn about Variables in Java with examples','Variables in Java','2022-07-18 10:45:18.630297','variables-in-java',3);
--(3,' Content goes here','2022-07-18 10:45:18.632620','In this blog post, you will learn about Primitive Data Types in Java with examples','Primitive Data Types in Java','2022-07-18 10:45:18.632632','primitive-data-types-in-java'),
--(4,' Content goes here','2022-07-18 10:45:18.634347','In this blog post, you will learn about Access Modifiers in Java with examples','Access Modifiers in Java','2022-07-18 10:45:18.634357','access-modifiers-in-java'),
--(5,' Content goes here','2022-07-18 10:45:18.635878','In this blog post, you will learn about Arrays in Java with examples','Arrays in Java','2022-07-18 10:45:18.635889','arrys-in-java');
