package lesson41.migrations;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import org.bson.Document;

@ChangeLog
public class MongoMigrations {

    @ChangeSet(order = "001", id = "dropDb", author = "Maxim Ketikov", runAlways = true)
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertCountry", author = "Maxim Ketikov")
    public void insertNewCountry(MongoDatabase db) {
        MongoCollection<Document> collection = db.getCollection("country");
        var doc = new Document()
                .append("_id", "RUS")
                .append("russianName", "Россия")
                .append("englishName", "Russia");
        collection.insertOne(doc);

    }
}
