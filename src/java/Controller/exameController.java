package Controller;

import DAO.exameDAO;
import Model.exameDissertativoModel;
import Model.exameModel;
import Model.exameObjetivoModel;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gabriel
 */
public class exameController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String metodo = request.getParameter("metodo");

        if (metodo.equals("1")) {

            exameModel exame = new exameModel();

            exame.setId_exame(request.getParameter("nome"));
            exame.setDescricao(request.getParameter("descricao"));
            exame.setTempo(request.getParameter("tempo"));
            exame.setData(request.getParameter("data"));
            exame.setTurma(request.getParameter("turma"));
            exame.setDominio(request.getParameter("dominio"));
            exame.setProfessor(request.getParameter("professor"));
            exame.setStatus(request.getParameter("tipo"));
            exame.setMedia("0");

            exameDAO exameD = new exameDAO();
            exameD.insert(exame);

            response.sendRedirect("index.jsp?cad=1");
        }
        if (metodo.equals("insertEmbedded")) {

            String id = request.getParameter("id");

            exameObjetivoModel exameO = new exameObjetivoModel();

            exameO.setDescricaoQ(request.getParameter("descricao"));
            exameO.setArea(request.getParameter("area"));
            exameO.setDificuldade(request.getParameter("dificuldade"));
            exameO.setCorreta(request.getParameter("correta"));
            exameO.setLetraA(request.getParameter("respostaA"));
            exameO.setLetraB(request.getParameter("respostaB"));
            exameO.setLetraC(request.getParameter("respostaC"));
            exameO.setLetraD(request.getParameter("respostaD"));
            exameO.setLetraE(request.getParameter("respostaE"));

            exameDAO exameD = new exameDAO();
            exameD.insertQuestao(exameO, id);

            response.sendRedirect("view/cadExameO2.jsp?ok=" + id);
        }
        
        if (metodo.equals("insertEmbedded2")) {

            String id = request.getParameter("id");

            exameDissertativoModel exameD = new exameDissertativoModel();

            exameD.setDescricaoQ(request.getParameter("descricao"));
            exameD.setArea(request.getParameter("area"));
            exameD.setDificuldade(request.getParameter("dificuldade"));
            exameD.setCriterio(request.getParameter("criterio"));
            exameD.setPeso(request.getParameter("peso"));

            exameDAO exame = new exameDAO();
            exame.insertQuestaoD(exameD, id);

            response.sendRedirect("view/cadExameD2.jsp?ok=" + id);
        }

    }

    public String tabela() {

        exameDAO exameD = new exameDAO();

        DBCursor cursor = exameD.findAll();

        String tabela = "<table  class=\"table table-condensed table-hover\"><thead> <tr> <th>Nome</th> <th>Descrição</th> <th>Professor</th></tr> </thead><tbody>";

        while (cursor.hasNext()) {
            BasicDBObject pessoa = (BasicDBObject) cursor.next();
            tabela += "<tr><th>" + pessoa.getString("id_exame") + "</th> <td>" + pessoa.getString("descricao") + "</td> <td>" + pessoa.getString("professor") + "</td></tr>";
        }

        tabela += "</tbody></table>";

        return tabela;
    }

    public String tabelaSO() {

        exameDAO exameD = new exameDAO();

        DBCursor cursor = exameD.findStatus("1");

        String tabela = "<table  class=\"table table-condensed table-hover\"><thead> <tr> <th>Nome</th> <th>Descricao</th> <th>Professor</th><th>Selecionar</th></tr> </thead><tbody>";

        while (cursor.hasNext()) {
            BasicDBObject pessoa = (BasicDBObject) cursor.next();
            tabela += "<tr><th>" + pessoa.getString("id_exame") + "</th> <td>" + pessoa.getString("descricao") + "</td> <td>" + pessoa.getString("professor") + "</td><td><form action=\"view/cadExameO2.jsp\" method=\"POST\"><input type=\"hidden\" name=\"ok\" value=\"" + pessoa.getString("_id") + "\"><input  class=\"btn btn-info\" type=\"submit\" value=\"Selecionar\"></form></td></tr>";
        }

        tabela += "</tbody></table>";

        return tabela;
    }
    
    public String tabelaSD() {

        exameDAO exameD = new exameDAO();

        DBCursor cursor = exameD.findStatus("2");

        String tabela = "<table  class=\"table table-condensed table-hover\"><thead> <tr> <th>Nome</th> <th>Descricao</th> <th>Professor</th><th>Selecionar</th></tr> </thead><tbody>";

        while (cursor.hasNext()) {
            BasicDBObject pessoa = (BasicDBObject) cursor.next();
            tabela += "<tr><th>" + pessoa.getString("id_exame") + "</th> <td>" + pessoa.getString("descricao") + "</td> <td>" + pessoa.getString("professor") + "</td><td><form action=\"view/cadExameD2.jsp\" method=\"POST\"><input type=\"hidden\" name=\"ok\" value=\"" + pessoa.getString("_id") + "\"><input  class=\"btn btn-info\" type=\"submit\" value=\"Selecionar\"></form></td></tr>";
        }

        tabela += "</tbody></table>";

        return tabela;
    }

    public String tabelaQuestao(String id) {

        exameDAO exameD = new exameDAO();

        DBCursor cursor = exameD.findID(id);
        int i;
        String tabela = "";
        int j;
        try{
            if (cursor.hasNext()) {
                BasicDBObject exame = (BasicDBObject) cursor.next();
                BasicDBList questao = (BasicDBList) exame.get("questao");
                BasicDBObject mostra;

                i = questao.size();
                j = 0;
                while (j < i) {

                    mostra = (BasicDBObject) questao.get(j);

                    tabela += "<div class=\"row\"><div class=\"col-md-12\"><hr>Pergunta " + (j+1) + "<input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"" + i + mostra.getString("descricaoQ") + "\"></div></div>";
                    tabela += "<div class=\"row\"><div class=\"col-md-12\">Respostas (Resposta correta: "+ mostra.getString("correta") + ")<input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"A - " + mostra.getString("letraA") + "\"></div></div>";
                    tabela += "<div class=\"row\"><div class=\"col-md-12\"><input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"B - " + mostra.getString("letraB") + "\"></div></div>";
                    tabela += "<div class=\"row\"><div class=\"col-md-12\"><input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"C - " + mostra.getString("letraC") + "\"></div></div>";
                    tabela += "<div class=\"row\"><div class=\"col-md-12\"><input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"D - " + mostra.getString("letraD") + "\"></div></div>";
                    tabela += "<div class=\"row\"><div class=\"col-md-12\"><input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"E - " + mostra.getString("letraE") + "\"></div></div>";

                    j = j + 1;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return tabela;
    }
    
    public String tabelaQuestaoD(String id) {

        exameDAO exameD = new exameDAO();

        DBCursor cursor = exameD.findID(id);
        int i;
        String tabela = "";
        int j;
        
        try{
            if (cursor.hasNext()) {
                BasicDBObject exame = (BasicDBObject) cursor.next();
                BasicDBList questao = (BasicDBList) exame.get("questao");
                BasicDBObject mostra;

                i = questao.size();
                j = 0;
                while (j < i) {

                    mostra = (BasicDBObject) questao.get(j);

                    tabela += "<div class=\"row\"><div class=\"col-md-12\"><hr>Pergunta " + (j+1) + "<input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"" + i + mostra.getString("descricaoQ") + "\"></div></div>";
                    tabela += "<div class=\"row\"><div class=\"col-md-12\">Criterio <input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"" + mostra.getString("criterio") + "\"></div></div>";
                    tabela += "<div class=\"row\"><div class=\"col-md-6\">Área<input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"" + mostra.getString("area") + "\"></div>";
                    tabela +=                    "<div class=\"col-md-6\">Peso<input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"" + mostra.getString("peso") + "\"></div></div>";

                    j = j + 1;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return tabela;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
