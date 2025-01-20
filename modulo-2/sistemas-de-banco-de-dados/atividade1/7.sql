SELECT 
    pessoa.nome_pessoa AS nome_pessoa,
    GROUP_CONCAT(CASE WHEN fone.tipo = 'R' THEN fone.numero END) AS residencial,
    GROUP_CONCAT(CASE WHEN fone.tipo = 'C' THEN fone.numero END) AS comercial,
    GROUP_CONCAT(CASE WHEN fone.tipo = 'L' THEN fone.numero END) AS celular
FROM 
    pessoa
LEFT JOIN 
    fone ON pessoa.cod_pessoa = fone.cod_pessoa
GROUP BY 
    pessoa.nome_pessoa
HAVING 
    residencial IS NOT NULL OR comercial IS NOT NULL OR celular IS NOT NULL
ORDER BY 
    pessoa.nome_pessoa;
