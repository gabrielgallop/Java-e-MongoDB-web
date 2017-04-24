<%@page import="Controller.exameController"%>
<%@page import="Controller.matriculaController"%>
<%@page import="Controller.turmaController"%>
<%@page import="Controller.areaController"%>


<hr>
<h3>Selecione a Turma onde o Aluno será matriculado.</h3>
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
                    <%
                        turmaController turmaC = new turmaController();

                        out.println(turmaC.tabelaS());
                    %> 
                    <hr>
                </div>
                <div class="col-md-2"></div>
            </div>

        </div>
    </div>
</div>

