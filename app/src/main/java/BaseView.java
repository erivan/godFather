/**
 * Created by root on 21/10/16.
 */
public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
