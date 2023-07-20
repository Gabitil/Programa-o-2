package Lol;
public class LinkEntry {
    private Object element;
    private LinkEntry link;
    
    public LinkEntry(Object element, LinkEntry link){
        this.element= element;
        this.link = link;
    }
        
    public Object getElement(){return element;}
    
    public LinkEntry getLink(){return link;}
    
    public void setLink(LinkEntry newlink){link = newlink;}
}
