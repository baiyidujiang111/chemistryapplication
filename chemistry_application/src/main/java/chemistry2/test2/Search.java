package chemistry2.test2;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import net.sf.json.JSONObject;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Search {
    @ResponseBody
    public  String serch(String str)
    {
        //String str;
        str="电子式";
        //Mongodbuntil mo=new Mongodbuntil();   JSONObject
        MongoDatabase mo=Mongodbuntil.getConnect();

        MongoCollection<Document> collection = mo.getCollection("test");
        FindIterable<Document> findIterable=collection.find(Filters.eq("name", str));
        MongoCursor<Document> cursor=findIterable.iterator();

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        while (cursor.hasNext()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.putAll(cursor.next());
            list.add(map);
        }
        //System.out.println("集合 test 选择成功");
        //Bson filter = Filters.eq("name","离子化合物");

        System.out.println(list.get(0).get("contents").toString());

        System.out.println(cursor.hasNext());
        /*while (cursor.hasNext())
        {
            System.out.println("test1");
            System.out.println(cursor.next());
        }*/
        return list.get(0).get("contents").toString();
    }

}
