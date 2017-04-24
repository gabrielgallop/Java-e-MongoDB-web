<%@page import="Controller.exameController"%>
<%@page import="Controller.areaController"%>
<%@page import="DAO.exameDAO"%>
<%@page import="Controller.alunoController"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.DBCursor"%>
<%@page import="DAO.turmaDAO"%>
<%
    String id = request.getParameter("ok");

    exameDAO exameD = new exameDAO();
    DBCursor cursor = exameD.findID(id);

    String nome = "";
    String descricao = "";
    String professor = "";

    if (cursor.hasNext()) {
        BasicDBObject pessoa = (BasicDBObject) cursor.next();
        nome = pessoa.getString("id_exame");
        descricao = pessoa.getString("descricao");
        professor = pessoa.getString("professor");
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
                    <h2>Dados do Exame</h2>
                    <hr>
                    <div class="row">
                        <input type="hidden" readonly="readonly" class="form-control" value="insertEmbedded" name="metodo">
                        <input type="hidden" readonly="readonly" class="form-control" value="<% out.print(id); %>" id="id" name="id">
                        <div class="col-md-4 form-group">
                            Sigla
                            <input type="text" readonly="readonly" class="form-control"value="<% out.print(nome); %>">
                        </div>
                        <div class="col-md-4 form-group">
                            Curso
                            <input type="text" readonly="readonly" class="form-control" value="<% out.print(descricao); %>">
                        </div>
                        <div class="col-md-4 form-group">
                            Ano
                            <input type="text" readonly="readonly" class="form-control" value="<% out.print(professor);%>">
                        </div>
                    </div>

                    <hr>
                    <h3>Questão</h3>
                    <hr>
                    <button type="button" class="btn btn-info" data-toggle="modal" data-target=".bs-example-modal-lg">Adicionar Questão</button>
                    <hr>

                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <hr>
                        <%
                            exameController exameC = new exameController();
                            out.print(exameC.tabelaQuestao(id));

                        %> 
                        <hr>
                    </div>
                    <div class="col-md-2"></div>


                    <div class="row">

                    </div>
                    <hr>
                    <button type="submit" class="btn btn-info" id="btn_matricula">Matricular</button>
                </form>
            </div>
            <div class="col-md-3"></div>
        </div>


        <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content container-fluid">
                    <div class="row">
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                            <form action="../exameController" method="POST">
                                <hr>
                                <input type="hidden" readonly="readonly" value="insertEmbedded" name="metodo">
                                <input type="hidden" readonly="readonly" class="form-control" value="<% out.print(id); %>" id="id" name="id">
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        Pergunta
                                        <textarea name="descricao" class="form-control"></textarea>                            
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4 form-group">
                                        Área
                                        <select class="form-control" name="area" id="area">
                                            <%
                                                areaController areaC = new areaController();
                                                out.print(areaC.select());
                                            %>
                                        </select>
                                    </div>
                                    <div class="col-md-4 form-group">
                                        Dificuldade
                                        <input type="text" class="form-control" value="" id="dificuldade" name="dificuldade" placeholder="0 a 10">
                                    </div>
                                    <div class="col-md-4 form-group">
                                        Alternativa Correta
                                        <select class="form-control" name="correta" id="correta">
                                            <option value="A">A</option>
                                            <option value="B">B</option>
                                            <option value="C">C</option>
                                            <option value="D">D</option>
                                            <option value="E">E</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        Resposta A
                                        <input type="text" class="form-control" value="" id="respostaA" name="respostaA">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        Resposta B
                                        <input type="text" class="form-control" value="" id="respostaB" name="respostaB">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        Resposta C
                                        <input type="text" class="form-control" value="" id="respostaC" name="respostaC">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        Resposta D
                                        <input type="text" class="form-control" value="" id="respostaD" name="respostaD">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        Resposta E
                                        <input type="text" class="form-control" value="" id="respostaE" name="respostaE">
                                    </div>
                                </div>    
                                <hr>
                                <button class="btn btn-info" type="submit"> Salvar</button>
                            </form>
                        </div>
                        <div class="col-md-2"></div>
                    </div>


                </div>
            </div>
        </div>

              

        <script src="../js/ajaxPaginas.js"></script>
        
        
    </body>
</html>

