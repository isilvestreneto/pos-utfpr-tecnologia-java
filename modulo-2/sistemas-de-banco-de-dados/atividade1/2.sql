SELECT 
    nome_cantor,
    num_gravadoras
FROM (
    SELECT 
        cantor.nome_cantor AS nome_cantor,
        COUNT(DISTINCT gravadora.nome_gravadora) AS num_gravadoras
    FROM 
        gravacao
    JOIN 
        cantor ON gravacao.cod_cantor = cantor.cod_cantor
    JOIN 
        gravadora ON gravacao.cod_gravadora = gravadora.cod_gravadora
    GROUP BY 
        cantor.nome_cantor
) AS resultados
WHERE 
    num_gravadoras = (
        SELECT MAX(num_gravadoras)
        FROM (
            SELECT 
                COUNT(DISTINCT gravadora.nome_gravadora) AS num_gravadoras
            FROM 
                gravacao
            JOIN 
                cantor ON gravacao.cod_cantor = cantor.cod_cantor
            JOIN 
                gravadora ON gravacao.cod_gravadora = gravadora.cod_gravadora
            GROUP BY 
                cantor.nome_cantor
        ) AS subquery
    );
