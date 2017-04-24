<%@page import="Controller.exameController"%>



<hr>
<h3>Selecione um Exame para adicionar as questões.</h3>
<hr>
<button type="button" class="btn btn-info" data-toggle="modal" data-target=".bs-example-modal-lg">Exames</button>
<hr>
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <hr>
                    <%
                        exameController exameC = new exameController();
                        
                        out.println(exameC.tabelaSD());
                    %> 
                    <hr>
                </div>
                <div class="col-md-2"></div>
            </div>

        </div>
    </div>
</div>

