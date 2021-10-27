USE [CapacitacaoPSG2021H3]
GO

--Cria Tabela
CREATE TABLE DepartamentoPorFuncionario(
	DepartamentoPorFuncionarioID int IDENTITY(1,1) NOT NULL,
	FuncionarioID INT NOT NULL,
	DepartamentoID INT NOT NULL,
	DataInicio DATETIME NOT NULL,
	DataFim DATETIME NOT NULL,
	CONSTRAINT PK_DepartamentoPorFuncionario PRIMARY KEY (DepartamentoPorFuncionarioID),
	CONSTRAINT FK_DepartamentoPorFuncionario_Funcionario FOREIGN KEY (FuncionarioID) REFERENCES Funcionario(FuncionarioID),
	CONSTRAINT FK_DepartamentoPorFuncionario_Departamento FOREIGN KEY (DepartamentoID) REFERENCES Departamento(DepartamentoID)
) 
GO
--Insere os dados RAW na tabela criada
INSERT INTO [dbo].[DepartamentoPorFuncionario](
       [FuncionarioID] 
      ,[DepartamentoID]
      ,[DataInicio]
      ,[DataFim]
	  )
SELECT RawData.[FuncionarioID]
      ,RawData.[DepartamentoID]
      ,RawData.[DataInicio]
      ,RawData.[DataFim]
  FROM [dbo].[FuncionarioPorDepartamentoRawData] as RawData
  ORDER BY FuncionarioID
  GO
