package Lol;


    public class Stack {
        private LinkEntry top;
        public Stack(){ 
            top=null;
        }
        
        public void push(Object element){
        
            LinkEntry entry = new LinkEntry(element, top);
            top = entry;
        }
        
        public Object pop(){
            LinkEntry entry = top;
            top = top.getLink();
            return entry.getElement();
        }
        
        public Object peek(){return top.getElement();}
        
        public boolean empty(){ return top == null;}
        
        public boolean full(){
            LinkEntry entry = new LinkEntry(null, null);
            return entry == null;
        }
    }