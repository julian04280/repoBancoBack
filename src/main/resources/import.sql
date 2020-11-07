INSERT INTO roles (rol_identificacion, rol_nombre) values ( 1, 'admin');
INSERT INTO roles (rol_identificacion, rol_nombre) values ( 2, 'invitado');
INSERT INTO roles (rol_identificacion, rol_nombre) values ( 3, 'otro');
INSERT INTO bancos (banco_identificacion, banco_llave, banco_logo, banco_nombre) values (1, 'EDF453', 'logo_bancoduck', 'BancoDuck');
INSERT INTO clientes (cliente_identificacion, cliente_fecha_registro, cliente_apellido, cliente_clave,  cliente_fecha_nacimiento, cliente_nombre, cliente_numerocelular, cliente_sexo, banco_identificacion) values ('105467218','2020-02-12', 'Gomez', '4321', '1996-10-30', 'Isabella', 3744567, 2, 1);
INSERT INTO clientes (cliente_identificacion, cliente_fecha_registro, cliente_apellido, cliente_clave,  cliente_fecha_nacimiento, cliente_nombre, cliente_numerocelular, cliente_sexo, banco_identificacion) values ('10456565', '2020-02-12', 'Castro', 'cas123', '1986-02-12', 'Maria', 3212121, 2, 1);
INSERT INTO `cliente_roles` (`cliente_identificacion`, `rol_identificacion`) VALUES ('105467218', '1');
INSERT INTO `cliente_roles` (`cliente_identificacion`, `rol_identificacion`) VALUES ('10456565', '2');
INSERT INTO `cuentas` (`cuenta_cod`, `cuenta_descripcion`, `cuenta_tipo`, `banco_identificacion`, `cliente_identificacion`) VALUES ('0001-22', 'Cuenta de ahorros', 'ahorros'   , '1', '10456565');
INSERT INTO `cuentas` (`cuenta_cod`, `cuenta_descripcion`, `cuenta_tipo`, `banco_identificacion`, `cliente_identificacion`) VALUES ('0002-23', 'Cuenta corriente' , 'corriente' , '1', '10456565');
INSERT INTO `cuentas` (`cuenta_cod`, `cuenta_descripcion`, `cuenta_tipo`, `banco_identificacion`, `cliente_identificacion`) VALUES ('0002-24', 'Cuenta de ahorros', 'ahorros'   , '1', '105467218');
INSERT INTO `cuentas` (`cuenta_cod`, `cuenta_descripcion`, `cuenta_tipo`, `banco_identificacion`, `cliente_identificacion`) VALUES ('0002-25', 'Cuenta  corriente', 'corriente' , '1', '105467218');
INSERT INTO `tipotransaccion` (`id_tipotransaccion`, `tipotransaccion_descripcion`) VALUES (1, 'Debito');
INSERT INTO `transacciones` (`transaccion_identificacion`, `cuenta_recaudador`, `transaccion_descripcion`, `transaccion_estado`, `transaccion_fecha`, `transaccion_monto`, `urlRetorno`, `id_cuenta`, `id_tipotransaccion`) VALUES (1212, '1313113', 'Pago servicio publico', 'Creada', '2020-10-30', 53.500, '18.229.169.221:7777/angular/', '0001-22', 1);
INSERT INTO `transacciones` (`transaccion_identificacion`, `cuenta_recaudador`, `transaccion_descripcion`, `transaccion_estado`, `transaccion_fecha`, `transaccion_monto`, `urlRetorno`, `id_cuenta`, `id_tipotransaccion`) VALUES (1213, '1313113', 'Pago servicio agua', 'Creada', '2020-10-30', 23000, '18.229.169.221:7777/angular/', '0002-23', 1);
INSERT INTO `transacciones` (`transaccion_identificacion`, `cuenta_recaudador`, `transaccion_descripcion`, `transaccion_estado`, `transaccion_fecha`, `transaccion_monto`, `urlRetorno`, `id_cuenta`, `id_tipotransaccion`) VALUES (1214, '1313113', 'Pago servicio gas', 'Creada', '2020-10-30', 13.700, '18.229.169.221:7777/angular/', '0002-24', 1);



