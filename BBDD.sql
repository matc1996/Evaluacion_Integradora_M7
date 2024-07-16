create schema alkewallet_m7;
use alkewallet_m7;

CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    contrasena VARCHAR(255),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Cuenta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    saldo DECIMAL(10, 2) DEFAULT 0,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

CREATE TABLE Transaccion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cuenta_origen_id INT,
    cuenta_destino_id INT,
    monto DECIMAL(10, 2),
    fecha_transaccion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo ENUM('DEPOSITO', 'RETIRO', 'TRANSFERENCIA'),
    FOREIGN KEY (cuenta_origen_id) REFERENCES Cuenta(id),
    FOREIGN KEY (cuenta_destino_id) REFERENCES Cuenta(id)
);
