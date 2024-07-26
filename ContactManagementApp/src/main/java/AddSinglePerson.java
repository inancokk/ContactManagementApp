import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Scanner;

public class AddSinglePerson {
    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017";

        MongoClient mongoClient = MongoClients.create(connectionString);

        MongoDatabase database = mongoClient.getDatabase("rehberUygulamasi");

        MongoCollection<Document> collection = database.getCollection("people");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Yeni kişi bilgilerini girin:");

        System.out.print("İsim: ");
        String name = scanner.nextLine();

        System.out.print("E-posta: ");
        String email = scanner.nextLine();

        System.out.print("Telefon numarası: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Yaş: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Document person = new Document("name", name)
                .append("email", email)
                .append("phone", phoneNumber)
                .append("age", age);

        collection.insertOne(person);

        System.out.println("Kişi eklendi: " + person.toJson());

        mongoClient.close();
    }
}
