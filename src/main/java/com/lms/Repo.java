package com.lms;

import java.util.List;

public class Repo<T> {
        void add(T item) {

        }
    
        void update(T item) {

        }
    
        void delete(int id) {

        }
    
        T getById(int id) {
            return null; // Trả về null nếu không tìm thấy
        }

        T getByName(String name) {
            return null; // Trả về null nếu không tìm thấy
        }
    
        List<T> getAll() {

            return null; // Trả về null nếu không có đối tượng nào
        }

        T existsById(T item) {
            return null; // Trả về null nếu không tìm thấy
        }

        void hide(T item) {

        }
        
        void show(T item) {

        }
}
