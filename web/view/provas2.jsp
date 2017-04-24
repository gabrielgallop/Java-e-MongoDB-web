<%@page import="Controller.folhaRespostaController"%>
<%@page import="Controller.exameController"%>
<%@page import="Controller.matriculaController"%>
<%@page import="Controller.turmaController"%>
<%@page import="Controller.areaController"%>

<%
    
    String id = request.getParameter("ok");

    folhaRespostaController folhaC = new folhaRespostaController();

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

                <hr>
                <h3>Selecione um Exame.</h3>
                <hr>
                <button type="button" class="btn btn-info" data-toggle="modal" data-target=".bs-example-modal-lg">Exame</button>
                <hr>
                <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="row">
                                <div class="col-md-2"></div>
                                <div class="col-md-8">
                                    <hr>
                                    <%                        turmaController turmaC = new turmaController();

                                        out.println(folhaC.listaExames(id));
                                    %> 
                                    <hr>
                                </div>
                                <div class="col-md-2"></div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
            <div class="col-md-3"></div>
        </div>


        <script src="../js/ajaxPaginas.js"></script>
    </body>
</html>