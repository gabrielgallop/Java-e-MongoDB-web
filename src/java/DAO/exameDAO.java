package DAO;

import Model.exameDissertativoModel;
import Model.exameModel;
import Model.exameObjetivoModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import org.bson.types.ObjectId;

/**
 * @author gabriel
 */
public class exameDAO extends DAO{
    
    public void insert(exameModel exame){
    
        conexao("exame");
        
        BasicDBObject documento = new BasicDBObject();
        //BasicDBObject documentoE = new BasicDBObject();

        documento.put("id_exame", "'"  + exame.getId_exame()  + "'");
        documento.put("descricao", "'" + exame.getDescricao() + "'");
        documento.put("tempo", "'"     + exame.getTempo()     + "'");
        documento.put("dominio", "'"   + exame.getDominio()   + "'");
        documento.put("data", "'"      + exame.getData()      + "'");
        documento.put("turma", "'"     + exame.getTurma()     + "'");
        documento.put("professor", "'" + exame.getProfessor() + "'");
        documento.put("status", "'"    + exame.getStatus()    + "'");
        documento.put("media", "'"     + exame.getMedia()     + "'");
        
        tabela.insert(documento);
        
    }
    
    public DBCursor findAll(){
        conexao("exame");
        return tabela.find();
    }
    
    public DBCursor findID(String id){
        conexao("exame");
        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id));
        
        return tabela.find(query);
    }
    
    public DBCursor findStatus(String id){
        conexao("exame");
        
        BasicDBObject query = new BasicDBObject();
        query.put("status","'" + id + "'");
        
        return tabela.find(query);
    }
    
    public void insertQuestao(exameObjetivoModel exameO, String id){
    
        conexao("exame");
        
        BasicDBObject documento = new BasicDBObject();
        //BasicDBObject documentoE = new BasicDBObject();

        documento.put("descricaoQ", "'"  + exameO.getDescricaoQ()  + "'");
        documento.put("area", "'"        + exameO.getArea()        + "'");
        documento.put("dificuldade", "'" + exameO.getDificuldade() + "'");
        documento.put("correta", "'"     + exameO.getCorreta()     + "'");
        documento.put("letraA", "'"      + exameO.getLetraA()      + "'");
        documento.put("letraB", "'"      + exameO.getLetraB()      + "'");
        documento.put("letraC", "'"      + exameO.getLetraC()      + "'");
        documento.put("letraD", "'"      + exameO.getLetraD()      + "'");
        documento.put("letraE", "'"      + exameO.getLetraE()      + "'");
        
        BasicDBObject questao = new BasicDBObject("questao", documento);
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id));

        BasicDBObject withSet = new BasicDBObject("$push", questao);

        tabela.update(query, withSet);
        
        
    }
    
    public void insertQuestaoD(exameDissertativoModel exameD, String id){
    
        conexao("exame");
        
        BasicDBObject documento = new BasicDBObject();
        //BasicDBObject documentoE = new BasicDBObject();

        documento.put("descricaoQ", "'"  + exameD.getDescricaoQ()  + "'");
        documento.put("area", "'"        + exameD.getArea()        + "'");
        documento.put("dificuldade", "'" + exameD.getDificuldade() + "'");
        documento.put("criterio", "'"    + exameD.getCriterio()    + "'");
        documento.put("peso", "'"        + exameD.getPeso()        + "'");
        
        BasicDBObject questao = new BasicDBObject("questao", documento);
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id));

        BasicDBObject withSet = new BasicDBObject("$push", questao);

        tabela.update(query, withSet);
        
        
    }
    
}
