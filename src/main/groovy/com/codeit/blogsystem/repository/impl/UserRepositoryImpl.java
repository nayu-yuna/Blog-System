package com.codeit.blogsystem.repository.impl;

import com.codeit.blogsystem.entity.User;
import com.codeit.blogsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final FileDataManager fileDataManager;
    private static final String FILE_NAME = "user.ser";
    private Map<String, User> userMap;

    public UserRepositoryImpl() {
        this.fileDataManager = new FileDataManager(FILE_NAME);
        this.userMap = loadUserList();
    }

    private void saveUserList() {
        fileDataManager.saveObjectToFile(userMap);
    }

    private Map<String, User> loadUserList() {
        Map<String, User> loadedData = fileDataManager.loadObjectFromFile();
        if (loadedData == null) {
            return new HashMap<>();
        }
        return loadedData;
    }

    @Override
    public void save(User user) {
        userMap.put(user.getId(), user);
        saveUserList();  // 파일에 저장
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        return userMap.containsKey(id);
    }
}
