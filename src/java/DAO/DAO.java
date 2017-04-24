package DAO;

/**
 * @author gabriel
 */

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    DB db;
    DBCollection tabela;
    
    public Mongo conexao(String t){
        Mongo mongo;
        try {
            mongo = new Mongo("localhost", 27017);
            db = mongo.getDB("Grupo3");
            tabela = db.getCollection(t);
            
            return mongo;
        } catch (UnknownHostException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    
    public void conexaoClose(Mongo mongo){
        mongo.close();
    }
}
