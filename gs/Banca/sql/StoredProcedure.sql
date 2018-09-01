CREATE PROCEDURE `addDomicilio` (calle varchar(150), colonia varchar(100), estado varchar(50), cp int)
BEGIN
	DECLARE res int;
	INSERT INTO banca.TADOMICILIO 
		(FCCALLE, FCCOLONIA, FCESTADO, FICODIGOPOSTAL, FIESTADODOMICILIO) 
	VALUES 
		(calle, colonia, estado, cp, 1);
	SET res =  1; 
END
