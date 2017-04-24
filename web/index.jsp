<%-- 
    Document   : index
    Created on : 21/11/2016, 09:29:21
    Author     : gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="www/css/bootstrap.min.css" rel="stylesheet">

        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="www/js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">UFSCar</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        
                        
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manutenção Pessoa<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#" id="cad_aluno" >Aluno</a></li>
                                <li><a href="#" id="cad_professor">Professor</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#" id="cad_area">Área</a></li>
                                <li><a href="#" id="cad_turma">Turma</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#" id="mat_aluno">Matricular Aluno</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manutenção Exame<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#" id="cad_exame" >Exame</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#" id="cad_exameO">Questões Objetivas</a></li>
                                <li><a href="#" id="cad_exameD">Questões Dissertativas</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pessoa <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Sair</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6" id="conteudo"><% request.getAttribute("eviou"); %></div>
            <div class="col-md-3"></div>
        </div>
        <script src="js/ajaxPaginas.js"></script>
        <script></script>
    </body>
</html>
