
package com.altv.dugout_domain.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


public class News implements Serializable {

    @Setter
    @Getter
    private String key;
    @Setter
    @Getter
    private String title;
    @Setter
    @Getter
    private String text;
    @Setter
    @Getter
    private String imageUrl;
    @Setter
    @Getter
    private String teamName;
    @Setter
    @Getter
    private String teamCode;
}
