package DAO;

/**
 * @author gabriel
 */

import Model.professorModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class professorDAO extends DAO{
    
    public void insert(professorModel professor){
    
        Mongo con = conexao("professor");
        
        BasicDBObject documento = new BasicDBObject();

        documento.put("cpf", "'"        + professor.getCpf()        + "'");
        documento.put("nome", "'"       + professor.getNome()       + "'");
        documento.put("sobrenome", "'"  + professor.getSobrenome()  + "'");
        documento.put("nascimento", "'" + professor.getNascimento() + "'");
        documento.put("email", "'"      + professor.getEmail()      + "'");
        documento.put("pais", "'"       + professor.getPais()       + "'");
        documento.put("cidade", "'"     + professor.getCidade()     + "'");
        documento.put("uf", "'"         + professor.getUf()         + "'");
        documento.put("senha", "'"      + professor.getSenha()      + "'");
        documento.put("nro_rg", "'"     + professor.getNro_rg()     + "'");
        documento.put("emissor_rg", "'" + professor.getEmissor_rg() + "'");
        documento.put("estado_rg", "'"  + professor.getEstado_rg()  + "'");
        documento.put("fone", "'"       + professor.getFone()       + "'");
        documento.put("matricula", "'"  + professor.getMatricula()  + "'");
        documento.put("titulo", "'"     + professor.getTitulo()     + "'");
        documento.put("cargo", "'"      + professor.getCargo()      + "'");
            
        tabela.insert(documento);
        conexaoClose(con);
    }    
    
    public DBCursor findAll(){
        conexao("professor");
        return tabela.find();
    }
    
}
