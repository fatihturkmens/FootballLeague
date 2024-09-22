package com.footballLeague.footballLeague.Service;

import com.footballLeague.footballLeague.Entity.Player;
import com.footballLeague.footballLeague.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;


    public List<Player> getAllPlayers(){      // tüm futbolcuları görüntüleme
       return playerRepository.findAll();
    }

    public List<Player> getPlayerFromTeam(String teamname){       // aynı takımdaki futbolcuları görüntüleme
       return playerRepository.findAll().stream().filter(player -> teamname.equals(player.getTeam())).collect(Collectors.toList());
    }
    public List<Player> getPlayerFromName(String name){           // Aynı isimdeki  futbolcuları görüntüleme
        return playerRepository.findAll().stream().filter(player -> name.equals(player.getName())).collect(Collectors.toList());
    }

    public List<Player> getPlayerFromNation(String nation){        // Aynı ülkeli futbolcuları görüntüleme
        return playerRepository.findAll().stream().filter(player -> nation.equals(player.getNation())).collect(Collectors.toList());
    }
    public List<Player> getPlayerFromAge(Integer age){             // Aynı yaştakı futbolcuları görüntüleme
        return playerRepository.findAll().stream().filter(player -> age.equals(player.getAge())).collect(Collectors.toList());
    }
    public Player addplayer(Player player){       // yeni bir futbolcu ekleme
        return playerRepository.save(player);
    }
    public Player updateplayer(Player player) {     // futbolcu bilgileri güncelleme
        Optional<Player> player1 = playerRepository.findById(player.getId());
        if (player1.isPresent()) {
            Player player2 = player1.get();

            player2.setName(player.getName());
            player2.setNation(player.getNation());
            player2.setName(player.getTeam());
            player2.setAge(player.getAge());
            player2.setPosition(player.getPosition());
            player2.setMarketvalues(player.getMarketvalues());
            playerRepository.save(player2);
            return player2;


        }
        return null;
    }
    public void deletePlayerByName(String name){
        playerRepository.deleteByName(name);
    }
}


