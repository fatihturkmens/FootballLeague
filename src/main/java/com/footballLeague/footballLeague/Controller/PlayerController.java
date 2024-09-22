package com.footballLeague.footballLeague.Controller;

import com.footballLeague.footballLeague.Entity.Player;
import com.footballLeague.footballLeague.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/all")       // TÜM FUTBOLCULAR
    public ResponseEntity<List<Player>> getAllPlayers(){
        List<Player> playerlist = playerService.getAllPlayers();
        return new ResponseEntity<>(playerlist, HttpStatus.OK);
    }

    @PostMapping("add")         // YENİ FUTBOLCU EKLEME
    public ResponseEntity<Player> add(@RequestBody Player player){
       Player savedplayer= playerService.addplayer(player);
       return new ResponseEntity<>(player,HttpStatus.CREATED);
    }
    @PutMapping("update")   // FUTBOLCU GÜNCELLEME
    public ResponseEntity<Player>update(@RequestBody Player player){
      Player updatedplayer =  playerService.updateplayer(player);
      if (updatedplayer != null){
          return new ResponseEntity<>(updatedplayer,HttpStatus.OK);

      }
      else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
    @DeleteMapping("delete/{name}")   // FUTBOLCU SİLME
    public ResponseEntity<String> delete(@PathVariable String name){
        playerService.deletePlayerByName(name);
        return ResponseEntity.ok("DELETED");
    }


}
