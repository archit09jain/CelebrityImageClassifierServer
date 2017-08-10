import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.bson.Document;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by mohit.sh on 09/08/17.
 */
public class DataFetch {

    public static List<Celebrity> getCelebrityData(List<Integer> IDs, List<Integer> prs){
        MongoClient mongoClient = DBConnect.getInstance();
        BasicDBObject inQuery = new BasicDBObject();
        inQuery.put("id", new BasicDBObject("$in", IDs));
        MongoDatabase database = mongoClient.getDatabase("celebrities2");
        MongoCollection<Document> collection = database.getCollection("celebrities2");
        FindIterable<Document> cursor = collection.find(inQuery);
        GridFSBucket gridBucket = GridFSBuckets.create(database);

        List<Celebrity> l = new ArrayList<>();
        int i = 0;
        for(Document doc : cursor){
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            gridBucket.downloadToStream(doc.getInteger("id").toString(), output);
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            l.add(new Celebrity(IDs.get(i),
                    doc.getInteger("age"),
                    prs.get(i),
                    doc.getString("name"),
                    doc.getString("ethinicity"),
                    Gender.valueOf(doc.getString("gender")),
                    Base64.getEncoder().encodeToString(output.toByteArray())));
            i++;
        }
        return l;
    }
}
