<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.alura.gerenciador.servlet.Produto" %>
<%@ page import="br.com.alura.gerenciador.servlet.Banco" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Lista de Produtos</title>
</head>
<body>
    <h1>Produtos Cadastrados</h1>
    
    <%
        Banco banco = new Banco();
        List<Produto> produtos = banco.getProdutos();
    %>
    
    <table border="1">
        <tr>
            <th>ID</th><th>Nome</th><th>Unidade Compra</th><th>Descrição</th><th>Qtd Previsto</th><th>Preço Máx</th><th>Ações</th>
        </tr>
        <%
            for(Produto p : produtos){
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNome() %></td>
            <td><%= p.getUnidadeCompra() %></td>
            <td><%= p.getDescricao() %></td>
            <td><%= p.getQtdPrevistoMes() %></td>
            <td><%= p.getPrecoMaxComprado() %></td>
            <td>
                <a href="editar?id=<%= p.getId() %>">Editar</a>
                <a href="excluir?id=<%= p.getId() %>">Excluir</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    
    <br/>
    <a href="cadastrarProd.jsp">Cadastrar Novo Produto</a> | <a href="index.html">Voltar ao Menu</a>
</body>
</html>
