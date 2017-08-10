import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * Created by mohit.sh on 10/08/17.
 */
public class DBConnect {
    private static final MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://172.16.44.249:27017"));

    private DBConnect() {}

    public static MongoClient getInstance() {
        return mongoClient;
    }
}
