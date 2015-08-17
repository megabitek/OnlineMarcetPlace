/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author admin
 * @param <T>
 */
public interface IDao <T>  {
    public void insert(T t);
    public void delete (T t);
    public void update (T t);
    public T searchByID (int id);
    public List<T> getList();

}
