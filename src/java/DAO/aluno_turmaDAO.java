package DAO;

/**
 * @author gabriel
 */

import Model.aluno_turmaModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

public class aluno_turmaDAO extends DAO{
        
    public void insert(aluno_turmaModel aluno_turma){
    
        conexao("aluno_turma");
        
        BasicDBObject documento = new BasicDBObject();

        documento.put("cpf", "'"    + aluno_turma.getCpf()   + "'");
        documento.put("sigla", "'"    + aluno_turma.getSigla() + "'");
            
        tabela.insert(documento);
        
    }
    
    public DBCursor findAll(){
        conexao("aluno_turma");
        return tabela.find();
    }
    
}
