package com.app.godfather.godsons;

/**
 * Created by stant on 22/10/16.
 */
public class GodsonsContract {

    interface View {
        void offerHelp(String godsonGuid);
    }

    interface Presenter{
        void loadGodsons(String godFatherGuid);
    }

}
