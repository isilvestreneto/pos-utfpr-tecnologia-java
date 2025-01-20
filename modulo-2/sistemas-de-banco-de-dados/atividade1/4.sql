SELECT DISTINCT 
    cantor.nome_cantor AS nome_cantor
FROM 
    gravacao
JOIN 
    cantor ON gravacao.cod_cantor = cantor.cod_cantor
JOIN 
    gravadora ON gravacao.cod_gravadora = gravadora.cod_gravadora
WHERE 
    cantor.cod_cantor NOT IN (
        SELECT DISTINCT gravacao.cod_cantor
        FROM 
            gravacao
        JOIN 
            gravadora ON gravacao.cod_gravadora = gravadora.cod_gravadora
        WHERE 
            gravadora.nome_gravadora = 'Sony'
    );
