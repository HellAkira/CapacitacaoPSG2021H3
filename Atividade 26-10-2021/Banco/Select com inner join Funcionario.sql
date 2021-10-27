/****** Script for SelectTopNRows command from SSMS  ******/
	SELECT DF.[DepartamentoPorFuncionarioID]
      ,DF.[FuncionarioID]
      ,DF.[DepartamentoID]
      ,DF.[DataInicio]
      ,DF.[DataFim]
	FROM Funcionario as F
	INNER JOIN DepartamentoPorFuncionario as DF ON F.FuncionarioID = DF.FuncionarioID
