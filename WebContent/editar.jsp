<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.com.alura.gerenciador.servlet.Produto" %>
<%
    Produto produto = (Produto) request.getAttribute("produto");
    if (produto == null) {
%>
    <h2>Produto não encontrado.</h2>
    <a href="listarProd.jsp">Voltar à Lista</a>
<%
    return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Editar Produto</title>
</head>
<body>
    <h1>Editar Produto</h1>
    <form action="update" method="post">
        <input type="hidden" name="id" value="<%= produto.getId() %>"/>
        Nome: <input type="text" name="nome" value="<%= produto.getNome() %>" required/><br/>
        Unidade Compra: <input type="number" name="unidadeCompra" value="<%= produto.getUnidadeCompra() %>" required/><br/>
        Descrição: <input type="text" name="descricao" value="<%= produto.getDescricao() %>" required/><br/>
        Quantidade Prevista/Mês: <input type="number" step="0.01" name="qtdPrevistoMes" value="<%= produto.getQtdPrevistoMes() %>" required/><br/>
        Preço Máximo Comprado: <input type="number" step="0.01" name="precoMaxComprado" value="<%= produto.getPrecoMaxComprado() %>" required/><br/>
        <input type="submit" value="Atualizar"/>
    </form>
    <br/>
    <a href="listarProd.jsp">Voltar à Lista</a>
</body>
</html>
