import models.*;
import org.json.JSONException;
import services.BookSaveVisitor;
import services.BookStatistics;

import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws JSONException, IOException {
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("models.Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("models.Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("models.Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("models.Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("models.Table 1"));
        BookStatistics stats = new BookStatistics();
        cap1.accept(stats);
        stats.printStatistics();
        BookSaveVisitor bsv = new BookSaveVisitor();
        cap1.accept(bsv);
        bsv.print();
    }

}
