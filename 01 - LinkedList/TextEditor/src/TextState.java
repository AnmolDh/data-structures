public class TextState {
    private String content;
    private TextState prev;
    private TextState next;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TextState getPrev() {
        return prev;
    }

    public void setPrev(TextState prev) {
        this.prev = prev;
    }

    public TextState getNext() {
        return next;
    }

    public void setNext(TextState next) {
        this.next = next;
    }

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return content;
    }
}