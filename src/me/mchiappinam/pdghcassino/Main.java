package me.mchiappinam.pdghcassino;

import java.io.File;
import java.util.Random;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
  public void onEnable() {
	    getServer().getPluginManager().registerEvents(this, this);
		File file = new File(getDataFolder(),"config.yml");
		if(!file.exists()) {
			try {
				saveResource("config_template.yml",false);
				File file2 = new File(getDataFolder(),"config_template.yml");
				file2.renameTo(new File(getDataFolder(),"config.yml"));
			}
			catch(Exception e) {}
		}
		getServer().getConsoleSender().sendMessage("§3[PDGHCassino] §2ativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHCassino] §2Acesse: http://pdgh.com.br/");
  }

  public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHCassino] §2desativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHCassino] §2Acesse: http://pdgh.com.br/");
  }

  @EventHandler
  public void sce(SignChangeEvent e) {
    if (e.getLine(0).equalsIgnoreCase("[cassino]"))
      if (!e.getPlayer().hasPermission("pdgh.vip")) {
			e.getPlayer().sendMessage("§3[ⒸⒶⓈⓈⒾⓃⓄ] §cApenas §6§lVIP §cpode criar cassino");
			e.getPlayer().sendMessage("§3[ⒸⒶⓈⓈⒾⓃⓄ] §cAdquira seu §6§lVIP §cem www.pdgh.com.br");
			e.getBlock().breakNaturally();
      } else {
        e.setLine(0, "§e[ⒸⒶⓈⓈⒾⓃⓄ]");
        e.setLine(1, "");
        e.setLine(2, "");
        e.setLine(3, "");
        e.getPlayer().sendMessage("§3[ⒸⒶⓈⓈⒾⓃⓄ] §eCassino criado com sucesso");
      }
  }

  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerInteract(PlayerInteractEvent ev) {
    if (ev.getAction() == Action.RIGHT_CLICK_BLOCK) {
      Block b = ev.getClickedBlock();
      if ((b.getType() == Material.SIGN_POST) || (b.getType() == Material.WALL_SIGN)) {
        Sign s = (Sign)b.getState();
        Player p = ev.getPlayer();
        if ((s.getLine(0).equalsIgnoreCase("§e[ⒸⒶⓈⓈⒾⓃⓄ]"))) {
          if(p.getItemInHand().getType()==Material.MONSTER_EGG) { //Ficha
        	  if(p.getItemInHand().getAmount()==1)
        		  p.setItemInHand(new ItemStack(Material.AIR));
        	  else
        		  p.getItemInHand().setAmount(p.getItemInHand().getAmount()-1);
        	  p.updateInventory();

            Random rand = new Random();

            for (int counter = 1; counter <= 1; counter++) {
              int hero = 1 + rand.nextInt(20);

              if (hero == 1) {
                ItemStack premio1 = new ItemStack(Material.getMaterial(getConfig().getInt("Premio")), 1); //Prêmio
                PlayerInventory pi = p.getInventory();
                pi.addItem(new ItemStack[] { premio1 });
                p.sendMessage((" "));
                p.sendMessage("§3[ⒸⒶⓈⓈⒾⓃⓄ] §eParabéns, você venceu!");
                p.sendMessage((" "));
                p.updateInventory();
                s.setLine(0, "§e[ⒸⒶⓈⓈⒾⓃⓄ]");
                s.setLine(1, "§cParabéns,");
                s.setLine(2, "§2você §lVENCEU!");
                s.setLine(3, "§3"+ev.getPlayer().getName());
                s.update();
              } else if (hero == 2) {
            	  perdeu(p,ev);
              } else if (hero == 3) {
            	  perdeu(p,ev);
              } else if (hero == 4) {
            	  perdeu(p,ev);
              } else if (hero == 5) {
            	  perdeu(p,ev);
              } else if (hero == 6) {
            	  perdeu(p,ev);
              } else if (hero == 7) {
            	  perdeu(p,ev);
              } else if (hero == 8) {
            	  perdeu(p,ev);
              } else if (hero == 9) {
            	  perdeu(p,ev);
              } else if (hero == 10) {
            	  perdeu(p,ev);
              } else if (hero == 11) {
            	  perdeu(p,ev);
              } else if (hero == 12) {
            	  perdeu(p,ev);
              } else if (hero == 13) {
            	  perdeu(p,ev);
              } else if (hero == 14) {
            	  perdeu(p,ev);
              } else if (hero == 15) {
            	  perdeu(p,ev);
              } else if (hero == 16) {
            	  perdeu(p,ev);
              } else if (hero == 17) {
            	  perdeu(p,ev);
              } else if (hero == 18) {
            	  perdeu(p,ev);
              } else if (hero == 19) {
            	  perdeu(p,ev);
              } else if (hero == 20) {
            	  perdeu(p,ev);
              }
            }
          } else {
            p.sendMessage("§3[ⒸⒶⓈⓈⒾⓃⓄ] §eVocê não está com a ficha na mão.");
          }
        }
      }
    }
  }
  
  

  @SuppressWarnings("deprecation")
  public void perdeu(Player p, Event ev) {
      Block b = ((PlayerInteractEvent) ev).getClickedBlock();
      Sign s = (Sign)b.getState();
      ItemStack premio2 = new ItemStack(Material.AIR, 1);
      PlayerInventory pi2 = p.getInventory();
      pi2.addItem(new ItemStack[] { premio2 });
      p.sendMessage("§3[ⒸⒶⓈⓈⒾⓃⓄ] §eVocê perdeu. Continue tentando.");
      p.updateInventory();
      s.setLine(0, "§e[ⒸⒶⓈⓈⒾⓃⓄ]");
      s.setLine(1, "§cInfelizmente");
      s.setLine(2, "§cvocê §lPERDEU");
      s.setLine(3, "§3"+((PlayerInteractEvent) ev).getPlayer().getName());
      s.update();
  }
  
  
  
  
  
}