# A free highly configurable 1.8-1.20 spigot plugin allowing you to make blocks infinite for a configurable price.

Configuration:
```yml
messages:
  vouchergive: "&6&lRandomVouchers &8&l→ &7You have been given a %voucher% voucher."
  nopermission: "&cYou do not have permission to run this command."
  helpmessage:
    - "&6&lRandomVouchers Help &7(Page 1/1)"
    - " "
    - "&6&lCommands:"
    - "&e/randomvouchers help &8- &7View this help menu."
    - "&e/randomvouchers give (player) (identifier) (amount) &8- &7Give a player a random voucher."
randomvouchers:
  mysteryorevoucher: # identifier
    material: PAPER # material for the item
    displayname: "&b&lMystery Ore Voucher &8&l(( &fRight Click &8&l))"
    lore:
      - "&8&l→ &61x &b&lDIAMOND"
      - "&8&l→ &61x &6&LGOLD INGOT"
      - "&8&l→ &61x &7&lIRON INGOT"
      - " "
      - "&7(( Right click to recieve a random reward from this voucher ))"
    rewards: # add as many rewards as you'd like
      1:
        command: "give %player% diamond 1"
        message: "&6&lRandomVouchers &8&l→ &7You have won a &b&lDIAMOND."
      2:
        command: "give %player% gold_ingot 1"
        message: "&6&lRandomVouchers &8&l→ &7You have won a &6&LGOLD INGOT."
      3:
        command: "give %player% iron_ingot 1"
        message: "&6&lRandomVouchers &8&l→ &7You have won a &7&lIRON INGOT."
        # to add a reward simply copy and paste the previous one under it and change the number to be 4
  mysteryitemvoucher:
    material: PAPER
    displayname: "&6&lMystery Item Voucher &8&l(( &fRight Click &8&l))"
    lore:
      - "&8&l→ &61x &6&lSTICK"
      - "&8&l→ &61x &d&lDIRT"
      - "&8&l→ &61x &7&lCOBBLESTONE"
      - " "
      - "&7(( Right click to recieve a random reward from this voucher ))"
    rewards:
      1:
        command: "give %player% stick 1"
        message: "&6&lRandomVouchers &8&l→ &7You have won a &6&lSTICK."
      2:
        command: "give %player% dirt 1"
        message: "&6&lRandomVouchers &8&l→ &7You have won a piece of &d&lDIRT."
      3:
        command: "give %player% cobblestone 1"
        message: "&6&lRandomVouchers &8&l→ &7You have won a piece of &7&lCOBBLESTONE."
```
