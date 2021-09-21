CREATE TABLE InstituicaoBancaria (
	InstituicaoBancariaID  INT NOT NULL IDENTITY(1,1),
	CodigoBanco INT NULL,
	Descricao VARCHAR(MAX) NOT NULL,
	SiteWWW VARCHAR(MAX) NULL,
	DataInsert DATETIME NULL DEFAULT GETDATE(),
	CONSTRAINT PK_InstituicaoBancaria PRIMARY KEY (InstituicaoBancariaID)
)
GO

