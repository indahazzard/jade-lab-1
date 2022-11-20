package buyer;

public interface BookBuyerGuiInterface {
    void setAgent(BookBuyerAgent a);
    void show();
    void hide();
    void notifyUser(String message);
    void dispose();
}
