package mx.uv.fiee.iinf.paradigmas.poo;

abstract class Document {
    String title;
    String author;
    String content;
    abstract void open ();
    abstract void save ();
    abstract void process ();
    abstract void print ();
}

public class DocumentClient {

    public static void main(String[] args) {

        Word w = new Word ();
        w.title = "Word Document";

        Excel e = new Excel ();
        w.title = "Excel Document";

        PDF p = new PDF();
        p.sign ();

        Document p1 = new PDF ();

        Document d = new PowerPoint ();

        SendDocument (w);
        SendDocument (e);
        SendDocument (p);
        SendDocument (d);

    }

    private static void SendDocument (Document doc) {
        //enviar el doc

    }

}


class Word extends Document {
    @Override
    void open () {}

    @Override
    void save () {}

    @Override
    void process () {}

    @Override
    void print() {

    }
}

class Excel extends Document {
    void open () {}
    void save () {}
    void process () {}

    @Override
    void print() {

    }
}

class PowerPoint extends Document {
    void open () {}
    void save () {}
    void process () {}

    @Override
    void print() {

    }
}

class PDF extends Document {
    void sign () {}

    @Override
    void open() {

    }

    @Override
    void save() {

    }

    @Override
    void process() {

    }

    @Override
    void print() {

    }
}