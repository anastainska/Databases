package com.kainska.service;

import com.kainska.dao.PhotoDao;
import com.kainska.model.Photo;

import java.util.ArrayList;

public class PhotoService {

    public ArrayList<String[]> findAllPhoto() {
        return new PhotoDao().findAll();
    }

    public Photo findPhotoById(int id) {
        return new PhotoDao().findById(id);
    }

    public void createPhoto(Photo Photo) {
        new PhotoDao().create(Photo);
    }

    public void updatePhoto(Photo photo) {
        new PhotoDao().update(photo);
    }

    public void deletePhoto(int id) {
        new PhotoDao().delete(id);
    }
}