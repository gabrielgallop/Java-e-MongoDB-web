<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.DBCursor"%>
<%@page import="DAO.exameDAO"%>
<%@page import="Controller.folhaRespostaController"%>
<%@page import="Controller.exameController"%>
<%@page import="Controller.matriculaController"%>
<%@page import="Controller.turmaController"%>
<%@page import="Controller.areaController"%>

<%

    String id = request.getParameter("ok");

    folhaRespostaController folhaC = new folhaRespostaController();

    exameDAO exameD = new exameDAO();
    DBCursor cursor = exameD.findID(id);

    BasicDBObject exame = (BasicDBObject) cursor.next();

    String nome = exame.getString("id_exame");
    String descricao = exame.getString("descricao");
    String professor = exame.getString("professor");
    String status = exame.getString("status");
    
    


%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../www/css/bootstrap.min.css" rel="stylesheet">

        <script src="../js/jquery-3.1.1.min.js"></script>
        <script src="../www/js/bootstrap.min.js"></script>

    </head>
    <body>

            
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="row">
                    <hr>
                    <div class="col-md-4 form-group">
                        Exame
                        <input type="text" readonly="readonly" class="form-control"value="<% out.print(nome); %>">
                    </div>
                    <div class="col-md-4 form-group">
                        Descrição
                        <input type="text" readonly="readonly" class="form-control" value="<% out.print(descricao); %>">
                    </div>
                    <div class="col-md-4 form-group">
                        Professor
                        <input type="text" readonly="readonly" class="form-control" value="<% out.print(professor);%>">
                    </div>
                </div>
                <hr>
                <%
                    if(status.equals("'1'"))
                        out.println(folhaC.tabelaQuestao(id));
                %>
                <%
                     if(status.equals("'2'"))
                        out.println(folhaC.tabelaQuestao2(id));
                %>
            </div>
            <div class="col-md-3"></div>
        </div>


        <script src="../js/ajaxPaginas.js"></script>
    </body>
</html>