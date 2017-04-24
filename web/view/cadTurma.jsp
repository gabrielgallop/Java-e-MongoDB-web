<%@page import="Controller.turmaController"%>
<%@page import="Controller.professorController"%>
<form action="turmaController" method="POST">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="sigla">Sigla</label>
                <input type="text" name="sigla" class="form-control" id="sigla" placeholder="Sigla">
                <input type="hidden" value="1" name="metodo">
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="turno">Turno</label>
                <input type="text" name="turno" class="form-control" id="turno" placeholder="Turno">
            </div>
        </div>                                    
    </div>    
    <div class="row">
        <div class="col-md-4">
            <div class="form-group">
                <label for="curso">Curso</label>
                <input type="text" name="curso" class="form-control" id="curso">
            </div>
        </div>
        <div class="col-md-4">
            <div class="form-group">
                <label for="ano">Ano</label>
                <input type="text" name="ano" class="form-control" id="ano" placeholder="2016">
            </div>
        </div>                          
        <div class="col-md-4">
            <div class="form-group">
                <label for="semestre">Semestre</label>
                <select class="form-control" name="semestre" id="uf">
                    <option value="1º">1º</option>
                    <option value="2º">2º</option>
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
                        turmaController turmaC = new turmaController();
                        
                        out.println(turmaC.tabela());
                    %> 
                    <hr>
                </div>
                <div class="col-md-2"></div>
            </div>

        </div>
    </div>
</div>