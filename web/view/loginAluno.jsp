<%-- 
    Document   : loginAluno
    Created on : 23/11/2016, 00:28:10
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="../folhaRespostaController" method="POST">
            <input type="hidden" value="login" name="metodo">
            login
            <input type="text" name="login">
            senha
            <input type="password" name="senha"><br>
            <button type="submit">Entrar</button>
        </form>
    </body>
</html>
