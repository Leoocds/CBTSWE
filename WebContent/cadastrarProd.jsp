<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Cadastrar Produto</title>
</head>
<body>
    <h1>Cadastrar Produto</h1>
    <form action="create" method="post">
        Nome: <input type="text" name="nome" required/><br/>
        Unidade Compra: <input type="number" name="unidadeCompra" required/><br/>
        Descrição: <input type="text" name="descricao" required/><br/>
        Quantidade Prevista/Mês: <input type="number" step="0.01" name="qtdPrevistoMes" required/><br/>
        Preço Máximo Comprado: <input type="number" step="0.01" name="precoMaxComprado" required/><br/>
        <input type="submit" value="Cadastrar"/>
    </form>
    <br/>
    <a href="index.html">Voltar ao Menu</a>
</body>
</html>
