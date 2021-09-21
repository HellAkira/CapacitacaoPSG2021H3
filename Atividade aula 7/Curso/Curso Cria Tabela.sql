CREATE TABLE Curso (
	CursoID  INT NOT NULL IDENTITY(1,1),
	Descricao VARCHAR(MAX) NOT NULL,
	DataInsert DATETIME NULL DEFAULT GETDATE(),
	CONSTRAINT PK_Curso PRIMARY KEY (CursoID)
)
GO
