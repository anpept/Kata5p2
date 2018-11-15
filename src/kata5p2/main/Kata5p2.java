package kata5p2.main;

import java.io.IOException;
import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReader;

public class Kata5p2 {
    
    
    List<Mail> listaMails;
    Histogram<String> histogram;

    public static void main(String[] args) throws IOException {
        
        Kata5p2 kata = new Kata5p2();
        kata.execute();
    }    

    private void execute() throws IOException {
        input();
        process();
        output();
    }

    private void input() throws IOException {
        String file = "email.txt";
        listaMails = MailListReader.read(file);
    }

    private void process() {
       histogram = MailHistogramBuilder.build(listaMails);
    }

    private void output() {
        HistogramDisplay histo = new HistogramDisplay(histogram);
        histo.execute();
    }
}
