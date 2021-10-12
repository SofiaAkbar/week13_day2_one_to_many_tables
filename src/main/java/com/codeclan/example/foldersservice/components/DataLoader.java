package com.codeclan.example.foldersservice.components;

import com.codeclan.example.foldersservice.models.File;
import com.codeclan.example.foldersservice.models.Folder;
import com.codeclan.example.foldersservice.models.User;
import com.codeclan.example.foldersservice.repositories.FileRepository;
import com.codeclan.example.foldersservice.repositories.FolderRepository;
import com.codeclan.example.foldersservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args) {

        User user1 = new User("user1");
        userRepository.save(user1);

        Folder folder1 = new Folder("week1", user1);
        folderRepository.save(folder1);

        File important = new File("important", "java", "30gb", folder1);
        fileRepository.save(important);

        folder1.addFile(important);
        folderRepository.save(folder1);

        user1.addFolder(folder1);
        userRepository.save(user1);
    }
}
