<%@page import="Controller.exameController"%>
<%@page import="Controller.professorController"%>
<%@page import="Controller.turmaController"%>
<form action="exameController" method="POST">
    <input type="hidden" value="1" name="metodo">
    <div class="row">
        <div class="col-md-5">
            <div class="form-group">
                <label for="nome">Nome do Exame</label>
                <input type="text" name="nome" class="form-control" id="nome" placeholder="Nome Exame">
            </div>
        </div>
        <div class="col-md-5">
            <div class="form-group">
                <label for="descricao">Descrição</label>
                <input type="text" name="descricao" class="form-control" id="descricao" placeholder="Descrição">
            </div>
        </div>
        <div class="col-md-2">
            <div class="form-group">
                <label for="descricao">Descrição</label>
                <select class="form-control" name="tipo" id="tipo">
                    <option value="1">Objetiva</option>
                    <option value="2">Dissertativa</option>
                </select>

            </div>
        </div> 
    </div>    
    <div class="row">
        <div class="col-md-2">
            <div class="form-group">
                <label for="tempo">Tempo Total</label>
                <input type="time" name="tempo" class="form-control" id="tempo">
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-group">
                <label for="data">Data</label>
                <input type="date" name="data" class="form-control" id="data">
            </div>
        </div> 
        <div class="col-md-2">
            <div class="form-group">
                <label for="turma">Turma</label>
                <select class="form-control" name="turma" id="uf">
                    <option value="">Selecione uma Turma</option>
                    <%
                        turmaController turmaC = new turmaController();
                        out.print(turmaC.select());
                    %>
                </select>
            </div>
        </div>
        <div class="col-md-2">
            <div class="form-group">
                <label for="dominio">Dominio</label>
                <input type="text" name="dominio" class="form-control" id="dominio">
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-group">
                <label for="professor">Professor</label>
                <select class="form-control" name="professor" id="professor">
                    <option value="1">Selecione Professor</option>
                    <%
                        professorController professorC = new professorController();
                        out.print(professorC.select());
                    %>
                </select>
            </div>
        </div>
    </div>
    
    <button type="submit" class="btn btn-info" id="btnSalvaAluno"><span class="glyphicon glyphicon-ok"></span> Salvar</button>
    <button type="reset" class="btn btn-danger"><span class="fa fa-times"></span> Cancelar</button>
    <button type="button" class="btn btn-info" data-toggle="modal" data-target=".bs-example-modal-lg">Listar Todos</button>
</form>



<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <hr>
                    <%
                        exameController exameC = new exameController();
                        
                        out.println(exameC.tabela());
                    %> 
                    <hr>
                </div>
                <div class="col-md-2"></div>
            </div>

        </div>
    </div>
</div>