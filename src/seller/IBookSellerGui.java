package seller;

public interface IBookSellerGui {
    void setAgent(BookSellerAgent a);
    void show();
    void hide();
    void notifyUser(String message);
    void dispose();
}