package DAO;

import Model.alunoModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

/**
 * @author gabriel
 */
public class alunoDAO extends DAO{
    
    public void insert(alunoModel aluno){
        
        Mongo con = conexao("aluno");
        
        BasicDBObject documento = new BasicDBObject();

        documento.put("cpf", "'"        + aluno.getCpf()        + "'");
        documento.put("nome", "'"       + aluno.getNome()       + "'");
        documento.put("sobrenome", "'"  + aluno.getSobrenome()  + "'");
        documento.put("nascimento", "'" + aluno.getNascimento() + "'");
        documento.put("email", "'"      + aluno.getEmail()      + "'");
        documento.put("pais", "'"       + aluno.getPais()       + "'");
        documento.put("cidade", "'"     + aluno.getCidade()     + "'");
        documento.put("uf", "'"         + aluno.getUf()         + "'");
        documento.put("senha", "'"      + aluno.getSenha()      + "'");
        documento.put("nro_rg", "'"     + aluno.getNro_rg()     + "'");
        documento.put("emissor_rg", "'" + aluno.getEmissor_rg() + "'");
        documento.put("estado_rg", "'"  + aluno.getEstado_rg()  + "'");
        documento.put("fone", "'"       + aluno.getFone()       + "'");
        documento.put("ra", "'"         + aluno.getRa()         + "'");
        
        tabela.insert(documento);
        
        conexaoClose(con);
    }
    
    public DBCursor findAll(){
        conexao("aluno");
        
        return tabela.find();
    }
}
