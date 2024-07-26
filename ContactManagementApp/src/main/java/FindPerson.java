import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class FindPerson {
    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017";

        MongoClient mongoClient = MongoClients.create(connectionString);

        MongoDatabase database = mongoClient.getDatabase("rehberUygulamasi");

        MongoCollection<Document> collection = database.getCollection("people");

        FindIterable<Document> result = collection.find(new Document("name", "John Doe"));

        for (Document doc : result) {
            System.out.println("Bulunan kişi: " + doc.toJson());
        }

        mongoClient.close();
    }
}
