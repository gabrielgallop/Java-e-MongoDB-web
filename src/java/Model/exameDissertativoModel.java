/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author gabriel
 */
public class exameDissertativoModel extends exameModel{
    
    private String id_questao;
    private String descricaoQ;
    private String area;
    private String dificuldade;
    private String criterio;
    private String peso;

    public exameDissertativoModel() {
    
    }

    public String getId_questao() {
        return id_questao;
    }

    public void setId_questao(String id_questao) {
        this.id_questao = id_questao;
    }

    public String getDescricaoQ() {
        return descricaoQ;
    }

    public void setDescricaoQ(String descricaoQ) {
        this.descricaoQ = descricaoQ;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
        
}
