<%@page import="Controller.professorController"%>
<form action="professorController" method="POST">
    <div class="form-group">
        <label for="cpf">CPF</label>
        <input type="text" name="cpf" class="form-control" id="cpf" placeholder="C.P.F.">
        <input type="hidden" value="1" name="metodo">
    </div>


    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="nome">Nome</label>
                <input type="text" name="nome" class="form-control" id="nome" placeholder="Primeiro Nome">
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="sobrenome">Sobrenome</label>
                <input type="text" name="sobrenome" class="form-control" id="sobrenome" placeholder="Sobrenome">
            </div>
        </div>                                    
    </div>    
    <div class="row">
        <div class="col-md-4">
            <div class="form-group">
                <label for="nascimento">Data Nascimento</label>
                <input type="date" name="nascimento" class="form-control" id="nascimento">
            </div>
        </div>
        <div class="col-md-8">
            <div class="form-group">
                <label for="email">E-mail</label>
                <input type="text" name="email" class="form-control" id="email" placeholder="Email">
            </div>
        </div>                                    
    </div>

    <div class="row">
        <div class="col-md-5">
            <div class="form-group">
                <label for="pais">Pais</label>
                <input type="text" name="pais" class="form-control" id="pais">
            </div>
        </div>
        <div class="col-md-5">
            <div class="form-group">
                <label for="cidade">Cidade</label>
                <input type="text" name="cidade" class="form-control" id="cidade" placeholder="Cidade">
            </div>
        </div>
        <div class="col-md-2">
            <div class="form-group">
                <label for="uf">U.F.</label>
                <select class="form-control" name="uf" id="uf">
                    <option value="1">Selecione U.F.</option>
                </select>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="rg">RG</label>
                <input type="text" name="rg" class="form-control" id="rg">
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-group">
                <label for="emissor">Emissor</label>
                <input type="text" name="emissor" class="form-control" id="emissor">
            </div>
        </div>    
        <div class="col-md-3">
            <div class="form-group">
                <label for="estado">Est.</label>
                <select class="form-control" name="estado" id="estado">
                    <option value="1">Selecione U.F.</option>
                </select>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="matricula">Matricula</label>
                <input type="text" name="matricula" class="form-control" id="matricula">
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-group">
                <label for="telefone">Telefone</label>
                <input type="text" name="telefone" class="form-control" id="telefone">
            </div>
        </div>    
        <div class="col-md-3">
            <div class="form-group">
                <label for="senha">Senha</label>
                <input type="password" name="senha" class="form-control" id="senha">
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label for="titulo">Titulo</label>
                <input type="text" name="titulo" class="form-control" id="titulo">
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-group">
                <label for="cargo">Cargo</label>
                <input type="text" name="cargo" class="form-control" id="cargo">
            </div>
        </div>    
        <div class="col-md-3">
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
                        professorController professorC = new professorController();
                        
                        out.println(professorC.tabela());
                    %> 
                    <hr>
                </div>
                <div class="col-md-2"></div>
            </div>

        </div>
    </div>
</div>