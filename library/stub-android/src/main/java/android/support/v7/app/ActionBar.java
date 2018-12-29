package android.support.v7.app;

public abstract class ActionBar {
    public ActionBar() {
        throw new RuntimeException("Stub!");
    }

    abstract public void show();

    abstract public void hide();

    abstract public CharSequence getTitle();

    abstract public void setTitle(CharSequence title);
}
