package DAO;

/**
 * @author gabriel
 */

import Model.turmaModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import org.bson.types.ObjectId;

public class turmaDAO extends DAO{
    
    public void insert(turmaModel turma){
    
        conexao("turma");
        
        BasicDBObject documento = new BasicDBObject();
        //BasicDBObject documentoE = new BasicDBObject();

        documento.put("sigla", "'"    + turma.getSigla()   + "'");
        documento.put("turno", "'"    + turma.getTurno()   + "'");
        documento.put("curso", "'"    + turma.getCurso()   + "'");
        documento.put("ano", "'"      + turma.getAno()     + "'");
        documento.put("semestre", "'" + turma.getSemestre()+ "'");
        //documentoE.put("cpf", "'" + turma.getCpf()         + "'");
        //documentoE.put("ra", "'" + turma.getRa()          + "'");
        //documentoE.put("nome", "'" + turma.getNome()        + "'");
        //documento.put("aluno", documentoE);
        
        tabela.insert(documento);
        
    }
    
    public void insertEmbedded(turmaModel turma, String id){
        conexao("turma");
        
        BasicDBObject documento = new BasicDBObject();
        
        documento.put("cpf", turma.getCpf());
        documento.put("nome", turma.getNome());
        documento.put("ra", turma.getRa());
        
        BasicDBObject aluno = new BasicDBObject("alunos", documento);
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id));

        BasicDBObject withSet = new BasicDBObject("$push", aluno);

        tabela.update(query, withSet);
    }
    
    public DBCursor findAll(){
        conexao("turma");
        return tabela.find();
    }
    
    public DBCursor findID(String id){
        conexao("turma");
        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id));
        
        return tabela.find(query);
    }
}
