
## Spring Security

Get user with password > SELECT u.email, u.password, r.nombre as role FROM usuarios u, roles r WHERE u.roles_id = r.id ORDER BY u.email;