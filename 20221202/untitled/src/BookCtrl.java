import java.util.Vector;

public class BookCtrl {
    private Vector<String> vectorName = new Vector<>();
    private Vector<String> vectorAuthor = new Vector<>();
    private Vector<String> vectorPublisher = new Vector<>();
    private Vector<String> vectorISBN = new Vector<>();
    //    private Vector<Boolean> vectorIfSelected = new Vector<>();
    private BookModel model = new BookModel();

    public Vector<String> getVectorName() {
        return vectorName;
    }

    public void setVectorName(Vector<String> vectorName) {
        this.vectorName = vectorName;
    }

    public Vector<String> getVectorAuthor() {
        return vectorAuthor;
    }

    public void setVectorAuthor(Vector<String> vectorAuthor) {
        this.vectorAuthor = vectorAuthor;
    }

    public Vector<String> getVectorPublisher() {
        return vectorPublisher;
    }

    public void setVectorPublisher(Vector<String> vectorPublisher) {
        this.vectorPublisher = vectorPublisher;
    }

    public Vector<String> getVectorISBN() {
        return vectorISBN;
    }

    public void setVectorISBN(Vector<String> vectorISBN) {
        this.vectorISBN = vectorISBN;
    }

//    public Vector<Boolean> getVectorIfSelected() {
//        return vectorIfSelected;
//    }
//
//    public void setVectorIfSelected(Vector<Boolean> vectorIfSelected) {
//        this.vectorIfSelected = vectorIfSelected;
//    }

    public void addItem(String iName, String iAuthor, String iPublisher, String iISBN) {
        vectorName.add(iName);
        vectorAuthor.add(iAuthor);
        vectorPublisher.add(iPublisher);
        vectorISBN.add(iISBN);
        model.writeLine(iName + "&&&" + iAuthor + "&&&" + iPublisher + "&&&" + iISBN);
    }

    public int[] findItem(String keyWord) {
        Vector<Integer> found = new Vector<>();
        int count = 0;
        for (String line : model.readLine()) {
            if (line == null) continue;
            if (line.contains(keyWord)) {
                found.add(count);
            }
            count++;
        }
        int[] foundList = new int[found.size()];
        for (int i = 0; i < found.size(); i++) {
            foundList[i] = found.get(i);
        }
        return foundList;
    }

    BookCtrl() {
        Vector<String> lines = model.readLine();
        String[] temp;
        for (String line : lines) {
            if (line == null) continue;
            temp = line.split("&&&");
            vectorName.add(temp[0]);
            vectorAuthor.add(temp[1]);
            vectorPublisher.add(temp[2]);
            vectorISBN.add(temp[3]);
        }
    }
}
