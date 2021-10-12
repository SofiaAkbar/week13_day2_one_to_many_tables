package com.codeclan.example.foldersservice.repositories;

import com.codeclan.example.foldersservice.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
