package com.app.godfather.godsons.domain.dto;

import java.io.Serializable;

/**
 * Created by stant on 22/10/16.
 */
public class GodsonDto implements Serializable {

    private String mGuid;
    private String name;

    public GodsonDto(String guid, String name) {
        this.mGuid = guid;
        this.name = name;
    }

    public String getmGuid() {
        return mGuid;
    }

    public void setmGuid(String mGuid) {
        this.mGuid = mGuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
