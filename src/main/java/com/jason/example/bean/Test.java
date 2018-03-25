package com.jason.example.bean;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author jason-geng
 * @date 3/20/18
 */
@RequiredArgsConstructor
public class Test {
    public final String L;
    @NonNull private String a;
    private String b;
    private List<String> c;


}
