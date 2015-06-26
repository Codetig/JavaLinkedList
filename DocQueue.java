
import java.util.Scanner;
public class DocQueue{
  private Document last;

  public static void main(String[] args) {
    DocQueue queue = new DocQueue();

    controller(queue);

    System.out.println("Thank you for using the DocQueue.");
  }

  public static void controller(DocQueue queue) {
    Scanner input = new Scanner(System.in);
    System.out.println("Type what you want to do? ('push', 'pop', 'display', 'end')");
    String response = input.next();

    if(response.equalsIgnoreCase("pop")) {
      Document popped = queue.pop();
      System.out.println("Title: " + popped.getTitle() + "  Type: " + popped.getType());
    } else if(response.equalsIgnoreCase("display")) {
      System.out.println(queue.listAll());
    } else if(response.equalsIgnoreCase("push")) {
      input.nextLine(); //consume the leftover nextline character
      //get title from the user
      System.out.println("Please type a title for your document: ");
      String userTitle = input.nextLine();

      //get type from the user
      System.out.println("Type 1 for a PDF Document and 2 for a Word Document");
      int dtype = input.nextInt();

      if(dtype == 1) {
        queue.push(new PdfDocument(userTitle));
      } else if (dtype == 2) {
        queue.push(new WordDocument(userTitle));
      } else {
        System.out.println("Invalid Type-number. Document was not added.");
      }

    } else if(response.equalsIgnoreCase("end")){
      return;
    } else {
      System.out.println("Invalid command. Please try again.");
    }

    controller(queue);
  }

  public DocQueue(){
    last = null;
  }

  public DocQueue(Document doc){
    last = doc;
  }

  public void push(Document doc) {
    if(last == null) {
      last = doc;
    } else {
      doc.setNext(last);
      last = doc;
    }
  }

  public String listAll(){
    if(last == null) return null;
    Document temp = last;
    String result = "\nTitle: " + last.getTitle() + "  Type: " + last.getType();
    while (temp.getNext() != null){
      result = "\nTitle: " + (temp.getNext()).getTitle() + "  Type: " + (temp.getNext()).getType() + result;
      temp = temp.getNext();
    }
    return result;
  }

  public Document pop() {
    if( last == null) return null;
    if(last.getNext() == null){
      Document t = last;
      last = null;
      return t; 
    }

    Document temp = last;

    while((temp.getNext()).getNext() != null) {
      temp = temp.getNext();
    }
    return temp.removeNext();
  }
}

class Document{
  private String title;
  private Document nextDoc;
  
  //public Document(){}

  public String getTitle() {
    return title;
  }
  
  protected void setTitle(String str){
    title = str;
  }

  public String getType(){
    if(this instanceof PdfDocument) {
      return "PDF Document";
    } else {
      return "Word Document";
    }

  }

  protected void setNext(Document doc){
    nextDoc = doc;
  }

  protected Document getNext(){
    return nextDoc;
  }

  protected Document removeNext(){
    Document temp = nextDoc;
    nextDoc = null; 
    return temp;
  }
}

class PdfDocument extends Document{
  private int numDoc = 0;
  public PdfDocument(String title) {
    super.setTitle(title);
    numDoc++;
  }

  public PdfDocument(){
    setTitle("PDF Doc" + (numDoc + 1));
    // this("PDF Doc" + (numDoc + 1)); // could not do this?
    numDoc++;
  }

}

class WordDocument extends Document{
  private int numDoc;

  public WordDocument(String title) {
    super.setTitle(title);
    numDoc++;
  }


  public WordDocument(){
    super.setTitle("Word Doc" + numDoc);
    numDoc++;
  }
}