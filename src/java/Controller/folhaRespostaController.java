package Controller;

import DAO.folhaRespostaDAO;
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
public class folhaRespostaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        folhaRespostaDAO folhaD = new folhaRespostaDAO();
        
        String metodo = request.getParameter("metodo");
        
        if(metodo.equals("login")){
            String usuario = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            DBCursor cursor = folhaD.login(usuario, senha);
            
            if(cursor.hasNext()){
                response.sendRedirect("view/provas.jsp?cpf=" + usuario);
            }
        }
    }

    public String listaTurmas(String cpf){
        folhaRespostaDAO folhaD = new folhaRespostaDAO();

        DBCursor cursor = folhaD.pesquisaTurma(cpf);

        String tabela = "<table  class=\"table table-condensed table-hover\"><thead> <tr> <th>Sigla</th> <th>Curso</th> <th>Ano</th><th>Selecionar</th></tr> </thead><tbody>";

        while (cursor.hasNext()) {
            BasicDBObject pessoa = (BasicDBObject) cursor.next();
            tabela += "<tr><th>" + pessoa.getString("sigla") + "</th> <td>" + pessoa.getString("curso") + "</td> <td>" + pessoa.getString("ano") + "</td><td><form action=\"provas2.jsp\" method=\"POST\"><input type=\"hidden\" name=\"ok\" value=\"" + pessoa.getString("sigla") + "\"><input  class=\"btn btn-info\" type=\"submit\" value=\"Selecionar\"></form></td></tr>";
        }

        tabela += "</tbody></table>";

        return tabela;
    }
    
    public String listaExames(String id){
        folhaRespostaDAO folhaD = new folhaRespostaDAO();

        DBCursor cursor = folhaD.pesquisaExame(id);

        String tabela = "<table  class=\"table table-condensed table-hover\"><thead> <tr> <th>Descrição</th> <th>Curso</th> <th>Professor</th><th>Selecionar</th></tr> </thead><tbody>";

        while (cursor.hasNext()) {
            BasicDBObject pessoa = (BasicDBObject) cursor.next();
            tabela += "<tr><th>" + pessoa.getString("id_exame") + "</th> <td>" + pessoa.getString("descricao") + "</td> <td>" + pessoa.getString("professor") + "</td><td><form action=\"prova3.jsp\" method=\"POST\"><input type=\"hidden\" name=\"ok\" value=\"" + pessoa.getString("_id") + "\"><input  class=\"btn btn-info\" type=\"submit\" value=\"Selecionar\"></form></td></tr>";
        }

        tabela += "</tbody></table>";

        return tabela;
    }
    
    public String tabelaQuestao(String id) {

        folhaRespostaDAO folhaD = new folhaRespostaDAO();

        DBCursor cursor = folhaD.pesquisaQuestao(id);
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
                    tabela += "<div class=\"row\"><div class=\"col-md-12\">Respostas <input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"A - " + mostra.getString("letraA") + "\"></div></div>";
                    tabela += "<div class=\"row\"><div class=\"col-md-12\"><input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"B - " + mostra.getString("letraB") + "\"></div></div>";
                    tabela += "<div class=\"row\"><div class=\"col-md-12\"><input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"C - " + mostra.getString("letraC") + "\"></div></div>";
                    tabela += "<div class=\"row\"><div class=\"col-md-12\"><input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"D - " + mostra.getString("letraD") + "\"></div></div>";
                    tabela += "<div class=\"row\"><div class=\"col-md-12\"><input type=\"text\" readonly=\"readonly\" class=\"form-control\" value=\"E - " + mostra.getString("letraE") + "\"></div></div>";
                    tabela += "<hr><div class=\"row\"><div class=\"col-md-6\"><select class=\"form-control\"><option  value=\"A\">A</option><option  value=\"B\">B</option><option  value=\"C\">C</option><option  value=\"D\">D</option><option  value=\"E\">E</option></select></div><div class=\"col-md-6\"><button class=\"btn btn-info\">Responder</button></div></div>";

                    j = j + 1;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return tabela;
    }
    
    public String tabelaQuestao2(String id) {

        folhaRespostaDAO folhaD = new folhaRespostaDAO();

        DBCursor cursor = folhaD.pesquisaQuestao(id);
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
                    tabela += "<hr><div class=\"row\"><div class=\"col-md-6\"><input type=\"text\" class=\"form-control\" value=\"\"></div><div class=\"col-md-6\"><button class=\"btn btn-info\">Responder</button></div></div>";

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
