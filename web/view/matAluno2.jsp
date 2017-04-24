<%@page import="Controller.alunoController"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.DBCursor"%>
<%@page import="DAO.turmaDAO"%>
<%
    String id = request.getParameter("ok");

    turmaDAO turmaD = new turmaDAO();
    DBCursor cursor = turmaD.findID(id);

    String sigla = "";
    String curso = "";
    String ano = "";

    if (cursor.hasNext()) {
        BasicDBObject pessoa = (BasicDBObject) cursor.next();
        sigla = pessoa.getString("sigla");
        curso = pessoa.getString("cursor");
        ano = pessoa.getString("ano");
    }

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
            <div class="col-md-6 form-group">
                <form action="../turmaController" method="POST">
                    <hr>
                    <h2>Dados da Turma</h2>
                    <hr>
                    <div class="row">
                        <input type="hidden" readonly="readonly" class="form-control" value="insertEmbedded" name="metodo">
                        <input type="hidden" readonly="readonly" class="form-control" value="<% out.print(id); %>" id="id" name="id">
                               <div class="col-md-4 form-group">
                            Sigla
                            <input type="text" readonly="readonly" class="form-control"value="<% out.print(sigla); %>">
                        </div>
                        <div class="col-md-4 form-group">
                            Curso
                            <input type="text" readonly="readonly" class="form-control" value="<% out.print(curso); %>">
                        </div>
                        <div class="col-md-4 form-group">
                            Ano
                            <input type="text" readonly="readonly" class="form-control" value="<% out.print(ano);%>">
                        </div>
                    </div>

                    <hr>
                    <h3>Selecione o Aluno que será matriculado.</h3>
                    <hr>
                    <button type="button" class="btn btn-info" data-toggle="modal" data-target=".bs-example-modal-lg">Alunos</button>
                    <hr>

                    <div class="row">
                        <div class="col-md-4 form-group">
                            CPF
                            <input type="text" readonly="readonly" class="form-control"value="" id="cpf" name="cpf">
                        </div>
                        <div class="col-md-4 form-group">
                            Nome Completo
                            <input type="text" readonly="readonly" class="form-control" value="" id="nome" name="nome">
                        </div>
                        <div class="col-md-4 form-group">
                            RA
                            <input type="text" readonly="readonly" class="form-control" value="" id="ra" name="ra">
                        </div>
                    </div>
                    <hr>
                    <button type="submit" class="btn btn-info" id="btn_matricula">Matricular</button>
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>


        <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="row">
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                            <hr>
                            <%
                                alunoController alunoC = new alunoController();

                                out.println(alunoC.tabelaMatricula());
                            %> 
                            <hr>
                        </div>
                        <div class="col-md-2"></div>
                    </div>

                </div>
            </div>
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
    </body>
</html>
