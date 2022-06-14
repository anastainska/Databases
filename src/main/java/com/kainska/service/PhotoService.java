package com.kainska.service;

import com.kainska.Repository.PhotoRepository;
import com.kainska.domain.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class PhotoService {
    @Autowired
    PhotoRepository photoRepository;

    public List<Photo> findAll() throws Exception {
        List<Photo> photos = new LinkedList<>(photoRepository.findAll());
        if (photos.isEmpty()) {
            return null;
        }
        return photos;
    }

    public Photo findById(Integer id) throws Exception {
        if (photoRepository.findById(id).isPresent()) {
            return photoRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Photo entity) throws Exception {
        if (entity != null) {
            photoRepository.save(entity);
        }
    }

    @Transactional
    public void update(Photo photo) throws Exception {
        photoRepository.findById(photo.getId())
                .map(oldEntity -> {
                    oldEntity.setPhoto(photo.getPhoto());
                    oldEntity.setPostId(photo.getPostId());
                    oldEntity.setStoryId(photo.getStoryId());
                    return photoRepository.save(oldEntity);
                })
                .orElseGet(() -> photoRepository.save(photo));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (photoRepository.findById(id).isPresent()) {
            photoRepository.delete(findById(id));
        }
    }
}
