package kata5p2.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReader;
import kata5p2.view.MailListReaderBD;

public class Kata5p2 {
    
    
    List<Mail> listaMails;
    Histogram<String> histogram;

    public static void main(String[] args) throws IOException, SQLException {
        
        Kata5p2 kata = new Kata5p2();
        kata.execute();
    }    

    private void execute() throws IOException, SQLException {
        input();
        process();
        output();
    }

    private void input() throws IOException, SQLException {
        listaMails = MailListReaderBD.read();
    }

    private void process() {
       histogram = MailHistogramBuilder.build(listaMails);
    }

    private void output() {
        HistogramDisplay histo = new HistogramDisplay(histogram);
        histo.execute();
    }
}
