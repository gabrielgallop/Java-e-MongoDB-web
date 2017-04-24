package Controller;

import DAO.alunoDAO;
import Model.alunoModel;
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
public class alunoController extends HttpServlet {

    public alunoController() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String metodo = request.getParameter("metodo");

        if (metodo.equals("1")) {
            alunoModel aluno = new alunoModel();

            aluno.setCpf(request.getParameter("cpf"));
            aluno.setNome(request.getParameter("nome"));
            aluno.setSobrenome(request.getParameter("sobrenome"));
            aluno.setNascimento(request.getParameter("nascimento"));
            aluno.setEmail(request.getParameter("email"));
            aluno.setPais(request.getParameter("pais"));
            aluno.setCidade(request.getParameter("cidade"));
            aluno.setUf(request.getParameter("uf"));
            aluno.setSenha(request.getParameter("senha"));
            aluno.setNro_rg(request.getParameter("rg"));
            aluno.setEmissor_rg(request.getParameter("emissor"));
            aluno.setEstado_rg(request.getParameter("estado"));
            aluno.setFone(request.getParameter("telefone"));
            aluno.setRa(request.getParameter("ra"));

            alunoDAO alunoD = new alunoDAO();
            alunoD.insert(aluno);

            response.sendRedirect("index.jsp?cad=1");
        }

    }

    public String tabela() {

        alunoDAO alunoD = new alunoDAO();

        DBCursor cursor = alunoD.findAll();

        String tabela = "<table  class=\"table table-condensed table-hover\"><thead> <tr> <th>CPF</th> <th>RA</th> <th>Nome Completo</th></tr> </thead><tbody>";

        while (cursor.hasNext()) {
            BasicDBObject pessoa = (BasicDBObject) cursor.next();
            tabela += "<tr><th>" + pessoa.getString("cpf") + "</th> <td>" + pessoa.getString("ra") + "</td> <td>" + pessoa.getString("nome") + " " + pessoa.getString("sobrenome") + "</td></tr>";
        }

        tabela += "</tbody></table>";

        return tabela;
    }
    
    public String tabelaMatricula() {

        alunoDAO alunoD = new alunoDAO();

        DBCursor cursor = alunoD.findAll();
        String id = "";
        String nome = "";
        String cpf = "";
        String ra = "";

        String tabela = "<table  class=\"table table-condensed table-hover\"><thead> <tr> <th>CPF</th> <th>Nome Completo</th> <th>RA</th><th>Selecionar</th></tr> </thead><tbody>";

        while (cursor.hasNext()) {
            BasicDBObject pessoa = (BasicDBObject) cursor.next();
            id = pessoa.getString("_id");
            nome = pessoa.getString("nome") + " " + pessoa.getString("sobrenome");
            cpf = pessoa.getString("cpf");
            ra = pessoa.getString("ra");
            
            tabela += "<tr><th data-cpf=\"" + cpf + "\"> " + cpf + "</th> <td data-nome=\"" + nome + "\">" + nome + "</td> <td data-ra=\"" + ra + "\">" + ra + "</td><td><form><input type=\"hidden\" name=\"ok\" value=\"" + id +"\"><input  class=\"btn btn-info click\" type=\"button\" value=\"Selecionar\" id\"" + id + "\"></form></td></tr>"; 
        }
//<td data-nome="Lorem Ipsum">Nome attr data-</td>
        tabela += "</tbody></table>";

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
