package com.notes.notes.repository;
import com.notes.notes.model.note;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NotesRepository extends JpaRepository<note, Long> {
    
}
