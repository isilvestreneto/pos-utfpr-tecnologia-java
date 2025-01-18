SELECT cantor.nome_cantor, gravacoes.num_gravacoes
FROM cantor, (
SELECT gravacao.cod_cantor AS codCantor, COUNT(cod_cantor) AS num_gravacoes
FROM gravacao
GROUP BY gravacao.cod_cantor) AS gravacoes
WHERE cantor.cod_cantor = gravacoes.codCantor
GROUP BY cantor.cod_cantor
HAVING gravacoes.num_gravacoes = (
SELECT MIN(r.num_gravacoes) AS min_gravacoes
FROM
 (
SELECT cod_cantor, COUNT(cod_cantor) AS num_gravacoes
FROM gravacao
GROUP BY gravacao.cod_cantor) AS r);