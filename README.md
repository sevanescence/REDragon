# REDragon
RE:Dragon allows ender dragon eggs to drop from all ender dragon deaths after the first ender dragon.

config.yml
```yml
#######################
# RE: DRAGON v1.0.0   #
#######################
# configuration file  #
#######################

# leave this empty, or write "null", to disable
egg-drop-message: "&8[&dRE:Dragon&8] &7The dragon egg has dropped at &b%drop-location%&7!"

# this is what the coordinates will look like
drop-location-format: "&bX:%x%&7, &bY:%y%&7, &bZ:%z%"
```

logic:
```VisualBasic
on mob death:
  mob isnt an ender dragon?:
    return
  loop all blocks along y-axis of the ender dragon:
    is current block air, and block under, not air?:
      place dragon egg
      break loop
    is ender dragon over the void?:
      place obsidian
      place dragon egg over obsidian
  is "egg-drop-message" from config.yml "null"?:
    return
  does "egg-drop-message" from config.yml contain "%drop-location%"?:
    replace drop-location placeholders with coordinates of dragon egg
  broadcast formatted egg-drop-message
  ```
