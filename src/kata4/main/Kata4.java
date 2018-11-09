package kata4.main;

import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {
    
    
    List<Mail> listaMails;
    Histogram<String> histogram;

    public static void main(String[] args) throws IOException {
        
        Kata4 kata = new Kata4();
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
