# JavaLinkedList
Implementation of linked list without using arrays, arraylist or other containing structures.

<b>Context</b> <br>
This was an excercise I recently did. I stumbled on my first try and decided I had to get it. So I coded it based on what I remembered from the exercise. I am still growing in my java programming skills, so feel free to suggest improvements.

<b>Description</b> <br>
There are four classes:<br>
1. A base class, Document, that has the node-like feature. Pretty simple with two attributes title and nextDoc<br> 
2. A simple PdfDocument subclass of Document with overloaded constructor.<br>
3. A simple WordDocument subclass of Document with overloaded constructor.<br>
4. A Main class DocQueue which allow the creation of PdfDocuments and WordDocuments that can be added to the queue (push method). It also allows the removal of the first document in the queue (pop method) and a string representation (title and type of document) of the entire list (listAll method).
