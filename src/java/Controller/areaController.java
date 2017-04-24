package Controller;

import DAO.areaDAO;
import Model.areaModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gabriel
 */
@WebServlet(name = "areaController", urlPatterns = {"/areaController"})
public class areaController extends HttpServlet {

    public areaController() {
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String metodo = request.getParameter("metodo");

        if (metodo.equals("1")) {
            areaModel area = new areaModel();

            area.setSigla(request.getParameter("sigla"));
            area.setDescricao(request.getParameter("descricao"));
            area.setAreaePai(request.getParameter("areaPai"));
            

            areaDAO areaD = new areaDAO();
            areaD.insert(area);

            response.sendRedirect("index.jsp?cad=1");
        }
    }

    public String tabela() {

        areaDAO areaD = new areaDAO();

        DBCursor cursor = areaD.findAll();

        String tabela = "<table  class=\"table table-condensed table-hover\"><thead> <tr> <th>Sigla</th> <th>Descrição</th> <th>Área Pai</th></tr> </thead><tbody>";

        while (cursor.hasNext()) {
            BasicDBObject pessoa = (BasicDBObject) cursor.next();
            tabela += "<tr><th>" + pessoa.getString("sigla") + "</th> <td>" + pessoa.getString("descricao") + "</td> <td>" + pessoa.getString("area_pai") + "</td></tr>";
        }

        tabela += "</tbody></table>";

        return tabela;
    }
    
    public String select() {

        areaDAO areaD = new areaDAO();

        DBCursor cursor = areaD.findAll();

        String tabela = "";

        while (cursor.hasNext()) {
            BasicDBObject pessoa = (BasicDBObject) cursor.next();
            String sigla = pessoa.getString("sigla");
            if(sigla != ""){
                tabela += "<option value=\"" + sigla + "\">" + sigla + "</option>";
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
