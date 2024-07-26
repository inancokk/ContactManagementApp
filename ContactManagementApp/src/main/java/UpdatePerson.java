import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class UpdatePerson {
    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017";

        MongoClient mongoClient = MongoClients.create(connectionString);

        MongoDatabase database = mongoClient.getDatabase("rehberUygulamasi");

        MongoCollection<Document> collection = database.getCollection("people");

        Document query = new Document("name", "John Doe");
        Document newValue = new Document("age", 31);
        Document updateOperation = new Document("$set", newValue);

        collection.updateOne(query, updateOperation);

        System.out.println("Kişi güncellendi.");

        mongoClient.close();
    }
}
