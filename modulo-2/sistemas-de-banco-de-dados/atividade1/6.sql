SELECT 
    cantor.nome_cantor AS nome_cantor,
    COALESCE(MAX(gravacao.data_gravacao), '') AS ultima_gravacao
FROM 
    cantor
LEFT JOIN 
    gravacao ON cantor.cod_cantor = gravacao.cod_cantor
GROUP BY 
    cantor.nome_cantor
ORDER BY 
    ultima_gravacao DESC;
