package com.example.friendslistcrud.controller;

import com.example.friendslistcrud.entity.Friend;
import com.example.friendslistcrud.service.FriendService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FriendsController {

    private FriendService friendservice;
    public FriendsController(FriendService friendservice) {
        super();
        this.friendservice = friendservice;
    }
    @GetMapping("/friends")
    public String listEmp(Model model) {
        model.addAttribute("friends", friendservice.getAllFriends());
        return "friends";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/friends/new")
    public String createFriendFor(Model model) {
        Friend friend = new Friend();
        model.addAttribute("friend", friend);
        return "create_friend";

    }

    @PostMapping("/friends")
    public String saveFriend(@ModelAttribute("friend") Friend friend) {
        friendservice.saveFriend(friend);
        return "redirect:/friends";
    }

    @GetMapping("/friends/edit/{id}")
    public String editFriendForm(@PathVariable Long id, Model model) {
        model.addAttribute("friend", friendservice.getFriendById(id));
        return "edit_friend";
    }

    @PostMapping("/friends/{id}")
    public String updateFriend(@PathVariable Long id,
                            @ModelAttribute("friend") Friend friend,
                            Model model) {

        Friend existingFriend = friendservice.getFriendById(id);
        existingFriend.setId(id);
        existingFriend.setFirstName(friend.getFirstName());
        existingFriend.setLastName(friend.getLastName());
        existingFriend.setEmail(friend.getEmail());
        existingFriend.setAge(friend.getAge());

        friendservice.updateFriend(friend);
        return "redirect:/friends";
    }


    @GetMapping("/friends/{id}")
    public String deleteFriendById(@PathVariable Long id) {
        friendservice.deleteFriendById(id);
        return "redirect:/friends";
    }
}
