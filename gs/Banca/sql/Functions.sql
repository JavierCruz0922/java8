CREATE FUNCTION `test` ()
RETURNS INTEGER
BEGIN
	select * from banca.cliente;
RETURN 1;
END
