-- -----------------------------------------------------
-- Stored Procedure banca.findAllDomicilio
-- -----------------------------------------------------
CREATE OR REPLACE DEFINER=`root`@`localhost` PROCEDURE `findAllDomicilio`()
BEGIN
	SELECT FINUMERO, FCCALLE, FCCOLONIA, FCESTADO, FICODIGOPOSTAL
	FROM banca.TADOMICILIO D
	WHERE D.FIESTADODOMICILIO = 1
	ORDER BY FINUMERO;
END
-- -----------------------------------------------------
-- Stored Procedure banca.addDomicilio
-- -----------------------------------------------------
CREATE OR REPLACE DEFINER=`root`@`localhost` PROCEDURE `addDomicilio`(calle varchar(150), colonia varchar(100), estado varchar(50), cp int)
BEGIN
	INSERT INTO banca.TADOMICILIO 
		(FCCALLE, FCCOLONIA, FCESTADO, FICODIGOPOSTAL, FIESTADODOMICILIO) 
	VALUES 
		(calle, colonia, estado, cp, 1);
    COMMIT;
    SELECT LAST_INSERT_ID();
END
-- -----------------------------------------------------
-- Stored Procedure banca.updateDomicilio
-- -----------------------------------------------------
CREATE OR REPLACE DEFINER=`root`@`localhost` PROCEDURE `updateDomicilio`(NUMERO INT, CALLE varchar(150), COLONIA varchar(100), ESTADO varchar(50), CP int)
BEGIN
	DECLARE RES INT;
	UPDATE TADOMICILIO 
		SET  
			FCCALLE = CALLE, 
			FCCOLONIA = COLONIA, 
            FCESTADO = ESTADO, 
            FICODIGOPOSTAL = CP
		WHERE
            FINUMERO = NUMERO;
    COMMIT;
    CALL findDomicilio(NUMERO);
END
-- -----------------------------------------------------
-- Stored Procedure banca.findDomicilio
-- -----------------------------------------------------
CREATE OR REPLACE DEFINER=`root`@`localhost` PROCEDURE `findDomicilio`(NUMBER INT)
BEGIN
	SELECT
       FINUMERO,
       FCCALLE,
       FCCOLONIA,
       FCESTADO,
       FICODIGOPOSTAL,
       FIESTADODOMICILIO
	FROM banca.TADOMICILIO D
	WHERE D.FIESTADODOMICILIO = 1
	AND D.FINUMERO = NUMBER;
END
-- -----------------------------------------------------
-- Stored Procedure banca.findDomicilio
-- -----------------------------------------------------
CREATE OR REPLACE DEFINER=`root`@`localhost` PROCEDURE `deleteDomicilio`(NUMERO INT)
BEGIN
	DELETE FROM TADOMICILIO WHERE FINUMERO = NUMERO;
END
