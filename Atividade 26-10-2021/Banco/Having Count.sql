
SELECT *
FROM DepartamentoPorFuncionario
WHERE FuncionarioID IN
    (     SELECT FuncionarioID
          FROM DepartamentoPorFuncionario
          GROUP BY FuncionarioID
          HAVING COUNT(*) > 1
    )
ORDER BY FuncionarioID