package com.example.simplecalc;

public class indoor_model {
    private String tree_name1;
    private String tree_name2;
    private int tree_img;


    public indoor_model(String tree_name1, String tree_name2, int tree_img) {
        this.tree_name1 = tree_name1;
        this.tree_name2 = tree_name2;
        this.tree_img = tree_img;
    }


    public String getTree_name1() {
        return tree_name1;
    }

    public void setTree_name1(String tree_name1) {
        this.tree_name1 = tree_name1;
    }

    public String getTree_name2() {
        return tree_name2;
    }

    public void setTree_name2(String tree_name2) {
        this.tree_name2 = tree_name2;
    }

    public int getTree_img() {
        return tree_img;
    }

    public void setTree_img(int tree_img) {
        this.tree_img = tree_img;
    }
}
