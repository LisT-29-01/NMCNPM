/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dell
 */
public class Category {
    private int category_id;
    private String name;
    private int parent_cate;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent_cate() {
        return parent_cate;
    }

    public void setParent_cate(int parent_cate) {
        this.parent_cate = parent_cate;
    }
    
}
