SELECT 
    nome_cantor,
    media_duracao
FROM (
    SELECT 
        cantor.nome_cantor AS nome_cantor,
        SUM(musica.duracao) / COUNT(musica.cod_musica) AS media_duracao
    FROM 
        gravacao
    JOIN 
        cantor ON gravacao.cod_cantor = cantor.cod_cantor
    JOIN 
        musica ON gravacao.cod_musica = musica.cod_musica
    GROUP BY 
        cantor.nome_cantor
) AS medias
WHERE 
    media_duracao = (
        SELECT MAX(media_duracao) 
        FROM (
            SELECT 
                SUM(musica.duracao) / COUNT(musica.cod_musica) AS media_duracao
            FROM 
                gravacao
            JOIN 
                cantor ON gravacao.cod_cantor = cantor.cod_cantor
            JOIN 
                musica ON gravacao.cod_musica = musica.cod_musica
            GROUP BY 
                cantor.nome_cantor
        ) AS subquery
    );