package codes.wise.taskup.dao;

import com.orm.SugarRecord;

import java.util.Collections;
import java.util.List;

/**
 * Created by rogermac on 02/03/17.
 */

public abstract class SugarAbstractRepository<T extends SugarRecord> {

    private Class<T> type;

    public SugarAbstractRepository(Class<T> type){
        this.type = type;
    }

    public long save(T t){
        return t.save();
    }

    public void delete(T t){
        t.delete();
    }

    public T findById(long id){
        return T.findById(type, id);
    }

    public List<T> all(){
        return T.listAll(type);
    }
}
