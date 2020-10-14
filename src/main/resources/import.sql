INSERT INTO roles (rol_identificacion, rol_nombre) values ( 1, 'admin');
INSERT INTO roles (rol_identificacion, rol_nombre) values ( 2, 'invitado');
INSERT INTO roles (rol_identificacion, rol_nombre) values ( 3, 'otro');
INSERT INTO bancos (banco_identificacion, banco_llave, banco_logo, banco_nombre) values (1, 'EDF453', 'logo_bancolombia', 'Bancolombia');

INSERT INTO clientes (per_identificacion, fecha_registro, per_apellido, per_clave,  per_fecha_nacimiento, per_nombre, per_numero_celular, per_sexo, banco_identificacion) values ('105467218','2020-02-12', 'Gomez', '4321', '1996-10-30', 'Isabella', 3744567, 2, 1);

INSERT INTO clientes (per_identificacion, fecha_registro, per_apellido, per_clave,  per_fecha_nacimiento, per_nombre, per_numero_celular, per_sexo, banco_identificacion) values ('10456565', '2020-02-12', 'Castro', 'cas123', '1986-02-12', 'Maria', 3212121, 2, 1);

