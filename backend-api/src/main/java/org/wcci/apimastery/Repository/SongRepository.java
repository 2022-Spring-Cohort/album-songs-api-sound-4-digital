package org.wcci.apimastery.Repository;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.entity.Song;

import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long> {
    Optional<Song> findByNameIgnoreCase(String title);
}
