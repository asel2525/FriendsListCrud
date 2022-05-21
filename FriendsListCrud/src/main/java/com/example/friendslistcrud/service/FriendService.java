package com.example.friendslistcrud.service;

import com.example.friendslistcrud.entity.Friend;

import java.util.List;

public interface FriendService {

    List<Friend> getAllFriends();

    Friend saveFriend(Friend friend);

    Friend getFriendById(Long id);

    Friend updateFriend(Friend friend);

    void deleteFriendById(Long id);

    void deleteAllFriends();



}
