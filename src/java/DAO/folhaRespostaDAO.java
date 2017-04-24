package DAO;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import org.bson.types.ObjectId;

/**
 * @author gabriel
 */

public class folhaRespostaDAO extends DAO{
    
    public DBCursor login(String usuario, String senha){
    
        conexao("aluno");
        
        BasicDBObject query = new BasicDBObject();
        query.put("cpf", "'" + usuario + "'");
        query.put("senha", "'" + senha + "'");
        
        return tabela.find(query);
        
    }
    
    public DBCursor pesquisaTurma(String cpf){
        conexao("turma");
        
        BasicDBObject query = new BasicDBObject();
        query.put("alunos.cpf", "'" + cpf + "'");
        
        return tabela.find(query);
    }
    
    public DBCursor pesquisaExame(String id){
        conexao("exame");
        
        BasicDBObject query = new BasicDBObject();
        query.put("turma", "'" + id + "'");
        
        return tabela.find(query);
    }
    
    public DBCursor pesquisaQuestao(String id){
        conexao("exame");
        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id));
        
        return tabela.find(query);
    }
    
}
