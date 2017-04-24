<%@page import="Controller.folhaRespostaController"%>
<%@page import="Controller.exameController"%>
<%@page import="Controller.matriculaController"%>
<%@page import="Controller.turmaController"%>
<%@page import="Controller.areaController"%>

<%
    String cpf = request.getParameter("cpf");

    folhaRespostaController folhaC = new folhaRespostaController();

    String sigla = "";
    String curso = "";
    String ano = "";

    //if (cursor.hasNext()) {
    //  BasicDBObject pessoa = (BasicDBObject) cursor.next();
    //sigla = pessoa.getString("sigla");
    //curso = pessoa.getString("cursor");
    //ano = pessoa.getString("ano");
    // }

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
                <h3>Selecione uma Turma.</h3>
                <hr>
                <button type="button" class="btn btn-info" data-toggle="modal" data-target=".bs-example-modal-lg">Turmas</button>
                <hr>
                <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="row">
                                <div class="col-md-2"></div>
                                <div class="col-md-8">
                                    <hr>
                                    <%                        turmaController turmaC = new turmaController();

                                        out.println(folhaC.listaTurmas(cpf));
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
        <script>
            $(function () {
                $(document).on('click', '.click', function (e) {
                    e.preventDefault;
                    var cpf = $(this).closest('tr').find('th[data-cpf]').data('cpf');
                    var nome = $(this).closest('tr').find('td[data-nome]').data('nome');
                    var ra = $(this).closest('tr').find('td[data-ra]').data('ra');

                    $("#cpf").val("");
                    $("#nome").val("");
                    $("#ra").val("");

                    $("#cpf").val(cpf);
                    $("#nome").val(nome);
                    $("#ra").val(ra);

                });
            });


        </script>
        <input type="radio" name="a">
    </body>
</html>