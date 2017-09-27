package com.osu.cse3341.Scanner;

/**
 * Created by liuzhenyu on 9/25/17.
 */

public class TokenItem {
    public TOKEN type;
    public String val;

    public TokenItem(TOKEN type, String val) {
        this.type = type;
        this.val = val;
    }
}

