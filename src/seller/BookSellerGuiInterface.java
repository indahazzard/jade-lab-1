package seller;

public interface BookSellerGuiInterface {
    void setAgent(BookSellerAgent a);
    void show();
    void hide();
    void notifyUser(String message);
    void dispose();
}