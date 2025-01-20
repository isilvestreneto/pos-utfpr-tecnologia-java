SELECT 
    cantor.nome_cantor AS nome_cantor,
    musica.titulo AS nome_musica,
    gravacao.data_gravacao AS data_gravacao
FROM 
    gravacao
JOIN 
    cantor ON gravacao.cod_cantor = cantor.cod_cantor
JOIN 
    musica ON gravacao.cod_musica = musica.cod_musica
WHERE 
    YEAR(gravacao.data_gravacao) = 2004;
