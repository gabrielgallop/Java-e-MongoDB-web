<%@page import="Controller.areaController"%>
<form action="areaController" method="POST">
    <div class="row">
        <div class="col-md-4">
            <div class="form-group">
                <label for="sigla">Sigla</label>
                <input type="text" name="sigla" class="form-control" id="sigla" placeholder="Sigla">
                <input type="hidden" value="1" name="metodo">
            </div>
        </div>
        <div class="col-md-4">
            <div class="form-group">
                <label for="descricao">Descrição</label>
                <input type="text" name="descricao" class="form-control" id="turno" placeholder="Descrição">
            </div>
        </div>            
        <div class="col-md-4">
            <div class="form-group">
                <label for="areaPai">Área Pai</label>
                <select class="form-control" name="areaPai" id="uf">
                    <%
                        areaController areaC = new areaController();
                        out.print(areaC.select());
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
                        areaC.tabela();
                        out.println( areaC.tabela());
                    %> 
                    <hr>
                </div>
                <div class="col-md-2"></div>
            </div>

        </div>
    </div>
</div>