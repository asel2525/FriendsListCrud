package com.example.friendslistcrud.service;

import com.example.friendslistcrud.entity.Friend;
import com.example.friendslistcrud.repository.FriendRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService{


    private FriendRepository friendRepository;

    public FriendServiceImpl(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @Override
    public List<Friend> getAllFriends() {
        return friendRepository.findAll();
    }

    @Override
    public Friend saveFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    @Override
    public Friend getFriendById(Long id) {
        return friendRepository.findById(id).get();
    }

    @Override
    public Friend updateFriend(Friend friend) {
        return friendRepository.save(friend);
    }


    @Override
    public void deleteFriendById(Long id) {
        friendRepository.deleteById(id);
    }

    @Override
    public void deleteAllFriends(){
        friendRepository.deleteAll();
    }




}
