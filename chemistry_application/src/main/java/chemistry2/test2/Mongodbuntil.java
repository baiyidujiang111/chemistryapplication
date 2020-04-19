package chemistry2.test2;

import java.util.ArrayList;
import java.util.List;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class Mongodbuntil {
    public static MongoDatabase getConnect(){
        List<ServerAddress> adds = new ArrayList<ServerAddress>();
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        ServerAddress serverAddress = new ServerAddress("verygoodstyle.cn", 27017);
        adds.add(serverAddress);

        //List<MongoCredential> credentials = new ArrayList<>();
        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("CYS", "admin", "123456".toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(mongoCredential);

        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(adds, credentials);
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");

        //返回连接数据库对象
        return mongoDatabase;
    }
}
