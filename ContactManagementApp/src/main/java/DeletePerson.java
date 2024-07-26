import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class DeletePerson {
    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017";

        MongoClient mongoClient = MongoClients.create(connectionString);

        MongoDatabase database = mongoClient.getDatabase("rehberUygulamasi");

        MongoCollection<Document> collection = database.getCollection("people");

        Document query = new Document("name", "John Doe");

        collection.deleteOne(query);

        System.out.println("Kişi silindi.");

        mongoClient.close();
    }
}
