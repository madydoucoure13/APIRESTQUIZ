package com.yougo.APIRESTTP.controllers;

import com.yougo.APIRESTTP.model.Utilisateur;
import com.yougo.APIRESTTP.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("utilisateur/")
@RestController
public class UtilisateurController {

    private final UtilisateurService userService;

    @Autowired
    public UtilisateurController(UtilisateurService userService){
        this.userService = userService;
    }
    @PutMapping("{id}")
    public Utilisateur getUseByIdr(@PathVariable Long id){
        Optional<Utilisateur> user = userService.getUtilisateurById(id);
        return (Utilisateur) user.orElse(null);
    }
    @PutMapping("update/{id}")
    public Utilisateur updateUtilisateur(@PathVariable Long id,@RequestBody Utilisateur utilisateur){
        Optional<Utilisateur> user = Optional.ofNullable(userService.editUtilisateur(id, utilisateur));
        return (Utilisateur) user.orElse(null);
    }
    @DeleteMapping("delete/")
    public  Boolean test(@PathVariable Long id){
        return userService.deleteUtilisateurById(id);
    }
    @GetMapping("")
    public Optional<List> getUsers(){
        Optional<List> user = Optional.ofNullable(userService.getAllUtilisateur());
        return Optional.ofNullable(user.orElse(null));
    }
    @PostMapping("creer")
    public Utilisateur create(@RequestBody Utilisateur utilisateur){
        return userService.createUtilisateur(utilisateur);
    }
}