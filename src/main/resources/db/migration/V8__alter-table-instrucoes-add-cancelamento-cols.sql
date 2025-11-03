alter table instrucoes
    add column ativo tinyint default 1,
    add column motivo_cancelamento varchar(100);

update instrucoes set ativo = 1;