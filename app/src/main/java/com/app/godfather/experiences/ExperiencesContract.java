package com.app.godfather.experiences;

import java.util.List;

/**
 * Created by stant on 21/10/16.
 */
public class ExperiencesContract {

    interface View {
        void callHelp();
        void shareExperience();
    }

    interface Presenter{
        void loadGodsons(String godFatherGuid);
    }

}
