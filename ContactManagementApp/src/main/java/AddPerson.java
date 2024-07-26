import com.github.javafaker.Faker;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class AddPerson {
    public static void main(String[] args) {

        String connectionString = "mongodb://localhost:27017";

        MongoClient mongoClient = MongoClients.create(connectionString);

        MongoDatabase database = mongoClient.getDatabase("rehberUygulamasi");

        MongoCollection<Document> collection = database.getCollection("people");

        Faker faker = new Faker();

        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        int age = faker.number().numberBetween(18, 99);
        Document person = new Document("name", name)
                .append("email", email)
                .append("phone", phoneNumber)
                .append("age", age);

        collection.insertOne(person);

        System.out.println("Kişi eklendi: " + person.toJson());

        mongoClient.close();
    }
}
