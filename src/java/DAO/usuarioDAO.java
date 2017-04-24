package DAO;

/**
 * @author gabriel
 */

import Model.usuarioModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

public class usuarioDAO extends DAO{
    
    
   
    public void insert(usuarioModel usuario){
        
        conexao("usuario");
        
        BasicDBObject documento = new BasicDBObject();

        documento.put("cpf", "'"        + usuario.getCpf()        + "'");
        documento.put("nome", "'"       + usuario.getNome()       + "'");
        documento.put("sobrenome", "'"  + usuario.getSobrenome()  + "'");
        documento.put("nascimento", "'" + usuario.getNascimento() + "'");
        documento.put("email", "'"      + usuario.getEmail()      + "'");
        documento.put("pais", "'"       + usuario.getPais()       + "'");
        documento.put("cidade", "'"     + usuario.getCidade()     + "'");
        documento.put("uf", "'"         + usuario.getUf()         + "'");
        documento.put("senha", "'"      + usuario.getSenha()      + "'");
        documento.put("nro_rg", "'"     + usuario.getNro_rg()     + "'");
        documento.put("emissor_rg", "'" + usuario.getEmissor_rg() + "'");
        documento.put("estado_rg", "'"  + usuario.getEstado_rg()  + "'");
        documento.put("fone", "'"       + usuario.getFone()       + "'");
        
        tabela.insert(documento);
    }
    
    public DBCursor findAll(){
        conexao("usuario");
        
        return tabela.find();
    }
    
}
