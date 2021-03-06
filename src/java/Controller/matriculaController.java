package Controller;

import DAO.turmaDAO;
import Model.turmaModel;
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
public class matriculaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String metodo = request.getParameter("metodo");
        String ok = request.getParameter("ok");
        
        if (metodo == "1") {

            turmaModel turma = new turmaModel();
            
            turma.setCpf(request.getParameter("cpf"));
            turma.setRa(request.getParameter("ra"));
            turma.setNome(request.getParameter("nome"));
            
            turmaDAO turmaD = new turmaDAO();
            turmaD.insert(turma);
            
            response.sendRedirect("index.jsp?cad=1");
        }
        if (ok != "") {
            
            
            response.sendRedirect("index.jsp?cad=007");
        }
        
    }

    public String tabela() {

        turmaDAO turmaD = new turmaDAO();

        DBCursor cursor = turmaD.findAll();

        String tabela = "<table  class=\"table table-condensed table-hover\"><thead> <tr> <th>Sigla</th> <th>Curso</th> <th>Ano</th><th>Selecionar</th></tr> </thead><tbody>";

        while (cursor.hasNext()) {
            BasicDBObject pessoa = (BasicDBObject) cursor.next();
            tabela += "<tr><th>" + pessoa.getString("sigla") + "</th> <td>" + pessoa.getString("curso") + "</td> <td>" + pessoa.getString("ano") + "</td><td><form action=\"view/matAluno2.jsp\" method=\"POST\"><input type=\"hidden\" name=\"ok\" value=\"" + pessoa.getString("_id") +"\"><input  class=\"btn btn-info\" type=\"submit\"></form></td></tr>"; 
        }

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
