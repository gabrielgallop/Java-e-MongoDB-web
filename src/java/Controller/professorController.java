package Controller;

import DAO.alunoDAO;
import DAO.professorDAO;
import Model.professorModel;
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
public class professorController extends HttpServlet {

    public professorController() {
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            

        professorModel professor = new professorModel();
        
        professor.setCpf(request.getParameter("cpf"));
        professor.setNome(request.getParameter("nome"));
        professor.setSobrenome(request.getParameter("sobrenome"));
        professor.setNascimento(request.getParameter("nascimento"));
        professor.setEmail(request.getParameter("email"));
        professor.setPais(request.getParameter("pais"));
        professor.setCidade(request.getParameter("cidade"));
        professor.setUf(request.getParameter("uf"));
        professor.setSenha(request.getParameter("senha"));
        professor.setNro_rg(request.getParameter("rg"));
        professor.setEmissor_rg(request.getParameter("emissor"));
        professor.setEstado_rg(request.getParameter("estado"));
        professor.setFone(request.getParameter("telefone"));
        professor.setMatricula("matricula");
        professor.setTitulo("titulo");
        professor.setCargo("cargo");

        professorDAO profD = new professorDAO();
        profD.insert(professor);

        response.sendRedirect("index.jsp?cad=1");
    }

    public String tabela() {

        professorDAO profD = new professorDAO();

        DBCursor cursor = profD.findAll();

        String tabela = "<table  class=\"table table-condensed table-hover\"><thead> <tr> <th>CPF</th> <th>Matricula</th> <th>Nome Completo</th></tr> </thead><tbody>";

        while (cursor.hasNext()) {
            BasicDBObject pessoa = (BasicDBObject) cursor.next();
            tabela += "<tr><th>" + pessoa.getString("cpf") + "</th> <td>" + pessoa.getString("matricula") + "</td> <td>" + pessoa.getString("nome") + " " + pessoa.getString("sobrenome") + "</td></tr>";
        }

        tabela += "</tbody></table>";

        return tabela;
    }
    
    public String select() {

        professorDAO profD = new professorDAO();

        DBCursor cursor = profD.findAll();

        String tabela = "";

        while (cursor.hasNext()) {
            BasicDBObject pessoa = (BasicDBObject) cursor.next();
            String nome = pessoa.getString("nome") + " " + pessoa.getString("sobrenome");
            if(nome != ""){
                tabela += "<option value=\"" + nome + "\">" + nome + "</option>";
            }
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
