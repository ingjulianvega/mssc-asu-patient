DROP DATABASE IF EXISTS patientservice;
DROP USER IF EXISTS `patient_service`@`%`;
CREATE DATABASE IF NOT EXISTS patientservice CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `patient_service`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `patientservice`.* TO `patient_service`@`%`;
FLUSH PRIVILEGES;

