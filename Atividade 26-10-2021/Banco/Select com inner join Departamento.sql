/****** Script for SelectTopNRows command from SSMS  ******/
	SELECT DF.[DepartamentoPorFuncionarioID]
      ,DF.[FuncionarioID]
      ,DF.[DepartamentoID]
      ,DF.[DataInicio]
      ,DF.[DataFim]
	FROM Departamento as D
	INNER JOIN DepartamentoPorFuncionario as DF ON D.DepartamentoID = DF.DepartamentoID
