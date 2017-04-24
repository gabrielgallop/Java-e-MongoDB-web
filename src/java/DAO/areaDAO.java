package DAO;

/**
 * @author gabriel
 */

import Model.areaModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

public class areaDAO extends DAO{
    
    public void insert(areaModel area){
    
        conexao("area");
        
        BasicDBObject documento = new BasicDBObject();

        documento.put("sigla", "'"       + area.getSigla()     + "'");
        documento.put("descricao", "'" + area.getDescricao() + "'");
        documento.put("area_pai", "'"    + area.getAreaePai()  + "'");
            
        tabela.insert(documento);
        
    }
    
    public DBCursor findAll(){
        conexao("area");
        return tabela.find();
    }
}
