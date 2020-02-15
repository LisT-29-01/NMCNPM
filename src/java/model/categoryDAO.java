/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.Category;
import model.Category;

/**
 *
 * @author dell
 */
public interface categoryDAO {
    public ArrayList<Category> getParentcate();
    public ArrayList<Category> getChildrencate(int parent_cate);
    public ArrayList<Category> getAllChildcate();
}
