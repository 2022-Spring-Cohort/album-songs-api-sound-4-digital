package org.wcci.apimastery.Repository;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.entity.Song;

import java.util.Optional;

public interface Album extends CrudRepository<Album, Long> {
    Optional<Album> findByNameIgnoreCase(String title);
}
