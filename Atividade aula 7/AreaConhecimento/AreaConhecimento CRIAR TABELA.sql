CREATE TABLE AreaConhecimento (
	AreaConhecimentoID INT NOT NULL IDENTITY(1,1),
	Descricao VARCHAR(MAX) NOT NULL,
	DataInsert DATETIME NULL DEFAULT GETDATE(),
	CONSTRAINT PK_AreaConhecimento PRIMARY KEY (AreaConhecimentoID)
)
GO
