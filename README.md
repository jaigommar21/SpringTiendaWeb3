
## Spring Security

Create roles : INSERT INTO `roles` VALUES (1,'Administrador'),(2,'Ventas'),(3,'Almacen');

Create users : INSERT INTO `usuarios` VALUES (1,1,'ebenites@tecsup.edu.pe','tecsup','Erick','Benites','M','1990-05-08','954658512','Av. Peru 123','1',NULL,NULL,NULL,NULL,NULL),(2,2,'jaraujo@tecsup.edu.pe','tecsup','Janeth','Araujo','F',NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL),(3,3,'jflores@tecsup.edu.pe','tecsup','Jorge','Flores','M',NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL),(4,2,'jfarfan@tecsup.edu.pe','tecsup','Jaime','Farfan','M','2019-10-09','3258545','Av. Cascanueces 2221 Santa Anita','1',NULL,NULL,NULL,NULL,NULL),(5,1,'erick.benites@gmail.com','metallica','Erick','Benites','M','2019-12-02','3258545','Av. Cascanueces 2221 Santa Anita','1',NULL,NULL,NULL,NULL,NULL),(6,2,'lmaza@tecsup.edu.pe','tecsup','Luis','Maza','M','2019-12-10','3258545','Av. Cascanueces 2221 Santa Anita','1',NULL,NULL,NULL,NULL,NULL);



Get user with password > SELECT u.email, u.password, r.nombre as role FROM usuarios u, roles r WHERE u.roles_id = r.id ORDER BY u.email;